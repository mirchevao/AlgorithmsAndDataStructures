import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sreden {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        DLL<Integer> list = new DLL<>();
        for(int i =0; i<parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }

        DLLNode<Integer> node = list.getLast();

        int n = 0;
        int len = list.length()/2;
        for(int i =0; i<len; i++) {
            node = node.pred;
            n = node.element;
        }

        DLL<Integer> pogolemi = new DLL<>();
        DLL<Integer> pomali = new DLL<>();
        node = list.getFirst();
        while (node != null) {
            if(node.element > n) {
                pogolemi.insertLast(node.element);
                node = node.succ;
            } else {
                pomali.insertLast(node.element);
                node = node.succ;
            }
        }

        System.out.println(pogolemi);
        System.out.println(pomali);
    }
}
