import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class posleden {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        SLL<Integer> list = new SLL<>();
        for(int i =0; i< parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }

        SLL<Integer> pomali = new SLL<>();
        SLL<Integer> pogolemi = new SLL<>();
        SLLNode<Integer> node = list.getFirst();
        int n = 0;
        while (node != null) {
            n = node.element;
            node = node.succ;
        }
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
