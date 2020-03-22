
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CombSort {

    public static void sort(ArrayList<Integer> arr) {
        int gap = arr.size();
        boolean sorted = false;

        while (!sorted) {
            gap = (gap * 10) / 13;
            if (gap <= 1) {
                gap = 1;
                sorted = true;
            }

            int i = 0;
            while (i + gap < arr.size()) {
                if (arr.get(i) > arr.get(i + gap)) {
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i + gap));
                    arr.set(i + gap, temp);
                    sorted = false;
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
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