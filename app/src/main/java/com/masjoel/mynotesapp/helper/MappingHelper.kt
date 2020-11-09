package com.masjoel.mynotesapp.helper

import android.database.Cursor
import androidx.core.content.res.TypedArrayUtils.getInt
import androidx.core.content.res.TypedArrayUtils.getString
import com.masjoel.mynotesapp.db.DatabaseContract
import com.masjoel.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DATE
import com.masjoel.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DESCRIPTION
import com.masjoel.mynotesapp.db.DatabaseContract.NoteColumns.Companion.TITLE
import com.masjoel.mynotesapp.db.DatabaseContract.NoteColumns.Companion._ID
import com.masjoel.mynotesapp.entity.Note

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<Note> {
        val notesList = ArrayList<Note>()
        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(_ID))
                val title = getString(getColumnIndexOrThrow(TITLE))
                val description = getString(getColumnIndexOrThrow(DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DATE))
                notesList.add(Note(id, title, description, date))
            }
        }
        return notesList
    }
    fun mapCursorToObject(notesCursor: Cursor?): Note {
        var note = Note()
        notesCursor?.apply {
            moveToFirst()
            val id = getInt(getColumnIndexOrThrow(_ID))
            val title = getString(getColumnIndexOrThrow(TITLE))
            val description = getString(getColumnIndexOrThrow(DESCRIPTION))
            val date = getString(getColumnIndexOrThrow(DATE))
            note = Note(id, title, description, date)
        }
        return note
    }

}