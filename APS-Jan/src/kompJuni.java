import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kompJuni {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String,Integer> hash = new CBHT<>(n);
        for(int i =0; i<n; i++) {
            String[] parts = bufferedReader.readLine().split(" ");
            String vraboten = parts[0];
            String menager = parts[1];
            SLLNode<MapEntry<String,Integer>> node = hash.search(menager);
            int brojac = 0;
            if(node == null) {
                hash.insert(menager, 1);
            } else {
                brojac = node.element.value;
                hash.insert(menager, brojac + 1);
            }

        }
        System.out.println(hash.toString());
    }
}
