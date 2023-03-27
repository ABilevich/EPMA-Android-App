package com.example.noteappfh.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteappfh.R;
import com.example.noteappfh.adapter.NoteAdapter;
import com.example.noteappfh.database.NoteViewModel;
import com.example.noteappfh.entities.Note;

import java.util.List;

public class NoteListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_notelistfragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button b = view.findViewById(R.id.add_note);

        NoteViewModel mv = new ViewModelProvider(this).get(NoteViewModel.class);
        LiveData<List<Note>> notes = mv.getAll();

        RecyclerView rvContacts = (RecyclerView) view.findViewById(R.id.rvNotes);

        notes.observe(requireActivity(), new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                NoteAdapter adapter = new NoteAdapter(notes);
                rvContacts.setAdapter(adapter);
                rvContacts.setLayoutManager(new LinearLayoutManager(requireActivity()));
                // System.out.println(notes);
            }
        });

        b.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_noteListFragment_to_noteAddFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
