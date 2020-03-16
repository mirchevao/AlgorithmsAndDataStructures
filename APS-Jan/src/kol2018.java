import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kol2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        SLL<String> list = new SLL<>();
        for(int i=0; i<parts.length; i++)
            list.insertLast(parts[i]);
        SLLNode<String> node = list.getFirst();
        for(int i=1; i<parts.length && node!=null; i++) {
            if(i % 3 == 0) {
                String replace = node.element.substring(0,1).toUpperCase() + node.element.substring(1);
                list.insertBefore(replace, node);
                list.delete(node);
                node =  node.succ;
            } else node = node.succ;
        }
        System.out.println(list);
    }
}
