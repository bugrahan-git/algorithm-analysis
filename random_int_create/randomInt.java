
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class randomInt {
    public static void generateRandom(int num, String fName) {
        Random r = new Random();
        int low = 0; // Inclusive
        int high = 1000000; // Exclusive
        int result;
        try {
            FileWriter fw = new FileWriter(fName, true); // the true will append the new data
            for (int i = 0; i < num; i++) {
                result = r.nextInt(high - low) + low;
                fw.write(result + "\n");
            }
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        generateRandom(Integer.parseInt(args[0]), args[1]);
    }
}