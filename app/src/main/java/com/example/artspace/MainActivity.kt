package com.example.artspace

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var descriptionTextView: TextView
    private lateinit var authorTextView: TextView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private var currentArtworkIndex = 0
    private val artworks = listOf(
        Artwork("The Son of Man", "René Magritte (1964)", R.drawable.photo_1),
        Artwork("The Scream", "Edvard Munch (1893)", R.drawable.photo_2),
        Artwork("The Persistence of Memory", "Salvador Dalí (1931)", R.drawable.photo_3),
        Artwork("Self-portrait without beard", "Vincent van Gogh (1889)", R.drawable.photo_4),
        Artwork("The Cyclops", "Odilon Redon (c. 1914)", R.drawable.photo_5)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        authorTextView = findViewById(R.id.authorTextView)
        previousButton = findViewById(R.id.previousButton)
        nextButton = findViewById(R.id.nextButton)

        previousButton.setOnClickListener {
            previousArtwork()
        }

        nextButton.setOnClickListener {
            nextArtwork()
        }

        displayArtwork()
    }

    private fun previousArtwork() {
        currentArtworkIndex = (currentArtworkIndex - 1 + artworks.size) % artworks.size
        displayArtwork()
    }

    private fun nextArtwork() {
        currentArtworkIndex = (currentArtworkIndex + 1) % artworks.size
        displayArtwork()
    }

    private fun displayArtwork() {
        val artwork = artworks[currentArtworkIndex]
        imageView.setImageResource(artwork.imageResourceId)
        descriptionTextView.text = artwork.description
        authorTextView.text = artwork.author
    }

    data class Artwork(val description: String, val author: String, val imageResourceId: Int)
}
