package hw4.task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {
    private static final long serialVersionUID = 126723567258723L;
    private String title;
    private List<Actor> actors;

    public Movie(String title) {
        this.title = title;
        actors = new ArrayList<>();
    }

    public Movie(String title, List<Actor> actors) {
        this.title = title;
        this.actors = actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
