import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class kumD {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String,String> table = new CBHT<>(57);

        for(int i=0;i<N;i++){
            String line = br.readLine();
            String parts[] = line.split(" ");
            String kumanovski = parts[0];
            String literaturno = parts[1];
            table.insert(kumanovski, literaturno);
        }

        String tekst=br.readLine();
        String parts[] = tekst.split(" ");
        for (int i=0; i < parts.length; ++i) {
            String word = parts[i];
            char last = word.charAt(word.length()-1);
            boolean first = Character.isUpperCase(word.charAt(0));
            SLLNode<MapEntry<String,String>> node = null;
            if (Character.isLetter(last)) {
                node = table.search(word.toLowerCase());
                if (node == null)
                    System.out.print(word + " ");
                else{
                    word = node.element.value;
                    if (first){
                        word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                    }
                    System.out.print(word + " ");
                }
            }
            else {
                node = table.search(word.substring(0, word.length()-1).toLowerCase());
                if (node == null)
                    System.out.print(word + " ");
                else {
                    word=node.element.value;
                    if (first)
                        word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                    word += last;
                    System.out.print(word + " ");
                }

            }

        }

    }
}
