package com.cosmoport.machine;

import org.example.domain.animals.Cat;

import java.util.ArrayList;

/**
 * Author: Alexander Kuziv
 *  Email: makklays@gmail.com
 *   Date: 02-01-2024
 */
public class TimeMachine {
    private int currentYear = 2024;

    public int goToFuture() {
        return this.currentYear += 10;
    }

    // перегрузка метода goToPast
    public int goToPast() {
        return this.currentYear -= 10;
    }

    public int goToPast(int countYears) {
        return this.currentYear -= countYears;
    }

    public int getYear() {
        return this.currentYear;
    }

    public static void main(String[] args) {
        TimeMachine timeMachine = new TimeMachine();
        timeMachine.currentYear = 2024;

        System.out.println("Какой сейчас год?");
        System.out.println(timeMachine.getYear());

        timeMachine.goToPast();
        System.out.println("А сейчас?");
        System.out.println(timeMachine.getYear());

        timeMachine.goToPast(24);
        System.out.println("А сейчас?");
        System.out.println(timeMachine.getYear());

        // ------ ArrayList -----------------
        ArrayList<Cat> cats = new ArrayList<>(12); // by default 10
        System.out.println("Число котов: " + cats.size());

        Cat cat = new Cat();
        cats.add(cat);
        System.out.println("Число котов: " + cats.size());

        Cat cat1 = new Cat("Кот в сапогах");
        cats.add(cat1);
        System.out.println("Число котов: " + cats.size());
        cats.remove(0);
        System.out.println("Достаем первого кота: " + cats.get(0));

        cats.trimToSize(); // удаляет пустые не используемые ячейки
        System.out.println("Число котов: " + cats.size());

        // ------ String -----------------
        String s1 = "Java - лучший для изучения Java!"; // из String Pool
        String s2 = new String("Java - лучший для изучения Java!");
        System.out.println(s1 == s2); // false

        String s10 = "Java - лучший для изучения Java!";
        String s22 = new String("Java - лучший для изучения Java!");
        System.out.println(s10.equals(s22)); // true

        // Применив метод intern() к ссылке на строку, которая создавалась через new, мы можем сравнивать ее со ссылкой на строку из String Pool’a через оператор ==.
        String s12 = "Java - лучший для изучения Java!";
        String s21 = new String("Java - лучший для изучения Java!");
        System.out.println(s12 == s21.intern()); // true
    }
}

