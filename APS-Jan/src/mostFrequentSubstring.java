import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mostFrequentSubstring {
    public static void main(String[] args) throws IOException {
        //abs substrings: a b c ab bc abc
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        CBHT<String,Integer> table = new CBHT<>(300);

        String word = bufferedReader.readLine().trim();
        for(int i =0; i<word.length(); i++) {
            for(int j = i + 1; j <word.length(); j++) {
                String tmp = word.substring(i,j);
                if(table.search(tmp)==null) {
                    table.insert(tmp, 1);
                } else {
                    int count = table.search(tmp).element.value;
                    table.insert(tmp, count+1);
                }
            }
        }
        System.out.println(table);
    }

}
