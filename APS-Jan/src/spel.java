import java.awt.color.CMMException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class spel {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String,String> hashmap =  new CBHT<>(300);
        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            hashmap.insert(line,line);
        }
        boolean flag = true;

        String text = bufferedReader.readLine();
        String[] parts = text.split(" ");
        for(int i =0; i<parts.length; i++) {
            String word = parts[i];
            boolean isCapital = Character.isUpperCase(word.charAt(0));
            char last = word.charAt(word.length()-1);
            SLLNode<MapEntry<String,String>> node = null;
            if(isCapital) {
                word = word.toLowerCase();
                if(Character.isLetter(last)) {
                    node = hashmap.search(word);
                    if(node == null) {
                        flag = false;
                        System.out.println(word);
                    } else {
                        flag = true;
                    }
                } else {
                    //sneake,
                    word = word.substring(0,word.length()-1);
                    node = hashmap.search(word);
                    if(node == null) {
                        flag = false;
                        System.out.println(word);
                    } else {
                        flag = true;
                    }
                }
            } else {
                if(Character.isLetter(last)) {
                    node = hashmap.search(word);
                    if(node == null) {
                        flag = false;
                        System.out.println(word);
                    } else {
                        flag = true;
                    }
                } else {
                    word = word.substring(0,word.length()-1);
                    node = hashmap.search(word);
                    if(node == null) {
                        flag = false;
                        System.out.println(word);
                    } else {
                        flag = true;
                    }
                }
            }
        }
        if(flag == true) {
            System.out.println("Bravo");
        }
    }
}
