package com.ikrki.turingsim;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        CPU cpu = new CPU("fib.tsp","fib.tsi");
        cpu.run();
    }
}