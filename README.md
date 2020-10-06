# Polymorphism: Override and Overload
Polymorphism means the ability to have many forms. We can take a look at a printer as a real life example. We know that the main purpose of printers is to print. But we also know that not all printers support both black and white and colored inks. Given those facts, we can see that even though all printers have a common functionality, which is the ability to print, the details of how they perform it can be different.   
In the below examples, I will show you how we can achieve this concept in Java by using override and overload.
```
public class Printer {
    public void print() {
        System.out.println("The printer is printing...");
    }
}
```
Above we have a Printer class that has one method, `print()`, that prints out a generic message `"The printer is printing..."`. We have two ways to achieve polymorphism for this object depending on how we want to implement it. If we will want to utilize Inheritance and create subclasses for both the black and white and colored printers which will have their own implementation for the `print()` method, we should use override.   
### Override
Override lets us rewrite the implementation of a parent class' method. We achieve this by declaring the parent class' method in the subclass and adding an `@Override` annotation above it. Since in this approach we created subclasses for both types of printers, we will be overriding the Printer's `print()` method in both of them.
```
public class BlackAndWhitePrinter extends Printer {
    @Override
    public void print() {
        System.out.println("The printer is printing using black and white ink...");
    }
}
```
```
public class ColoredPrinter extends Printer {
    @Override
    public void print() {
        System.out.println("The printer is printing using colored ink...");
    }
}
```
Now let's create instances for all printer classes and call their `print()` methods.
```
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();

        Printer blackAndWhitePrinter = new BlackAndWhitePrinter();
        blackAndWhitePrinter.print();

        Printer coloredPrinter = new ColoredPrinter();
        coloredPrinter.print();
    }
}
```
Result:
```
The printer is printing...
The printer is printing using black and white ink...
The printer is printing using colored ink...
```
We can see that all three printer classes' implementation of `print()` are different.
### Overload
Another way to implement polymorphism in Java objects is by overloading. In the first example, we have overridden the Printer class' `print()` method in its subclasses and as a result, all three classes have had a different implementation for the same method. When overloading, we allow methods to have multiple implementations under its own class. Using this, we can create another subclass that will have both implementations of black and white and colored printing.
```
public class MixedPrinter extends Printer {
    @Override
    public void print() {
        System.out.println("The printer is printing using black and white ink...");
    }

    public void print(String color) {
        System.out.println("The printer is printing using " + color + " ink...");
    }
}
```
In the above example, we created a printer.MixedPrinter subclass that have two `print()` methods: one for black and white and the other for colored printing. In the first method, we have overridden the Printer class' implementation of `print()`, since we want to change its implementation to black and white printing. For the second method, we created another `print()` method that takes a `String color` parameter for our colored printing. This duplication of method is what we call **overloading**.  
Here are some things to keep in mind when overloading:
- Overloaded methods must have the same method name
- Overloaded methods must have a different set of parameters _(different data type per index)_
- Overloaded methods can have different return types
```
/* Original method */
void print() {}

/* Overloaded methods */
void print(String c) {} // Valid
String print() {} // Invalid, since there is already a print method that has no parameters
String print(char c) {} // Valid
int print(String c, String d) {} // Valid
int print(boolean d) {} // Valid
String print(boolean d) {} // Invalid, since there is already a print method that accepts one boolean parameter
``` 
Now let's create an instance of the printer.MixedPrinter and call the two `print()` methods.
```
public class Main {
    public static void main(String[] args) {
        MixedPrinter mixedPrinter = new MixedPrinter();
        mixedPrinter.print();
        mixedPrinter.print("red");
    }
}
```
Result:
```
The printer is printing using black and white ink...
The printer is printing using red ink...
```
In the example above, `mixedPrinter` printed using black and white colors when calling `print()` without any parameters, and printed using red color when calling `print()` with the `"red"` parameter. With this, we have achieved polymorphism for the `print()` method.   
Meanwhile, we can see that the declaration of the `mixedPrinter` is different from what we did with `blackAndWhitePrinter` and `coloredPrinter` from the override example.
```
Printer blackAndWhitePrinter = new BlackAndWhitePrinter();
blackAndWhitePrinter.print();

Printer coloredPrinter = new ColoredPrinter();
coloredPrinter.print();
```
So why not also use Printer as reference class for mixedPrinter? That approach is not applicable if we have overloaded methods in the subclass since it will not be visible when we use the parent class as reference class for the instance as can be seen below:
```
public class Main {
    public static void main(String[] args) {
        Printer mixedPrinter = new MixedPrinter();
        mixedPrinter.print();
        mixedPrinter.print("red"); // This method does not exist in Printer class and the program will encounter a compilation error
    }
}
``` 