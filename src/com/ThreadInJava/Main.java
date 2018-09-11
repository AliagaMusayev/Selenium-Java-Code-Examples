package com.ThreadInJava;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class Main {

    ReentrantLock lock = new ReentrantLock();
    ReadWriteLock lockWriteAndRead = new ReentrantReadWriteLock();
    static int counter;
    ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException, IOException {

//        Thread th1 = new Thread(()->{
//
//            for (int i =0;i<=1000;i++){
//                System.out.println("th1 : "+i);
//            }
//        });
//
//        Thread th2 = new Thread(()->{
//
//            for (int i =0;i<=1000;i++){
//                System.out.println("th2 : "+i);
//
//            }
//        });

        Thread th1 = new Thread(()->{


            for (int i =0;i<=1000;i++){

                counter();

            }
            //System.out.println(counter);
        });

        Thread th2 = new Thread(()->{

            for (int i =0;i<=1000;i++){

                counter();
            }

        });

        Thread th3 = new Thread(()->{
            returnInt();
        });

        th1.start();
        //Thread.sleep(1000);
        th2.start();
        th1.join();
       th2.join();
        System.out.println(counter);
        //th3 will wait for previous two threads
        //th3.start();


        Main mainClass = new Main();
        //mainClass.writeTofile();

        Thread writerThread1 = new Thread(()->{
            System.out.println("I am in Writer thread 1");
            try {
                mainClass.writeTofile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "Writer Thread 1");


        Thread writerThread2 = new Thread(()->{
            System.out.println("I am in Writer thread 2");
            try {
                mainClass.writeTofile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "Writer Thread 2");

        Thread writer3 = new Thread(()->{
            System.out.println("I am in Writer thread 3");
            try {
                mainClass.writeTofile2();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "Writer Thread 3");


        Thread writer4 = new Thread(()->{
            System.out.println("I am in Writer thread 4");
            try {
                mainClass.writeTofile2();
            } catch (IOException e) {
                e.printStackTrace();
            }
        },"Writer Thread 4");

        Runnable writer5 = () -> {
            System.out.println("I am in Writer 5");
        };

        writerThread1.start();
        writerThread2.start();
        writer3.start();
        writer4.start();
        writer5.run();
    }




//    public void printListItems(){
//        list.forEach(i -> this::counter);
//    }

    public synchronized static void returnInt(){
        for (int i = 0; i<=10000;i++){
            System.out.println("th3 : "+i);
        }


    }

    public synchronized static void counter(){
        counter++;
    }

    public int counter(int a){
        lock.lock();
        try{
            a++;
        }
        finally {
            lock.unlock();
        }

        return a;
    }

    public void incrementCounter(){
        lockWriteAndRead.readLock().lock();
        try {
            counter ++;
        }

        finally {
            lockWriteAndRead.readLock().unlock();
        }
    }


    public void writeTofile() throws IOException {
        lockWriteAndRead.writeLock().lock();

        try{
            FileWriter myFile = new FileWriter("C:\\Users\\aliaga.musayev\\Desktop\\test.txt",true);
            Writer writer = new BufferedWriter(myFile);

            writer.write(Thread.currentThread().getName()+"\n");
            writer.close();
            myFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            lockWriteAndRead.writeLock().unlock();
        }
    }


    public synchronized void writeTofile2() throws IOException {

        BufferedWriter writer = null;
        try{
            FileWriter myFile = new FileWriter("C:\\Users\\aliaga.musayev\\Desktop\\test.txt",true);

             writer = new BufferedWriter(myFile);

            writer.write(Thread.currentThread().getName()+"\n");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

}
