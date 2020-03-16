import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class preveduvac {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String,String> tabela = new CBHT<>(n);
        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            tabela.insert(parts[1],parts[0]);
        }

        while (true) {
            String line = bufferedReader.readLine();
            if(line.equals("KRAJ"))
                break;
            SLLNode<MapEntry<String,String>> node = tabela.search(line);
            if(node != null) {
                System.out.println(node.element.value);
            } else System.out.println("/");

        }
    }
}
