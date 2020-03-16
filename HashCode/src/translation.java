import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class translation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        OBHT<String, String> dictionary = new OBHT<>(151);
        for(int i =0; i<n; i++) {
            String[] parts = bufferedReader.readLine().split(" ");
            String macedonian = parts[0];
            String english = parts[1];
            dictionary.insert(english,macedonian);
        }
        while (true) {
            String line = bufferedReader.readLine();
            if(line.equals("KRAJ"))
                break;
            int index = dictionary.search(line);
            if(index == -1)
                System.out.println("/");

        }
    }
}
