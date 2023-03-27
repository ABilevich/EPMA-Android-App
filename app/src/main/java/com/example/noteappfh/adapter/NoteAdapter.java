package com.example.noteappfh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.noteappfh.R;
import com.example.noteappfh.entities.Note;

import java.util.List;

public class NoteAdapter  extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {
    private List<Note> all_notes;

    public NoteAdapter(List<Note> notes) {
        all_notes = notes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView bodyTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.note_title);
            bodyTextView = (TextView) itemView.findViewById(R.id.note_body);
        }
    }

    @Override
    public NoteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.nice_item_note, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(NoteAdapter.ViewHolder holder, int position) {
        Note note = all_notes.get(position);

        TextView title_tv = holder.titleTextView;
        title_tv.setText(note.getTitle());

        TextView body_tv = holder.bodyTextView;
        body_tv.setText(note.getBody());
    }

    @Override
    public int getItemCount() {
        return all_notes.size();
    }

}