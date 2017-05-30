package hw2.task3and4;

import hw2.task2.ColorEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StarterKit {
    Notebook notebook;
    Pen pen;
    Pencil pencil;
    Ruler ruler;
    Stapler stapler;

    public StarterKit() {
        this.notebook = new Notebook("Whitelines", 3, 48);
        this.pen = new Pen("Pilot", 2, ColorEnum.BLUE, 0.8);
        this.pencil = new Pencil("Staedtler", 1.5, ColorEnum.GREY);
        this.ruler = new Ruler("Haco", 1, 15);
        this.stapler = new Stapler("Haco", 5);
    }

    public List<Stationery> toList() {
        return new ArrayList<>(Arrays.asList(notebook, pen, pencil, stapler, ruler));
    }

    @Override
    public String toString() {
        return String.format("Starter kit:\n %s\n %s\n %s\n %s\n %s\n",
                notebook, pen, pencil, ruler, stapler);
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public Pencil getPencil() {
        return pencil;
    }

    public void setPencil(Pencil pencil) {
        this.pencil = pencil;
    }

    public Ruler getRuler() {
        return ruler;
    }

    public void setRuler(Ruler ruler) {
        this.ruler = ruler;
    }

    public Stapler getStapler() {
        return stapler;
    }

    public void setStapler(Stapler stapler) {
        this.stapler = stapler;
    }
}
