import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pogolemiodposleden {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String line = bufferedReader.readLine();
        String[] parts = line.split(" ");
        SLL<Integer> list = new SLL<>();
        for(int i =0; i<n; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }
        SLLNode<Integer> node = list.getFirst();
        int num=0;
        while (node.succ != null) {
            node = node.succ;
            if(node.succ == null) {
                num = node.element;
            }
        }
        node = list.getFirst();
        SLL<Integer> pomali =  new SLL<>();
        SLL<Integer> pogolemi = new SLL<>();
        while (node != null) {
            if(node.element > num) {
                pogolemi.insertLast(node.element);
                node = node.succ;
            } else if (node.element < num) {
                pomali.insertLast(node.element);
                node = node.succ;
            } else if (node.element == num) {
                node = node.succ;
            }
        }

        SLLNode<Integer> node1 = pogolemi.getFirst();
        SLLNode<Integer> node2 = pomali.getFirst();
        while (node1!=null) {
            System.out.print(node1.element + " ");
            node1 = node1.succ;
        }
        System.out.println();
        while (node2 != null) {
            System.out.print(node2.element + " " );
            node2 = node2.succ;
        }
    }
}
