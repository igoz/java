package com.company.hw1.task6;

/**
 * Class which represents notepad and can store notes in custom implementation of dynamic array.
 *
 * @author igoz
 * @since 1.0
 */
public class Notepad {
    MyArray notes = new MyArray();

    /**
     * Method adds {@link com.company.hw1.task6.Note} to Notepad.
     * @param note instance of Note.
     */
    public void addNote(Note note) {
        notes.add(note);
    }

    /**
     * Method deletes {@link com.company.hw1.task6.Note} from Notepad.
     * @param idx index of the note in Notepad.
     */
    public void deleteNote(int idx) {
        notes.delete(idx);
    }

    /**
     * Method replaces title and content of the picked {@link com.company.hw1.task6.Note} from Notepad
     * and updates lastEditedDate.
     * @param idx index of the note in Notepad.
     * @param note new Note.
     */
    public void editNote(int idx, Note note) {
        Note editedNote = notes.get(idx);
        editedNote.setTitle(note.getTitle());
        editedNote.setContent(note.getContent());
        editedNote.setLastEditedDate(note.getCreationDate());
    }

    /**
     * Method prints all notes using {@link Note#toString()}
     */
    public void showAllNotes() {
        System.out.println();
        for (int i = 0; i < notes.getSize(); i++) {
            System.out.println("Note number: " + i);
            System.out.println(notes.get(i));
        }
    }

    public MyArray getNotes() {
        return notes;
    }
}
