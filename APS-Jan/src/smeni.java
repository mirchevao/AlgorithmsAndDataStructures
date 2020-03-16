import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class smeni {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        SLL<Integer> list = new SLL<>();

        for(int i =0; i<parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        SLLNode<Integer> node = list.getFirst();
        int n = 0;
        while (node != null) {
            n = node.element;
            node=node.succ;
        }
        node =  list.getFirst();
        list.insertBefore(n, node);
        list.delete(node);

        System.out.println(list);
    }
}
