package hw2.task2;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("John");

        Eraser eraser = new Eraser("Pelikan", 1);
        Pen pen = new Pen("Pilot", 2, ColorEnum.BLUE, 0.8);
        Pencil pencil = new Pencil("Staedtler", 1.5, ColorEnum.GREY);
        Stapler stapler = new Stapler("Swingline", 5, Stapler.Type.STANDARD);

        employee.addStationery(eraser)
                .addStationery(pen)
                .addStationery(pencil)
                .addStationery(stapler);

        employee.printStationeryStuffAndTotalCost();
        System.out.println();

        employee.writeSomethingWithPen();
        System.out.println();
        employee.writeSomethingWithPen();
        System.out.println();
        employee.writeSomethingWithPen();
        System.out.println();

        employee.printStationeryStuffAndTotalCost();
        System.out.println();

        employee.writeSomethingWithPen();
        System.out.println();
        employee.writeSomethingWithPen();
        System.out.println();

        employee.printStationeryStuffAndTotalCost();
    }
}
