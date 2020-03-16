import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kumdi {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String, String> hashTable = new CBHT<>(200);
        for(int i =0; i<n; i++) {
            String[] parts = bufferedReader.readLine().split(" ");
            hashTable.insert(parts[0],parts[1]);
        }
        String text = bufferedReader.readLine();
        String[] words = text.split(" ");
        for(int i =0; i<words.length; i++) {
            String word = words[i];
            SLLNode<MapEntry<String,String>> node = null;
            boolean isCapital = Character.isUpperCase(word.charAt(0));
            char last = word.charAt(word.length()-1);
            if(isCapital) {
                if(Character.isLetter(last)) {
                    word = word.substring(0,1).toLowerCase() + word.substring(1);
                    node = hashTable.search(word);
                    if(node == null) {
                        word = word.substring(0,1).toUpperCase() + word.substring(1);
                        System.out.print(word + " ");
                    } else {
                        String newword = node.element.value;
                        newword = newword.substring(0,1).toUpperCase() + newword.substring(1);
                        System.out.print(newword + " ");
                    }
                } else {
                    word = word.substring(0,1).toLowerCase() + word.substring(1,word.length()-1);
                    node = hashTable.search(word);
                    if(node == null) {
                        word = word.substring(0,1).toUpperCase() + word.substring(1) + last;
                        System.out.print(word + " ");
                    } else {
                        String newword = node.element.value;
                        newword = newword.substring(0,1).toUpperCase() + newword.substring(1) + last;
                        System.out.print(newword + " ");
                    }
                }
            } else {
                if(Character.isLetter(last)) {
                    node = hashTable.search(word);
                    if(node == null) {
                        System.out.print(word + " ");
                    } else {
                        String newword = node.element.value;
                        System.out.print(newword + " ");
                    }
                } else {
                    word = word.substring(0,word.length()-1);
                    node = hashTable.search(word);
                    if(node == null) {
                        System.out.print(word + last + " ");
                    } else {
                        String newword = node.element.value;
                        System.out.print(newword + last + " ");
                    }
                }
            }
        }

    }
}
