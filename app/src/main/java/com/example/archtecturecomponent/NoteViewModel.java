package com.example.archtecturecomponent;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepositry noteRepositry;
    private LiveData<List<Note>> allNotes;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepositry=new NoteRepositry(application);
        allNotes=noteRepositry.getAllNote();
    }
    public void insert(Note note){
        noteRepositry.insert(note);
    }
    public void update(Note note){
        noteRepositry.update(note);
    }
    public void delete(Note note){
        noteRepositry.delete(note);
    }
    public void deleteAllNotes(){
        noteRepositry.deleteAllNotes();
    }
    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }
}
