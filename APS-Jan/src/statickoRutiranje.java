import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class statickoRutiranje {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String,String> table = new CBHT<>(2*n);
        for(int i =0; i<n; i++) {
            String ruter = bufferedReader.readLine();
            String mreza = bufferedReader.readLine();

            table.insert(ruter,mreza);
        }
        int m = Integer.parseInt(bufferedReader.readLine());
        for(int i =0; i<m; i++) {
            String ruter = bufferedReader.readLine();
            SLLNode<MapEntry<String, String>> node = table.search(ruter);
            String mreza = bufferedReader.readLine();

            if(node != null) {
                String mm[] = mreza.split("\\.");
                String e[] = node.element.value.split("\\.");

                if(mm[0].equals(e[0]) && mm[1].equals(e[1]) && mm[2].equals(e[2])) {
                    System.out.println("postoi");
                } else
                    System.out.println("ne postoi");
            } else
                System.out.println("ne postoi");
        }
    }
}
