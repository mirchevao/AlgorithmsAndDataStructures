import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class substringFrequency {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine().trim();
        CBHT<String, Integer> hash = new CBHT<>(20);

        for (int i = 0; i < line.length(); i++) {
            for(int j = i+1; j<line.length(); j++) {
                String s = line.substring(i,j);
                if(hash.search(s) == null) {
                    hash.insert(s,1);
                } else {
                    int counter = hash.search(s).element.value;
                    hash.insert(s,counter+1);
                }
            }

        }
        System.out.println(hash);

    }

}
