package com.lalosapps.artspace

import com.lalosapps.artspace.data.ArtworkProvider.Companion.images
import org.junit.Assert.assertEquals
import org.junit.Test

class ArtSpaceTests {

    @Test
    fun get_previous_index_from_first_image_index() {
        val expected = images.lastIndex
        val actual = getPreviousIndex(0)
        assertEquals(expected, actual)
    }

    @Test
    fun get_previous_index_from_last_image_index() {
        val expected = images.lastIndex - 1
        val actual = getPreviousIndex(images.lastIndex)
        assertEquals(expected, actual)
    }

    @Test
    fun get_next_index_from_first_image_index() {
        val expected = 1
        val actual = getNextIndex(0)
        assertEquals(expected, actual)
    }

    @Test
    fun get_next_index_from_last_image_index() {
        val expected = 0
        val actual = getNextIndex(images.lastIndex)
        assertEquals(expected, actual)
    }
}