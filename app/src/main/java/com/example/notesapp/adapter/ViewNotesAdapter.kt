package com.example.notesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.databinding.LayoutNoteItemBinding
import com.example.notesapp.model.Notes

class ViewNotesAdapter(
    val context : Context,
    val list : List<Notes>
    ): RecyclerView.Adapter<ViewNotesAdapter.ViewHolderNotes>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderNotes {
        val b  = LayoutNoteItemBinding.inflate(
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

    }

    override fun getItemCount(): Int {
        return 5
    }


    class ViewHolderNotes(val b: LayoutNoteItemBinding): RecyclerView.ViewHolder(
        b.root
    )
}