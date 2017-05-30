package hw2.task2;

public class Pen extends Stationery {
    ColorEnum inkColor;
    int inkLevel = 100;
    double thickness;

    public Pen(String brand, double cost, ColorEnum inkColor, double thickness) {
        super(brand, cost);
        this.inkColor = inkColor;
        this.thickness = thickness;
    }

    public void write() throws OutOfInkException {
        if (inkLevel >= 25) {
            inkLevel -= 25;
        } else {
            throw new OutOfInkException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (inkLevel != pen.inkLevel) return false;
        if (Double.compare(pen.thickness, thickness) != 0) return false;
        return inkColor == pen.inkColor;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = inkColor.hashCode();
        result = 31 * result + inkLevel;
        temp = Double.doubleToLongBits(thickness);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("Pen: \"%s\", ink color - %s, ink level - %d%%, thickness - %.1f mm, cost - %.2f $",
                brand, inkColor, inkLevel, thickness, cost);
    }

    public ColorEnum getInkColor() {
        return inkColor;
    }

    public void setInkColor(ColorEnum inkColor) {
        this.inkColor = inkColor;
    }

    public int getInkLevel() {
        return inkLevel;
    }

    public void setInkLevel(int inkLevel) {
        this.inkLevel = inkLevel;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    class OutOfInkException extends Exception {
        public OutOfInkException() {
            System.out.println("Pen is out of ink.");
        }
    }
}
