import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class challenge335 {

    public static void main(String args[]) {

            File file = new File("./challenge335.txt");
            FileReader fd = null;
            try {
                fd = new FileReader(file);
            } catch (Exception ex) {
                return;
            }

            BufferedReader reader = new BufferedReader(fd);
            String line = null;
            try {

                line = reader.readLine();

            } catch (Exception ex) {
                return;
            }

            int a = Integer.parseInt(line.split(" ")[0]);
            int b = Integer.parseInt(line.split(" ")[1]);

            System.out.println("A: " + a + " B: " + b);

            for (int i = 0; i < a; i++) {

                int sum = 0;
                try {
                    line = reader.readLine();
                } catch (Exception ex) {
                    return;
                }

                for (int j = 0; j < b; j++) {

                    int x = Integer.parseInt(line.split(" ")[j]);

                    for (int k = j+1; j < b; k++) {

                        if (k == b) break;//Apparently i get an index out of bounds exception if i do not use this...

                        int y = Integer.parseInt(line.split(" ")[k]);
                        if (Math.abs(y-x) == 1) {
                            sum = sum + (k-j);
                        }

                    }

                }

                System.out.println(sum);

            }

    }

}//End of challenge335
