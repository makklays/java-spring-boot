package org.example;

import org.example.entities.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // создаем пустой спринговый контекст, который будет искать свои бины по аннотациям в указанном пакете
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.entities");

        Cat cat = context.getBean(Cat.class);
        Dog dog = (Dog) context.getBean("dog");
        Parrot parrot = context.getBean("parrot-popka", Parrot.class);

        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());
    }

    public String forStringAndInteger() {
        //
        String strA = "11111";
        String strB = "22222";

        String str = strA + " " + strB;

        int int10 = str.length();
        String str_lower = str.toLowerCase();
        String str_upper = str.toUpperCase();

        int int102 = 102;
        String str102_1 = String.valueOf(int102);
        //String str102_2 = (String) int102;
        //String str102_3 = String.valueOf(int102);

        int res1 = Integer.valueOf(strA);
        int res2 = Integer.parseInt(strB);

        int a = 5, b = 2;
        double d = 1.0 * a / b; // 2.5

        int x14 = (int) Math.round(4.1); // 4
        int xx1 = (int) Math.ceil(4.1);  // 5
        int xxx = (int) Math.floor(4.9); // 4

        // Math — математика
        // Round — круглий/округлювати
        // Ceiling — стеля
        // Floor — підлога

        // byte, short, int, long
        // float, double

        return str;
    }

    public void solucion() {
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        int age = console.nextInt();

        System.out.println("Name :" + name);
        System.out.println("Age :" + age);
    }

    public void welcome() {
        // break point
        System.out.println("Hello");
        System.out.println("and ");
        // break point
        System.out.println("Goodbye Andriy!");
    }
}