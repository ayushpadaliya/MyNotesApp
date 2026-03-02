package com.example.notesapp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesapp.adapter.ViewNotesAdapter
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.model.Notes
import java.io.Serializable

class ViewNotesActivity : AppCompatActivity() {

    var notesList = mutableListOf<Notes>()
    lateinit var adapter: ViewNotesAdapter
    lateinit var b: ActivityMainBinding

    private val addEditNoteLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val type = data?.getStringExtra("type")
            val title = data?.getStringExtra("title").toString()
            val desc = data?.getStringExtra("desc").toString()
            val date = data?.getStringExtra("date").toString()
            val id = data?.getStringExtra("id")

            if (type == "Add") {
                notesList.add(Notes((notesList.size + 1).toString(), title, desc, date))
                adapter.updateData(notesList)
            } else if (type == "Edit") {
                for (i in 0 until notesList.size) {
                    if (notesList[i].id == id) {
                        notesList[i].title = title
                        notesList[i].description = desc
                        notesList[i].date = date
                        adapter.updateData(notesList)
                        break
                    }
                }
            }
            updateEmptyViewVisibility()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        setRecycleView()
        setUpClick()
        updateEmptyViewVisibility()
    }

    private fun updateEmptyViewVisibility() {
        if (notesList.isEmpty()) {
            b.llNoData.visibility = View.VISIBLE
            b.rvNotes.visibility = View.GONE
        } else {
            b.llNoData.visibility = View.GONE
            b.rvNotes.visibility = View.VISIBLE
        }
    }

    private fun setUpClick() {
        b.fabAddNotes.setOnClickListener {
            val intent = Intent(this@ViewNotesActivity, AddEditNotesActivity::class.java)
            intent.putExtra("type", "Add")
            addEditNoteLauncher.launch(intent)
        }
    }

    private fun setRecycleView() {
        b.rvNotes.layoutManager = LinearLayoutManager(this@ViewNotesActivity)
        adapter = ViewNotesAdapter(this@ViewNotesActivity, notesList)
        b.rvNotes.adapter = adapter

        adapter.setUpClickOfNotes(object : ViewNotesAdapter.ClickNote {
            override fun onClickNote(notes: Notes) {
                val intent = Intent(this@ViewNotesActivity, AddEditNotesActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("notes", notes)
                intent.putExtras(bundle)
                intent.putExtra("type", "Edit")
                addEditNoteLauncher.launch(intent)
            }
        })
    }
}