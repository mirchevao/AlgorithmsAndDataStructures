import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class s {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        HashMap<String,String> hash = new HashMap<>();
        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            hash.put(line,line);
        }
        String[] text = bufferedReader.readLine().split(" ");
        HashMap<String,String> secondMap = new HashMap<>();
        String word = "";
        boolean flag = false;
        for(int i =0; i<text.length; i++) {
            word = text[i];
            boolean first = Character.isUpperCase(word.charAt(i));
            char last = word.charAt(word.length()-1);
            if(Character.isLetter(last)) {
                word=word.toLowerCase();
                if(!hash.containsKey(word)) {
                    flag=false;
                    if(first){
                        System.out.println(word.substring(0,1).toUpperCase()+word.substring(1,word.length()));
                    } else System.out.println(word);
                }
            } else {
                word = word.toLowerCase().substring(0,word.length()-1);
                if(!hash.containsKey(word) && word.length() > 0) {
                    flag=false;
                    if(first){
                        System.out.println(word.substring(0,1).toUpperCase() + word.substring(1,word.length()));
                    } else System.out.println(word);
                }
            }

        }
        if (flag)
            System.out.println("Bravo");
    }
}
