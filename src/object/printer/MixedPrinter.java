package object.printer;

import object.Printer;

public class MixedPrinter extends Printer {
    @Override
    public void print() {
        System.out.println("The printer is printing using black and white ink...");
    }

    public void print(String color) {
        System.out.println("The printer is printing using " + color + " ink...");
    }
}
