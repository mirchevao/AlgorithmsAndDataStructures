import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lozinki {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        CBHT<String, String> table = new CBHT<>(2*N);
        for(int i =0; i<N; i++) {
            String imeLozinka = bufferedReader.readLine();
            String[] parts = imeLozinka.split(" ");
            table.insert(parts[0], parts[1]);
        }

        while (true) {
            String line = bufferedReader.readLine();
            if(line.equals("KRAJ"))
                break;

            String pom[] = line.split(" ");
            SLLNode<MapEntry<String, String>> tmp = table.search(pom[0]);
            if(tmp == null || !(tmp.element.value.equals(pom[1])))
                System.out.println("Nenajaven");
            else {
                System.out.println("Najaven");
                break;
            }
        }
    }
}
