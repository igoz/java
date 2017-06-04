package hw4.task4;

import java.io.Serializable;

public class Actor implements Serializable {
    private static final long serialVersionUID = 1232167462828L;
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
