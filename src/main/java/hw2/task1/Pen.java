package hw2.task1;

public class Pen {
    String brand;
    ColorEnum inkColor;
    int inkLevel;
    double thickness;
    double cost;

    public Pen(String brand, ColorEnum inkColor, int inkLevel, double thickness, double cost) {
        this.brand = brand;
        this.inkColor = inkColor;
        this.inkLevel = inkLevel;
        this.thickness = thickness;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (inkLevel != pen.inkLevel) return false;
        if (Double.compare(pen.thickness, thickness) != 0) return false;
        if (Double.compare(pen.cost, cost) != 0) return false;
        if (!brand.equals(pen.brand)) return false;
        return inkColor == pen.inkColor;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand.hashCode();
        result = 31 * result + inkColor.hashCode();
        result = 31 * result + inkLevel;
        temp = Double.doubleToLongBits(thickness);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("Pen: \"%s\", ink color - %s, ink level - %d%%, thickness - %.1f mm, cost - %.2f $",
                brand, inkColor, inkLevel, thickness, cost);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public enum ColorEnum {
        BLUE,
        RED,
        GREEN,
        BLACK
    }
}
