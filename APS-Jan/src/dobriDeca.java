import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dobriDeca {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String,String> table = new CBHT<>(20);
        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            String[] deca = line.split(" ");
            String ime = deca[0];
            String poklon = deca[1];
            table.insert(ime,poklon);
        }
        String dete = bufferedReader.readLine();
        String deteNew = "";
        if(dete.contains("c")) {
            deteNew = dete.replace("c","ch");
        } else if(dete.contains("C")) {
            deteNew = dete.replace("C","Ch");
        } else if(dete.contains("z")) {
            deteNew = dete.replace("z","zh");
        } else if(dete.contains("Z")){
            deteNew =dete.replace("Z","Zh");
        } else if(dete.contains("s")){
            deteNew=dete.replace("s","sh");
        } else if(dete.contains("S")){
            deteNew=dete.replace("S","Sh");
        }
        //System.out.println(deteNew);
        SLLNode<MapEntry<String,String>> node = null;
        node = table.search(dete);
        if(node != null) {
            System.out.println(node.element.value);
        } else {
            node = table.search(deteNew);
            if(node!=null)
                System.out.println(node.element.value);
            else System.out.println("nema");
        }


    }
}
