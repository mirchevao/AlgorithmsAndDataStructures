import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lozinki {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String,String> hash = new CBHT<>(n);
        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            hash.insert(parts[0],parts[1]);
        }

        while (true) {
            String line = bufferedReader.readLine();
            if(line.equals("KRAJ"))
                break;
            String[] parts = line.split(" ");
            String ime = parts[0];
            String lozinka = parts[1];
            SLLNode<MapEntry<String,String>> node = hash.search(ime);
            if(node != null && node.element.value.equals(lozinka))
                System.out.println("Najaven");
            else System.out.println("Nenajaven");
        }
    }
}
