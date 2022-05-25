package com.lalosapps.artspace.data

class ArtworkProvider {
    companion object {
        val images = listOf(
            Artwork(0,"I am strong","God","2022"),
            Artwork(1,"I believe in myself","God","2022"),
            Artwork(2,"Each day is a new opportunity to grow and be a better version of myself","God","2022"),
            Artwork(3,"Every challenge in my life is an opportunity to learn from","God","2022"),
            Artwork(4,"I have so much to be grateful for","God","2022"),
            Artwork(5,"Good things are always coming into my life","God","2022"),
            Artwork(6,"New opportunities await me at every turn","God","2022"),
            Artwork(7,"I have the courage to follow my heart","God","2022"),
            Artwork(8,"Things will unfold at precisely the right time","God","2022"),
            Artwork(9,"I will be present in all the moments that this day brings","God","2022"),
        )
    }
}

data class Artwork(
    val id: Int,
    val title: String,
    val artist: String,
    val year: String
)