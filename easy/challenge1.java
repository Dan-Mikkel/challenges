/*
    Compilation: javac challenge1.java
    Execution: java challenge1

    My solution to https://www.reddit.com/r/dailyprogrammer/comments/pih8x/easy_challenge_1/

*/

import java.io.Console;

public class challenge1 {

    public static void main(String args[]) {

        Console c = System.console();
        System.out.printf("What is your name?\n> ");
        String name = c.readLine();
        System.out.printf("What is your age?\n> ");
        int age = Integer.parseInt(c.readLine());
        System.out.printf("What is your username?\n> ");
        String username = c.readLine();

        System.out.printf("Your name is %s, you are %d years old and your username is %s\n\n", name, age, username);

    }

}
