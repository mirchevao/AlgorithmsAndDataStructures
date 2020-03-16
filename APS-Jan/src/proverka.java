import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class proverka {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String,String> hash = new CBHT<>(200);
        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            hash.insert(line,line);
        }

        String text = bufferedReader.readLine();
        String[] words = text.split(" ");
        boolean flag = false;
        for(int i =0; i<words.length; i++) {
            String word = words[i];
            SLLNode<MapEntry<String,String>> node = null;
            boolean isCapital = Character.isUpperCase(word.charAt(0));
            char last = word.charAt(word.length()-1);
            if(isCapital) {
                if(Character.isLetter(last)) {
                    word = word.substring(0,1).toLowerCase() + word.substring(1);
                    node = hash.search(word);
                    if(node == null) {
                        word = word.substring(0,1).toUpperCase() + word.substring(1);
                        System.out.println(word);
                        flag = false;
                    } else flag = true;
                } else {
                    word = word.substring(0,1).toLowerCase() + word.substring(1, word.length()-1);
                    node = hash.search(word);
                    if(node == null) {
                        System.out.println(word);
                        flag = false;
                    } else flag = true;
                }
            } else {
                if(Character.isLetter(last)) {
                    node = hash.search(word);
                    if(node == null) {
                        System.out.println(word);
                        flag = false;
                    } else flag = true;
                } else {
                    word = word.substring(0,word.length()-1);
                    node = hash.search(word);
                    if(node == null) {

                        System.out.println(word);
                        flag = false;
                    } else flag= true;
                }
            }
        }
        if (flag)
            System.out.println("Bravo");
    }
}
