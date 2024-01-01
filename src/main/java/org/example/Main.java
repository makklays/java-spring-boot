package org.example;

//import ch.qos.logback.classic.Logger;
//import org.apache.log4j.spi.LoggerFactory;
//import org.apache.log4j.Logger;
import org.example.animals.Cat;
import org.example.animals.Dog;
import org.example.animals.Parrot;
import org.example.entities.*;
import org.example.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.logging.LogManager;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // создаем пустой спринговый контекст, который будет искать свои бины по аннотациям в указанном пакете
        ApplicationContext context = new AnnotationConfigApplicationContext("org.example.animals"); // org.example.entities

        Cat cat = context.getBean(Cat.class);
        Dog dog = (Dog) context.getBean("dog");
        Parrot parrot = context.getBean("parrot-popka", Parrot.class);

        System.out.println(cat.getName());
        System.out.println(dog.getName());
        System.out.println(parrot.getName());

        //--- Hibernate --------------
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        //ChannelEntity channelEntity = new ChannelEntity("14", "Nick", "VK");
        ChannelEntity channelEntity = new ChannelEntity();
        //channelEntity.setId(12);
        channelEntity.setTitle("Nick");
        channelEntity.setDescr("VN");
        //Date date = new Date("2023-12-31");
        //Time time = new Time(111111111);
        //channelEntity.setDateAsTimestamp(date);
        //channelEntity.setDateAsDate(date);
        //channelEntity.setDateAsTime(time);

        System.out.println( channelEntity.toString() );

        session.save(channelEntity);
        //session.createNativeQuery("INSERT INTO channels (id, title, descr) VALUES (1, 'Nickkk', 'Mini') ");

        // add USER
        UserEntity userEntity = new UserEntity();
        //channelEntity.setId(12);
        userEntity.setLogin("Nick");
        userEntity.setFirstname("Firstname");
        userEntity.setLastname("Lastname");
        userEntity.setPassword("password");
        userEntity.setGender("man");
        userEntity.setPhone("+380988705397");
        userEntity.setEmail("makklays@gmail.com");
        userEntity.setCity("City1");
        userEntity.setIsAuth("1");
        userEntity.setCode("1111-2222-3333-4444");
        System.out.println( userEntity.toString() );
        session.save(userEntity);

        session.getTransaction().commit();
        session.close();
        //--- END Hibernate ----------

        // Logger slf4j
        System.setProperty("LOG_DIR", ".logs");
        System.setProperty("LOG_LEVEL", "trace");
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("info - hello world!");
        logger.trace("Entering method foo()"); // ?!
        logger.debug("Received request from 198.12.34.56"); // ?!
        logger.info("User logged in: john");
        logger.warn("Connection to server lost. Retrying...");
        logger.error("Failed to write data to file: myFile.txt");

        // Logger Logback
        //Logger logger = Logger.getLogger(Main.class.getName());
        //logger.info("info - hello world!");
        //logger.fine("fine - hello world!");
        //logger.log(Level.WARNING, "warning - hello world!", "Trace exception e");
        //logger.log(Level.SEVERE, "warning - hello world!", "Trace exception e");
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