import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sekojtret {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[]  parts = bufferedReader.readLine().split(" ");
        SLL<String> list = new SLL<>();
        for(int i =0; i<parts.length; i++)
            list.insertLast(parts[i]);

        SLLNode<String> node = list.getFirst();
        int i = 1;
        while (node != null) {
            if( i == 3) {
                String str = node.element.substring(0,1).toUpperCase() + node.element.substring(1);
                list.insertBefore(str, node);
                list.delete(node);
                node = node.succ;
                i = 1;
            } else {
                node = node.succ;
                i++;
            }
        }
        System.out.println(list);
    }
}
