
// Java Program to demonstrate
// Observation 
import java.io.*;

interface Demo {
    public void m1();

    public void m2();

    public void m3();
}

interface FirstChild extends Demo {
    public void m1() {
        System.out.println("Inside m1");
    }
}

class SecondChild implements FirstChild {
    public void m2() {
        System.out.println("Inside m2");
    }

    public void m3() {
        System.out.println("Inside m3");
    }
}

class Interface_Testing {
    public static void main(String[] args) {
        // if we remove the abstract keyword from FirstChild
        // Class and uncommented below obj creation for
        // FirstChild then it will throw
        // compile time error as did't override all the
        // abstract methods

        // FirstChild f=new FirstChild();
        // f.m1();

        SecondChild s = new SecondChild();
        // FirstChild s = new FirstChild();
        s.m1();
        s.m2();
        s.m3();
    }
}
