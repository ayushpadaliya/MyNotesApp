package com.example.notesapp.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.notesapp.databinding.ActivityAddEditNotesBinding
import com.example.notesapp.model.Notes
import java.util.Date

class AddEditNotesActivity : AppCompatActivity() {
    lateinit var b: ActivityAddEditNotesBinding

    var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        b = ActivityAddEditNotesBinding.inflate(layoutInflater)
        setContentView(b.root)
        setUpClick()
        if (intent.getStringExtra("type") != null && intent.getStringExtra("type") == "Edit") {
            getNotes()
        }
    }

    private fun getNotes() {
        val notes = intent.getSerializableExtra("notes") as Notes
        b.etNoteTitle.setText(notes.title)
        b.etNoteDesc.setText(notes.description)
        id = notes.id
    }

    private fun setUpClick() {
        b.ivBack.setOnClickListener {
            finish()
        }
        b.ivSave.setOnClickListener {
            val title = b.etNoteTitle.text.toString()
            val desc = b.etNoteDesc.text.toString()
            val date = Date().toString()
            
            val resultIntent = Intent()
            resultIntent.putExtra("id", id)
            resultIntent.putExtra("title", title)
            resultIntent.putExtra("desc", desc)
            resultIntent.putExtra("date", date)
            resultIntent.putExtra("type", intent.getStringExtra("type"))
            
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}