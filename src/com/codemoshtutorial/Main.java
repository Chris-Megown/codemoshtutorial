package com.codemoshtutorial;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        helloConsole();
        for (int i = 0; i < 5; i++) {
            System.out.println("Loops are fun " + i);
        }

        String input = "";
        while (!input.equals("quit")) {
            System.out.print("Input: ");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        }


    }


    public static void helloConsole() {
        System.out.println("Hello");
    }
}
