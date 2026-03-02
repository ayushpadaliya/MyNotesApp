package com.example.notesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.LayoutNoteItemBinding
import com.example.notesapp.model.Notes

class ViewNotesAdapter(
    val context: Context,
    var list: List<Notes>
) : RecyclerView.Adapter<ViewNotesAdapter.ViewHolderNotes>() {

    lateinit var clickNote: ClickNote

    fun updateData(notesList: MutableList<Notes>) {
        this.list = notesList
        notifyDataSetChanged()
    }

    interface ClickNote {
        fun onClickNote(notes: Notes)
    }

    fun setUpClickOfNotes(clickNote: ClickNote) {
        this.clickNote = clickNote
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderNotes {
        val b = LayoutNoteItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolderNotes(b)
    }

    override fun onBindViewHolder(
        holder: ViewHolderNotes,
        position: Int
    ) {
        holder.b.tvNotesHeader.text = list[position].title

        holder.b.cvParentView.setOnClickListener {
            clickNote.onClickNote(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolderNotes(val b: LayoutNoteItemBinding) : RecyclerView.ViewHolder(
        b.root
    )
}