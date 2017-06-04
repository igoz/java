package hw4.task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieCollection implements Serializable {
    public static final long serialVersionUID = 138974293598484L;
    public List<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
