package com.example.archtecturecomponent;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class NoteRepositry{
    private NoteDao noteDao;
    private LiveData<List<Note>> allNote;

    public NoteRepositry(Application application){
        NoteDatabase noteDatabase=NoteDatabase.getInstance(application);
        noteDao= noteDatabase.noteDao();
        allNote=noteDao.getAllNotes();
    }
    public void insert(Note note){
        new InsertNoteAsynTask(noteDao).execute(note);
    }
    public void update(Note note){
        new UpdateNoteAsynTask(noteDao).execute(note);
    }
    public void delete(Note note){
        new DeleteNoteAsynTask(noteDao).execute(note);
    }
    public void deleteAllNotes(){
        new DeleteAllNotesNoteAsynTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNote() {
        return allNote;
    }

    public static class InsertNoteAsynTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;
        private InsertNoteAsynTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    public static class UpdateNoteAsynTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;
        private UpdateNoteAsynTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }
    public static class DeleteNoteAsynTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;
        private DeleteNoteAsynTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }
    public static class DeleteAllNotesNoteAsynTask extends AsyncTask<Void,Void,Void>{
        private NoteDao noteDao;
        private DeleteAllNotesNoteAsynTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }
}
