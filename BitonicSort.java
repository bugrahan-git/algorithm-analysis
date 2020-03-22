
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BitonicSort {

    public static void compAndSwap(ArrayList<Integer> arr, int i, int j, int dire) {
        int temp;
        if ((dire == 1 && arr.get(i) > arr.get(j)) || (dire == 0 && arr.get(i) < arr.get(j))) {
            temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
    }

    public static void bitonicMerge(ArrayList<Integer> arr, int low, int cnt, int dire) {
        if (cnt > 1) {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(arr, i, i + k, dire);

            bitonicMerge(arr, low, k, dire);
            bitonicMerge(arr, low + k, k, dire);
        }
    }

    public static void bitonicSort(ArrayList<Integer> arr, int low, int cnt, int dire) {
        if (cnt > 1) {
            int k = cnt / 2;
            bitonicSort(arr, low, k, 1);
            bitonicSort(arr, low + k, k, 0);
            bitonicMerge(arr, low, cnt, dire);
        }
    }

    public static void sort(ArrayList<Integer> arr, int N, int up) {
        bitonicSort(arr, 0, N, up);
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
    
        sort(sampleArr, sampleArr.size(), 1);
    }

}