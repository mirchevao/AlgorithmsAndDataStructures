import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class frequencySequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 1;
        String line ="";
        int num =0;
        for(int i =0; i<n; i++) {
            line = bufferedReader.readLine();
            num = Integer.parseInt(line);
            if(hashMap.containsKey(num)) {
                count = hashMap.get(num);
                hashMap.remove(num,count);
                count+=1;
                hashMap.put(num,count);
            } else {
                hashMap.put(num,count);
            }
            count=1;
        }

        System.out.println(hashMap);
    }
}
