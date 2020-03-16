import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class password {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String, String> table = new CBHT<>(2*n);
        for(int i =0; i<n; i++){
            String[] parts = bufferedReader.readLine().split(" ");
            String username = parts[0];
            String password = parts[1];
            table.insert(username,password);
        }

        while (true) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            if(line.equals("KRAJ"))
                break;
            String username = parts[0];
            String password = parts[1];

            if(!(table.search(username).element.value.equals(password))) {
                System.out.println("nenajaven");
            } else {
                System.out.println("najaven");
                break;
            }

        }
    }
}
