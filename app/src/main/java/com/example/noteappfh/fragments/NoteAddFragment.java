package com.example.noteappfh.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.noteappfh.R;
import com.example.noteappfh.database.NoteViewModel;
import com.example.noteappfh.entities.Note;
import com.example.noteappfh.database.NoteDatabase;

public class NoteAddFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_noteaddfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button b = view.findViewById(R.id.submit_note);
        b.setOnClickListener(view1 -> {
            EditText title = view.findViewById(R.id.new_note_title);
            EditText body = view.findViewById(R.id.new_note_body);
            System.out.println(title.getText().toString() + " - " +  body.getText().toString());
            Note new_note = new Note(title.getText().toString(), body.getText().toString());
            NoteViewModel mv = new ViewModelProvider(this).get(NoteViewModel.class);
            mv.insertNote(new_note);
            Navigation.findNavController(view).popBackStack();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
