package hw1.task6;

import java.util.Date;
import java.util.Scanner;

public class Main {
    static Notepad notepad = new Notepad();

    public static void main(String[] args) {

        System.out.println("Notepad started. What do you want to do?\n");
        showCommands();
        try (Scanner sc = new Scanner(System.in)){
            readCommand(sc);
        }
    }

    private static void showCommands() {
        System.out.println("1. Add note");
        System.out.println("2. Edit note");
        System.out.println("3. Delete note");
        System.out.println("4. Show all notes");
        System.out.println("5. Exit");
        System.out.println();
    }

    private static void readCommand(Scanner sc) {
        System.out.print("Enter number from 1 to 5: ");

        int number = 0;
        try {
            number = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            readCommand(sc);
        }

        switch (number) {
            case 1:
                addNote(sc);
                break;
            case 2:
                editNote(sc);
                break;
            case 3:
                deleteNode(sc);
                break;
            case 4:
                showAllNotes(sc);
                break;
            case 5:
                System.exit(1);
            default:
                readCommand(sc);
        }
    }

    private static void addNote(Scanner sc) {
        String title;
        String content;

        System.out.println("Enter title: ");
        title = sc.nextLine();
        System.out.println("Enter content: ");
        content = sc.nextLine();

        Note note = new Note(new Date(), title, content, System.getProperty("user.name"));
        notepad.addNote(note);

        showCommands();
        readCommand(sc);
    }

    private static void editNote(Scanner sc) {
        if (notepad.getNotes().getSize() == 0) {
            System.out.println("No notes in notepad.");
            showCommands();
            readCommand(sc);
        }

        String title;
        String content;

        int idx = pickNote(sc);

        if (idx < 0 || idx >= notepad.getNotes().getSize()) {
            System.out.println("No note with this index.");
            showCommands();
            readCommand(sc);
        }

        System.out.println("Enter title: ");
        title = sc.nextLine();
        System.out.println("Enter content: ");
        content = sc.nextLine();

        Note note = new Note(new Date(), title, content, System.getProperty("user.name"));
        notepad.editNote(idx, note);

        showCommands();
        readCommand(sc);
    }

    private static void deleteNode(Scanner sc) {
        if (notepad.getNotes().getSize() == 0) {
            System.out.println("No notes in notepad.");
            showCommands();
            readCommand(sc);
        }

        notepad.showAllNotes();

        int idx = pickNote(sc);

        if (idx < 0 || idx >= notepad.getNotes().getSize()) {
            System.out.println("No note with this index.");
            showCommands();
            readCommand(sc);
        }

        notepad.deleteNote(idx);

        showCommands();
        readCommand(sc);
    }

    private static int pickNote(Scanner sc) {
        notepad.showAllNotes();

        System.out.print("Enter number of the note: ");

        int number = 0;
        try {
            number = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            pickNote(sc);
        }

        return number;
    }

    private static void showAllNotes(Scanner sc) {
        if (notepad.getNotes().getSize() == 0) {
            System.out.println("No notes in notepad.");
            showCommands();
            readCommand(sc);
        }

        notepad.showAllNotes();
        showCommands();
        readCommand(sc);
    }
}
