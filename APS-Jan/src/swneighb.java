import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swneighb {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        SLL<Integer> list = new SLL<>();
        for(int i =0; i< parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        SLLNode<Integer> node = list.getFirst();
        if(list.length() % 2 != 0) {
        while (node.succ!= null) {
            list.insertBefore(node.succ.element, node);
            list.delete(node.succ);
            node = node.succ;
            }
        } else {
            while (node != null) {
                list.insertBefore(node.succ.element, node);
                list.delete(node.succ);
                node = node.succ;
            }
        }
        System.out.println(list);
    }
}
