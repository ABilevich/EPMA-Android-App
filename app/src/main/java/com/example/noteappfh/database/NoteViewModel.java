package com.example.noteappfh.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.noteappfh.entities.Note;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    NoteRepository nr;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        nr = new NoteRepository(application);
    }

    public LiveData<List<Note>> getAll(){
        return nr.getAll();
    }

    public Note getById(int id){
        return nr.getById(id);
    }

    public void insertNote(Note note){
        nr.insertNote(note);
    }

    public void update(Note note){
        nr.update(note);
    }

    public void deleteNote(Note note){
        nr.deleteNote(note);
    }
}
