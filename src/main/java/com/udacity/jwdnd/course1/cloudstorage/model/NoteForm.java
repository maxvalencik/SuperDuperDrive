package com.udacity.jwdnd.course1.cloudstorage.model;

public class NoteForm {
    private String title;
    private String description;
    private String noteId;

    //Getters
    public String getNoteId() {
        return noteId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    //Setters
    public void setNoteId(String noteId) {
        this.noteId = noteId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
