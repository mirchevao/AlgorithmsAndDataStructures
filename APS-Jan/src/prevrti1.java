import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prevrti1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        DLL<Integer> list = new DLL<>();

        for(int i =0; i<parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        DLL<Integer> result = new DLL<>();
        DLLNode<Integer> node = list.getLast();

        while (node != null) {
            if(node.element % 2 == 0) {
                result.insertLast(node.element);
                node =  node.pred;
            } else node =  node.pred;
        }
        node = list.getLast();
        while (node != null) {
            if (node.element % 2 != 0) {
                result.insertLast(node.element);
                node = node.pred;
            } else node =  node.pred;
        }
        System.out.println(result);
    }
}
