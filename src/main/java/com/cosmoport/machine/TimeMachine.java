package com.cosmoport.machine;

import org.example.domain.animals.Cat;

import java.util.ArrayList;
import java.util.*;

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

        // arrays
        byYears1();
    }

    public void byYears() {
        for (int i=this.currentYear; i > (this.currentYear - 2); i--) {
            System.out.println("Ahora estan en " + i + " año.");
        }
    }

    public static void byYears1() {
        int[] array; // объявление массива
        Object[] matrizOfObjects;

        array = new int[10]; // создание, то есть, выделение памяти для массива на 10 элементов типа int
        array[0] = 1800;
        array[1] = 1801;

        int[] myArray = new int[10]; // объявление и выделение памяти “в одном флаконе”

        System.out.println(array.length); // вывели в консоль длину массива, то есть количество элементов, которые мы можем поместить в массив

        String[] seasons = new String[4]; /* объявили и создали массив. Java выделила память под массив из 4 строк, и сейчас в каждой ячейке записано значение null (поскольку строка — ссылочный тип)*/

        seasons[0] = "Winter"; /* в первую ячейку, то есть, в ячейку с нулевым номером мы записали строку Winter. Тут мы получаем доступ к нулевому элементу массива и записываем туда конкретное значение  */
        seasons[1] = "Spring"; // проделываем ту же процедуру с ячейкой номер 1 (второй)
        seasons[2] = "Summer"; // ...номер 2
        seasons[3] = "Autumn"; // и с последней, номер 3

        String[] seasons1  = new String[] {"Winter", "Spring", "Summer", "Autumn"};
        // o
        String[] seasons2  = {"Winter", "Spring", "Summer", "Autumn"};
        for (int i = 0; i < seasons2.length; i++) {
            System.out.println(seasons[i]);
            // Winter
            // Spring
            // Summer
            // Autumn
        }

        for (int year : array) {
            System.out.println("Ahora estan en " + year + " año.");
        }

        //
        int[][] myTwoDimentionalArray = new int [8][8];

        int[][] matriz = new int [8][8];
        matriz[0][1] = 111;
        matriz[0][2] = 112;
        matriz[1][0] = 1434;
        matriz[7][7] = 1344;

        for (int[] matriz1 : matriz) {
            System.out.println("Matriz");
            for (int matriz12 : matriz1) {
                System.out.println("Cell of matriz: " + matriz12);
            }
        }

        // print - matriz
        System.out.println(Arrays.toString(matriz));
    }

    // Yo te quiero !
    public void isMyFavoriteYear() {
        int[] myFavYears = this.arrayMyFavoriteYears();

        for (int i = 0; i <= myFavYears.length; i++) {
            if (myFavYears[i] == this.currentYear) {
                System.out.println("This is my favotite year! " + this.currentYear);
            } else {
                System.out.println("Isn't my favotite year! " + this.currentYear);
            }
        }
    }

    public int[] arrayMyFavoriteYears() {
        int[] myFavYears = new int[25];
        myFavYears[0] = 1905;
        myFavYears[1] = 1945;

        return myFavYears;
    }

    public void exampleArray() {
        int[] array = {1, 5, 4, 3, 7}; //объявляем и инициализируем массив
        System.out.println(array); //пытаемся вывести наш массив на экран без метода toString - получаем 16-ричное число
        System.out.println(Arrays.toString(array)); //печатаем массив "правильно"
        Arrays.sort(array, 0, 4);  //сортируем весь массив от нулевого до четвёртого члена
        System.out.println(Arrays.toString(array)); //выводим отсортированный массив на экран
        int key = Arrays.binarySearch(array, 5); // ищем key - число 5 в отсортированном массиве.
        //метод binarySearch выдаст индекс элемента остортированного массива, в котором "спрятано" искомое число
        System.out.println(key); //распечатываем индекс искомого числа
        System.out.println(Arrays.binarySearch(array, 0)); //а теперь попробуем найти число, которого в массиве нет,
        // и сразу же выведем результат на экран
    }
}

