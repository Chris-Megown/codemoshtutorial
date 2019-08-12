package main.codemoshtutorial;

import java.util.Scanner;

public class FizzBuzz {

    public FizzBuzz(){
        String fizz = "Fizz";
        String buzz = "Buzz";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please provide a number");
        int userNumber = scanner.nextInt();
        if(userNumber % 5 == 0 && userNumber % 3 == 0)
            System.out.println(fizz + buzz);
        else if(userNumber % 5 == 0)
        System.out.println(buzz);
        else if(userNumber % 3 == 0)
            System.out.println(buzz);
        else
            System.out.println(userNumber);
    }
}
