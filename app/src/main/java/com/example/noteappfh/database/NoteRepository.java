package com.example.noteappfh.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.noteappfh.dao.NoteDao;
import com.example.noteappfh.entities.Note;

import java.util.List;

public class NoteRepository {

    private NoteDao noteDao;

    public NoteRepository(Application application) {
        NoteDatabase ndb = NoteDatabase.getInstance(application);
        noteDao = ndb.getNoteDao();
    }

    public LiveData<List<Note>> getAll(){
        return noteDao.getAll();
    }

    public Note getById(int id){
        return noteDao.getById(id);
    }

    public void insertNote(Note note){
        noteDao.insertNote(note);
    }

    public void update(Note note){
        noteDao.update(note);
    }

    public void deleteNote(Note note){
        noteDao.deleteNote(note);
    }

}
