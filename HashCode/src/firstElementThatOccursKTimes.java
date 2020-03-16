import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

public class firstElementThatOccursKTimes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arr[] =  new int[10];
        for(int i =0; i<10; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            arr[i] = num;
        }
        int k = Integer.parseInt(bufferedReader.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<10; i++){
            int counter = 0;
            if(map.get(arr[i])!=null)
                counter = map.get(arr[i]);
            map.put(arr[i], counter+1);
        }

        for(int i =0; i<10; i++) {
            if(map.get(arr[i]) == k) {
                System.out.println(arr[i]);
                break;
            }
            else System.out.println("no such  element");
        }
    }
}
