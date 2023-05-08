package xyz.stasiak.kochbuch.ui.recipedetails

import android.content.Context
import android.media.MediaPlayer
import xyz.stasiak.kochbuch.R

class SoundPlayer(private val context: Context) {

    private var mediaPlayer: MediaPlayer? = null

    fun playSound() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, R.raw.ringtone);
        }
        mediaPlayer?.start()
    }
}