/*
Compilation: javac challenge321.java
Execution: java challenge321 <Time of day with the 24 hour format hh:mm>

Author: nanodami
Description:
My answer to https://www.reddit.com/r/dailyprogrammer/comments/6jr76h/20170627_challenge_321_easy_talking_clock/
This program takes a time in the 24-hour format and outputs the time in 12 hour format in words.
*/

public class challenge321 {

    public static void main(String args[]) {

        int hour = 0;
        int minute = 0;

        try {

            hour = Integer.parseInt(args[0].split(":")[0]);
            minute = Integer.parseInt(args[0].split(":")[1]);

            if (hour > 23 || hour < 0 || minute > 59 || minute < 0) {
                    System.out.printf("Error: The number must be in the format of hh:mm!\n");
                    return;
            }

        } catch (NumberFormatException ex) {

            System.out.printf("Error: The number must be in the format of hh:mm!\n");
            return;

        }

        String hours[] = "twelve one two three four five six seven eight nine ten eleven".split(" ");

        String output = "It's " + hours[hour%12];

        if (minute == 0) {
        } else if (minute/10 == 0)
            output = output + " oh " + hours[minute%10];
        else if (minute/10 == 1){

            String minutes[] = "ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen".split(" ");
            output = output + minutes[minute%10];

        } else {

            String tens[] = "Dummy dummy twenty thirty fourty fifty".split(" ");
            String ones[] = hours;

            output = output + " " + tens[minute/10];
            if (minute%10 != 0) output = output + " " + ones[minute%10];

        }//End of minutes formatting

        if (hour >= 12)
            output = output + " pm";
        else
            output = output + " am";

        System.out.printf(output + "\n");

    }

}
