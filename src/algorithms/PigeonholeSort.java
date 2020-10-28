
import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PigeonholeSort {

    public static void sort(ArrayList<Integer> arr) {
        int min = arr.get(0);
        int max = arr.get(0);
        int range, i, j, index;

        for (int a = 0; a < arr.size(); a++) {
            if (arr.get(a) > max)
                max = arr.get(a);
            if (arr.get(a) < min)
                min = arr.get(a);
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for (i = 0; i < arr.size(); i++)
            phole[arr.get(i) - min]++;

        index = 0;

        for (j = 0; j < range; j++)
            while (phole[j]-- > 0)
                arr.set(index++, j + min); 
    }

    public static void main(String args[]) {
        ArrayList<Integer> sampleArr = new ArrayList<Integer>();

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                sampleArr.add(Integer.parseInt(line));
            }
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }

        sort(sampleArr);

    }
}