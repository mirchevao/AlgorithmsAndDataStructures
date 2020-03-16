import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Speluvanje {

    public static void main(String[] args) throws IOException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        String[] exp;

        int n = Integer.parseInt(expr);

        OBHT<String, String> h = new OBHT<>((int)(n/0.6));

        for(int i=0; i<n; i++){
            expr = br.readLine();
            h.insert(expr, expr);
        }

        expr = br.readLine();
        exp = expr.split(" ");

        boolean flag = true;

        for(int i=0; i<exp.length; i++){
            boolean first = Character.isUpperCase(exp[i].charAt(0));
            char last = exp[i].charAt(exp[i].length()-1);
            if(Character.isLetter(last)){
                String word = exp[i].toLowerCase();
                if(h.search(word) == -1){
                    flag = false;
                    if(first){
                        System.out.println(word.substring(0, 1).toUpperCase() + word.substring(1));
                    }
                    else{
                        System.out.println(word);
                    }
                }
            }
            else{
                String word = exp[i].substring(0, exp[i].length()-1).toLowerCase();
                if(h.search(word) == -1 && word.length() > 0){
                    flag = false;
                    if(first){
                        System.out.println(word.substring(0, 1).toUpperCase() + word.substring(1));
                    }
                    else{
                        System.out.println(word);
                    }
                }
            }
        }

        if(flag){
            System.out.println("Bravo");
        }

        br.close();

    }

}