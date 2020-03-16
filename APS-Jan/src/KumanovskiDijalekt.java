import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class KumanovskiDijalekt {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String, String> map = new CBHT<>(57);

        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            String [] parts = line.split(" ");
            String kumanovski = parts[0];
            String literaturno =  parts[1];
            map.insert(kumanovski,literaturno);
        }

        String text = bufferedReader.readLine();
        String[] parts = text.split(" ");
        for(int i =0; i<parts.length; i++) {
            String word = parts[i];
            char last = word.charAt(word.length()-1);
            boolean first = Character.isUpperCase(word.charAt(0));
            SLLNode<MapEntry<String,String>> node = null;
            if (Character.isLetter(last)) {
                node = map.search(word.toLowerCase());
                if(node == null)
                    System.out.print(word + " ");
                else {
                    word = node.element.value;
                    if(first) {
                        word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                    }
                    System.out.print(word + " ");
                }
            } else {
                node = map.search(word.substring(0, word.length()-1).toLowerCase());
                if(node == null) {
                    System.out.print(word + " ");
                } else {
                    word=node.element.value;
                    if(first)
                        word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                    word+=last;
                    System.out.print(word + " ");
                }
            }

        }

    }
}
