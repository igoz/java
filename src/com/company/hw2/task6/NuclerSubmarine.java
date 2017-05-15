package com.company.hw2.task6;

public class NuclerSubmarine {
    private NuclerSubmarineEngine engine = new NuclerSubmarineEngine();

    public void startCruise() {
        engine.start();
        System.out.println("The submarine began cruising.");
    }

    private class NuclerSubmarineEngine {
        private void start() {
            System.out.println("Engine was started.");
        }
    }
}
