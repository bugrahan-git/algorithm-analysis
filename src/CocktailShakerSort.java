
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CocktailShakerSort {
    public static void sort(ArrayList<Integer> arr) {
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i = 0; i < arr.size() - 2; i++){
                if(arr.get(i) > arr.get(i+1)){
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i+1));
                    arr.set(i+1, temp);
                    swapped = true;
                }
            }
            
            if(!swapped)
                break;
            
            swapped = false;
            for(int i = arr.size() - 2; i > 0; i--){
                if(arr.get(i) > arr.get(i+1)){
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i+1));
                    arr.set(i+1, temp);
                    swapped = true;
                }
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