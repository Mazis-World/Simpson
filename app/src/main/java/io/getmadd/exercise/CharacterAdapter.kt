package io.getmadd.exercise

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.getmadd.exercise.api.RelatedTopic
import java.security.AccessController.getContext

class CharacterAdapter(private val characters: List<RelatedTopic>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val buttonText: Button = itemView.findViewById(R.id.character_name_buttonView)

        fun bind(character: RelatedTopic) {
            buttonText.text = character.FirstURL
            buttonText.setOnClickListener{
                val intent = Intent(itemView.context, CharacterDetailActivity::class.java)
                intent.putExtra("Character",character)
                itemView.context.startActivity(intent)
            }
        }
    }
}
