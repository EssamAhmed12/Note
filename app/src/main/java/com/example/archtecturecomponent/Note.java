package com.example.archtecturecomponent;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey (autoGenerate = true)
    private int id;

    private String title;

    private String description;

    private int pirority;

    public Note(String title, String description, int pirority) {
        this.title = title;
        this.description = description;
        this.pirority = pirority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPirority() {
        return pirority;
    }
}
