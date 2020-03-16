import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Scanner;

public class preveduvac {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        OBHT<String, String> dictionary = new OBHT<>(151);

        int n = scan.nextInt();
        scan.nextLine();
        for(int i =0; i<n; i++) {
            String[] parts = scan.nextLine().split(" ");
            String macedonian = parts[0];
            String english = parts[1];
            dictionary.insert(english,macedonian);
        }

        while (true) {
            String english = scan.nextLine();
            if(english.equals("KRAJ"))
                break;
            int index = dictionary.search(english);
            if(index == -1)
                System.out.println("/");
            else System.out.println(dictionary.getValue(index));
        }
    }
}
