package hw4.task4;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        MovieCollection movieCollection = new MovieCollection();
//        Movie movie = new Movie("title");
//        Actor actor = new Actor("Actor");
//
//        movie.addActor(actor);
//        movieCollection.addMovie(movie);
//
//        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(getFile("result")));
//        outputStream.writeObject(movieCollection);
//        outputStream.close();

        MovieCollection movieCollection = readMovieCollection();
    }

    private static MovieCollection readMovieCollection() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(getFile("result")));
        MovieCollection movieCollection = (MovieCollection) objectInputStream.readObject();

        return movieCollection;
    }

    private static File getFile(String fileName) {
        String file = Main.class.getResource(fileName).getFile();
        return new File(file);
    }
}
