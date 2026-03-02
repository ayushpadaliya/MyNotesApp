package com.example.notesapp.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.R
import com.example.notesapp.adapter.ViewNotesAdapter
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.model.Notes

class ViewNotesActivity : AppCompatActivity() {
    lateinit var adapter: ViewNotesAdapter
    lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        setRecycleView()
    }

    private fun setRecycleView() {
        /*val notesList = ArrayList<Notes>()
        notesList.add(
            Notes("1","WorkOut","Workout from the 8th Am to 10 AM","2026-02-01")
        )*/
        b.rvNotes.layoutManager = LinearLayoutManager(this@ViewNotesActivity)
        adapter = ViewNotesAdapter(this@ViewNotesActivity, emptyList())
        b.rvNotes.adapter = adapter
    }
}