import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prvposl {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        SLL<Integer> list = new SLL<>();
        for(int i =0; i<parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        SLLNode<Integer> node1 = list.getFirst();
        SLLNode<Integer> node2 = node1.succ;
        if(list.length() == 1)
            System.out.println(node1.element);
        else if(list.length() >= 2) {
            while (node2.succ != null)  {
                node2 = node2.succ;
            }
            list.insertLast(node1.element);
            list.delete(node1);
            list.insertFirst(node2.element);
            list.delete(node2);
        }
        System.out.println(list);
    }
}
