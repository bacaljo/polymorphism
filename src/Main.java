import object.printer.BlackAndWhitePrinter;
import object.printer.ColoredPrinter;
import object.printer.MixedPrinter;
import object.Printer;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();

        Printer blackAndWhitePrinter = new BlackAndWhitePrinter();
        blackAndWhitePrinter.print();

        Printer coloredPrinter = new ColoredPrinter();
        coloredPrinter.print();

        MixedPrinter mixedPrinter = new MixedPrinter();
        mixedPrinter.print();
        mixedPrinter.print("red");
    }
}
