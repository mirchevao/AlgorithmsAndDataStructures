import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class itemsInCommon {
    //imaat razlicna cena
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, Integer> hashMap1 = new HashMap<>();
        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int price = Integer.parseInt(parts[1]);
            hashMap1.put(name,price);
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        for(int i =0; i<m; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int price = Integer.parseInt(parts[1]);
            hashMap2.put(name, price);
        }

        hashMap1.forEach((k,v) -> k.equals(hashMap2.get(k)));


    }
}
