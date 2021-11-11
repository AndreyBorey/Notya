package dev.borisovandrey.notya.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dev.borisovandrey.notya.R
import dev.borisovandrey.notya.model.Note

class NotesListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<Note> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is NoteViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(noteList: List<Note>) {
        items = noteList
    }

    class NoteViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder (itemView){
        val noteIcon: ImageView = itemView.findViewById(R.id.ivNoteIcon)
        val noteTitle: TextView = itemView.findViewById(R.id.tvNoteTitle)
        val noteBody: TextView = itemView.findViewById(R.id.tvNoteBody)

        fun bind(Note:Note){
            noteTitle.setText(Note.title)
            noteBody.setText(Note.body)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(Note.image)
                .into(noteIcon)
        }
    }
}