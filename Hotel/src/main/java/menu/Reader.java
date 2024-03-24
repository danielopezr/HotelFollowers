package menu;

import java.util.Scanner;

public class Reader {
    Scanner sc = new Scanner(System.in);

    public String readString(String message) {
        System.out.print(message);
        String data = sc.next();
        return data;
    }
    
    public int readInt(String message) {
        System.out.println(message);
        int data = sc.nextInt();
        return data;
    }

    public double readDouble(String message) {
        System.out.println(message);
        double data = sc.nextDouble();
        return data;
    }

    public int validatePositiveInt(String message) {
        int input;
        do {
            System.out.print(message);
            while (!sc.hasNextInt()) {
                System.out.println("Valor Invalido");
                System.out.print("Debe ingresar un numero entero positivo: ");
                sc.next();
            }
            input = sc.nextInt();
            if (input < 0) {
                System.out.println("El numero debe ser un entero mayor a 0");
            }
        } while (input < 0);
        return input;
    }
    
    public double validatePositiveDouble(String message) {
    double input;
    do {
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.println("Valor Invalido");
            System.out.print("Debe ingresar un numero positivo: ");
            sc.next();
        }
        input = sc.nextDouble();
        if (input < 0) {
            System.out.println("El numero debe ser mayor a 0");
        }
    } while (input < 0);
    return input;
    }

    public int validateRange(String message, int lowerLimit, int upperLimit) {
        int input;
        do {
            System.out.print(message);
            while (!sc.hasNextInt()) {
                System.out.println("Valor invalido");
                System.out.print("Debe ingresar un numero entero en el rango: ");
                sc.next();
            }
            input = sc.nextInt();
            if (input < lowerLimit || input > upperLimit){
                System.out.println("El numero debe ser un entero entre " + lowerLimit + " y " + upperLimit);
            }
        } while (input < lowerLimit || input > upperLimit);
        return input;
    }
}
