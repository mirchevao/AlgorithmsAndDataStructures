import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class sameSetCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String line = bufferedReader.readLine();
        String[] words = line.split(" ");
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();
        for(int i =0; i<words.length; i++) {
            if(hashMap.containsKey(words[i])) {
                ArrayList<Integer> al = hashMap.get(words[i]);
                al.add(i);
                hashMap.put(words[i],al);
            } else {
                ArrayList<Integer> newa = new ArrayList<>();
                newa.add(i);
                hashMap.put(words[i],newa);
            }

        }
        System.out.println(hashMap);
    }
}
