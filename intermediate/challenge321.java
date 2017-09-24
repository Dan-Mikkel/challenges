/*
Compilation: javac challenge321.java
Execution: java challenge321 <encode or decode> <value of amplitude> <value of off-set>

Ciphering and deciphering of strings using the affine ciphering formula of P = (aC + b)%26

*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class challenge321 {

    public static void main(String args[]) {

        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferReader = new BufferedReader(streamReader);
        String inputString;
        String option = args[0].toLowerCase();
        int a = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        if (option.compareTo("decode") != 0 && option.compareTo("encode") != 0) {
            System.out.println("Incorrect options, use either encode or decode");
            return;
        }

        try {

             while ((inputString = bufferReader.readLine()) != null) {

                 char[] c = inputString.toLowerCase().toCharArray();
                 for (int i = 0; i < c.length; i++) {

                     if (option.compareTo("decode") == 0) {
                         System.out.printf("%c", decode(c[i], a, b));
                     } else if (option.compareTo("encode") == 0) {
                         System.out.printf("%c", decode(c[i], a, b));
                     } else {
                         System.out.println("This code should not be executed!");
                         return;
                     }

                 }

                 System.out.printf("\n");

            }

        } catch (IOException ex) {
            System.out.printf("Something flopped: %s", ex.getMessage());
            return;
        }

    }

    public static char encode(char c, int a, int b) {

        char alphabet[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        return alphabet[((a*c)+b)%26];

    }

    public static char decode(char c, int a, int b) {

        char alphabet[] = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        return alphabet[((c-b)/a)%26];

    }

}
