import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class dict {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String,String> hashTable = new CBHT<>(n+1);
        for(int i =0; i<n; i++) {
            String[] parts = bufferedReader.readLine().split(" ");
            hashTable.insert(parts[1],parts[0]);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if(line.equals("KRAJ"))
                break;
            else {
                SLLNode<MapEntry<String,String>> node = hashTable.search(line);
                if(node == null) {
                    System.out.println("/");
                } else {
                    if(node.element.key.equals(line)) {
                        System.out.println(node.element.value);
                    } else System.out.println("/");
                }
            }
        }

    }
}
