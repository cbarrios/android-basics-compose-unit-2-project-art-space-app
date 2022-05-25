package com.lalosapps.artspace

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class ArtSpaceUiTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun render_initial_composition() {
        composeTestRule.setContent { MyArtSpaceApp() }
        composeTestRule.onNodeWithContentDescription("0").assertIsDisplayed()
        composeTestRule.onNodeWithText("I am strong").assertExists()
        composeTestRule.onNodeWithText("God").assertExists()
        composeTestRule.onNodeWithText("(2022)").assertExists()
        composeTestRule.onNodeWithTag(PREVIOUS_BUTTON_TAG).assertExists()
        composeTestRule.onNodeWithTag(NEXT_BUTTON_TAG).assertExists()
    }

    @Test
    fun render_previous_from_initial_composition() {
        composeTestRule.setContent { MyArtSpaceApp() }
        composeTestRule.onNodeWithTag(PREVIOUS_BUTTON_TAG).performClick()
        composeTestRule.onNodeWithContentDescription("9").assertIsDisplayed()
        composeTestRule.onNodeWithText("I will be present in all the moments that this day brings")
            .assertExists()
        composeTestRule.onNodeWithText("God").assertExists()
        composeTestRule.onNodeWithText("(2022)").assertExists()
        composeTestRule.onNodeWithTag(PREVIOUS_BUTTON_TAG).assertExists()
        composeTestRule.onNodeWithTag(NEXT_BUTTON_TAG).assertExists()
    }

    @Test
    fun render_previous_from_previous_from_initial_composition() {
        composeTestRule.setContent { MyArtSpaceApp() }
        composeTestRule.onNodeWithTag(PREVIOUS_BUTTON_TAG).performClick()
        composeTestRule.onNodeWithTag(PREVIOUS_BUTTON_TAG).performClick()
        composeTestRule.onNodeWithContentDescription("8").assertIsDisplayed()
        composeTestRule.onNodeWithText("Things will unfold at precisely the right time")
            .assertExists()
        composeTestRule.onNodeWithText("God").assertExists()
        composeTestRule.onNodeWithText("(2022)").assertExists()
        composeTestRule.onNodeWithTag(PREVIOUS_BUTTON_TAG).assertExists()
        composeTestRule.onNodeWithTag(NEXT_BUTTON_TAG).assertExists()
    }

    @Test
    fun render_next_from_initial_composition() {
        composeTestRule.setContent { MyArtSpaceApp() }
        composeTestRule.onNodeWithTag(NEXT_BUTTON_TAG).performClick()
        composeTestRule.onNodeWithContentDescription("1").assertIsDisplayed()
        composeTestRule.onNodeWithText("I believe in myself").assertExists()
        composeTestRule.onNodeWithText("God").assertExists()
        composeTestRule.onNodeWithText("(2022)").assertExists()
        composeTestRule.onNodeWithTag(PREVIOUS_BUTTON_TAG).assertExists()
        composeTestRule.onNodeWithTag(NEXT_BUTTON_TAG).assertExists()
    }

    @Test
    fun render_next_from_previous_from_initial_composition() {
        composeTestRule.setContent { MyArtSpaceApp() }
        composeTestRule.onNodeWithTag(PREVIOUS_BUTTON_TAG).performClick()
        composeTestRule.onNodeWithTag(NEXT_BUTTON_TAG).performClick()
        composeTestRule.onNodeWithContentDescription("0").assertIsDisplayed()
        composeTestRule.onNodeWithText("I am strong").assertExists()
        composeTestRule.onNodeWithText("God").assertExists()
        composeTestRule.onNodeWithText("(2022)").assertExists()
        composeTestRule.onNodeWithTag(PREVIOUS_BUTTON_TAG).assertExists()
        composeTestRule.onNodeWithTag(NEXT_BUTTON_TAG).assertExists()
    }
}