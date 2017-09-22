/*
    Compilation: javac challenge1.java
    Execution: java challenge1

    My solution to https://www.reddit.com/r/dailyprogrammer/comments/pii6j/difficult_challenge_1/

*/

import java.io.Console;

public class challenge1 {

    public static void main(String args[]) throws Exception {

        Console c = System.console();

        int number = readNumber(c);

        int ceiling = 100;
        int floor = 0;
        int guessedNumber = (ceiling+floor)/2;

        System.out.printf("Guy 2: Hey! So, let me guess your number!\n");

        while (Math.abs(ceiling-floor) > 1) {

            guessedNumber = (ceiling+floor)/2;

            System.out.printf("Guy 2: Is your number %d?\n", guessedNumber);
            //System.out.printf("DEBUG: Ceiling: %d. Floor: %d\n", ceiling, floor);

            //input-loop
            while (true) {

                System.out.printf("Your answers: (Y)es, it's correct. No, it's (h)igher. No,it's (l)ower\n> You: ");
                String input = c.readLine().toLowerCase();

                if (input.startsWith("h")) {

                    floor = guessedNumber;
                    break;

                } else if (input.startsWith("l")) {

                    ceiling=guessedNumber;
                    break;

                } else if (input.startsWith("y")) {

                    evaluate(guessedNumber, number);

                    return;

                } else {
                    System.out.printf("Guy 2: Sorry, i did not understand, can you repeat that?\n");
                }//End of input checking

            }//End of input-loop

        }//End of guessing loop

        evaluate(guessedNumber, number);

    }//End of main function

    public static void evaluate(int guessedNumber, int number) throws Exception{

        System.out.printf("Guy 2: So i guess the correct number is %d, then! Haha, i am a genius!\n", guessedNumber);

        if (guessedNumber != number) {

            System.out.printf("Guy 1: Hey! That was not the number i was told! He told me his number was %d!\n", number);
            System.out.printf("Guy 2: You lying bastard!\n");
            throw new Exception("Memory error: Majority of memory is being overwritten and filled with the number" + number);

        } else {

            System.out.println("Guy 1: You must be a genius! It is the same number he told me earlier!");

        }

    }

    public static int readNumber(Console c) {

        boolean properNumber = false;
        int number = -1;

        System.out.printf("Guy 1: Hey, what number do you want Guy 2 to guess? Pick a number between 0 and 100\n> Answer: ");

        while (!properNumber) {

            try {

                number = Integer.parseInt(c.readLine());

                if (number < 0 || number > 100) {
                    System.out.printf("That number is not between 0 and 100! Pick another number\n> ");
                } else {
                    properNumber = true;
                }

            } catch (NumberFormatException ex) {

                System.out.printf("Guy 1: You fool! That is not a proper number! Try again!\n> ");

            }

        }

        return number;

    }

}
