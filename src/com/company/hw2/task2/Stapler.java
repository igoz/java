package com.company.hw2.task2;

public class Stapler extends Stationery {
    Type type;
    int load = 5;

    public Stapler(String brand, double cost, Type type) {
        super(brand, cost);
        this.type = type;
    }

    public void use() throws OutOfStaplesException {
        if (load > 0) {
            load--;
        } else {
            throw new OutOfStaplesException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stapler stapler = (Stapler) o;

        if (load != stapler.load) return false;
        return type == stapler.type;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + load;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Stapler: \"%s\", type - %s, load - %d%% cost - %.2f $",
                brand, type, load, cost);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    enum Type {
        STANDARD,
        MINI
    }

    class OutOfStaplesException extends Throwable {
        public OutOfStaplesException() {
            System.out.println("Stapler is out of staples");
        }
    }
}
