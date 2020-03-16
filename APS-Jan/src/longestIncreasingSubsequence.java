import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class longestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        HashMap<String,String> hashMap = new HashMap<>();
        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            hashMap.put(parts[0],parts[1]);

        }

        String text = bufferedReader.readLine();
        String[] words = text.split(" ");
        for(int i =0; i<words.length; i++) {
            String word = words[i];
            boolean isCapital = Character.isUpperCase(word.charAt(0));
            char last = word.charAt(word.length());
            if(Character.isLetter(last)) {
                if(isCapital) {
                    word = word.toLowerCase();
                    if(hashMap.containsKey(word)) {
                        String node = hashMap.get(word);
                        System.out.print(node.substring(0,1).toUpperCase() + node.substring(1) + " ");
                    } else {
                        System.out.print(word + " ");
                    }
                } else {
                    if(hashMap.containsKey(word)) {
                        String node = hashMap.get(word);
                        System.out.print(node + " ");
                    }
                }
            } else {
                word = word.substring(0,word.length()-1);
                if(isCapital) {
                    word = word.toLowerCase();
                    if(hashMap.containsKey(word)) {
                        String node = hashMap.get(word);
                        System.out.print(node.substring(0,1).toUpperCase() + node.substring(1) + last + " ");
                    } else {
                        System.out.print(word.substring(0,1).toUpperCase() + word.substring(1) + last + " ");
                    }
                } else {
                    if(hashMap.containsKey(word)) {
                        String node = hashMap.get(word);
                        System.out.print(node + last + " ");
                    } else {
                        System.out.print(word + last + " ");
                    }
                }
            }

        }
    }
}