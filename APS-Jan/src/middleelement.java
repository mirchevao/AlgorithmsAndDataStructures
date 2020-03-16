import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class middleelement {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        SLL<Integer> list = new SLL<>();
        String[] parts = bufferedReader.readLine().split(" ");
        for(int i =0; i<n; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        SLLNode<Integer> fast = list.getFirst();
        SLLNode<Integer> slow = list.getFirst();
        while (fast != null && fast.succ != null) {
            fast = fast.succ.succ;
            slow = slow.succ;
        }
        int num = slow.element;
        SLLNode<Integer> node = list.getFirst();
        SLL<Integer> pomali = new SLL<>();
        SLL<Integer> pogolemi = new SLL<>();
        while (node != null) {
            if(node.element < num) {
                pomali.insertLast(node.element);
                node = node.succ;
            } else if (node.element > num) {
                pogolemi.insertLast(node.element);
                node=node.succ;
            } else node = node.succ;
        }

        

    }
}
