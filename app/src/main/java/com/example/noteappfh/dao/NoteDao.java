package com.example.noteappfh.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.noteappfh.entities.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM Note ORDER BY note_id DESC")
    LiveData<List<Note>> getAll();

    @Query("SELECT * FROM Note where note_id = :id")
    public Note getById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertNote(Note note);

    @Update
    public void update(Note note);

    @Delete
    public void deleteNote(Note note);
}