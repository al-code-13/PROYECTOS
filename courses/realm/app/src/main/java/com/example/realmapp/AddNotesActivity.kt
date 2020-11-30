package com.example.realmapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.realmapp.model.Notes
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class AddNotesActivity : AppCompatActivity() {

    private lateinit var titleED: EditText
    private lateinit var descriptionED: EditText
    private lateinit var saveNoteBtn: Button
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        // init VIEWs

        realm = Realm.getDefaultInstance()
        titleED = findViewById(R.id.title_EditText)
        descriptionED = findViewById(R.id.description_EditText)
        saveNoteBtn = findViewById(R.id.saveNotes)

        // OnClick listner

        saveNoteBtn.setOnClickListener {
            addNotesToDB()
        }
    }

    private fun addNotesToDB() {
        try {
            //AUTO increment ID
            realm.beginTransaction()
            val currentIdNumeber: Number? = realm.where(Notes::class.java).max("id")
            val nexID: Int
            nexID = if (currentIdNumeber == null) {
                1
            } else {
                currentIdNumeber.toInt() + 1
            }
            val notes = Notes()
            notes.title = titleED.text.toString()
            notes.description = descriptionED.text.toString()
            notes.id = nexID

            // Coy this transaction & commit

            realm.copyToRealmOrUpdate(notes)
            realm.commitTransaction()
            Toast.makeText(this, "SE GUARDO PRRO", Toast.LENGTH_LONG).show()
            startActivity(Intent(this,MainActivity::class.java))
            finish()

        } catch (e: Exception) {
            Toast.makeText(this, "SE TOTIO por $e", Toast.LENGTH_LONG).show()
        }
    }
}