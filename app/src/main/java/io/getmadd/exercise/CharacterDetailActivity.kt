package io.getmadd.exercise

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import io.getmadd.exercise.api.RelatedTopic

class CharacterDetailActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        val textView: TextView = findViewById(R.id.character_title_textView) as TextView

        val receivedObject = intent.getSerializableExtra("Character",RelatedTopic::class.java)
        if (receivedObject != null) {
            // Use the received object
            val title = receivedObject.FirstURL
            val photo = receivedObject.Icon.URL
            val description = receivedObject.Text
        }
    }
}