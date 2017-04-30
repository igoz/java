package com.company.hw1.task6;

import java.util.Date;

/**
 * Class which represents note in notepad.
 * It is stores title of the note and it's content,
 * also author's name, creation date and last edited date, if note was edited.
 *
 * @author igoz
 * @since 1.0
 */
public class Note {
    private Date creationDate;
    private String title;
    private String content;
    private String author;

    private Date lastEditedDate;

    /**
     * Constructor of the Note
     * @param creationDate - stores date when note was first created
     * @param title title of the note
     * @param content content of the note
     * @param author user, who created a note
     */
    public Note(Date creationDate, String title, String content, String author) {
        this.creationDate = creationDate;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /**
     * Method for a readable representation of a note as a string
     * @return String
     */
    @Override
    public String toString() {
        return "Author: " + author + "\n" +
                "Created: " + creationDate + "\n" +
                "Last edited: " + (lastEditedDate == null ? "-" : lastEditedDate) + "\n\n" +
                title + "\n" + content + "\n";
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public Date getLastEditedDate() {
        return lastEditedDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLastEditedDate(Date lastEditedDate) {
        this.lastEditedDate = lastEditedDate;
    }

}
