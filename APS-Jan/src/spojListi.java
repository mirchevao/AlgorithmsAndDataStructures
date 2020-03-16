import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class spojListi {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        SLL<Integer> list1 = new SLL<>();
        String line = bufferedReader.readLine();
        String[] parts = line.split(" ");
        for(int i =0; i<n; i++) {

            list1.insertLast(Integer.parseInt(parts[i]));
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        String line2 = bufferedReader.readLine();
        String[] parts2 = line2.split(" ");
        SLL<Integer> list2 = new SLL<>();
        for(int i =0; i<m; i++) {

            list2.insertLast(Integer.parseInt(parts2[i]));
        }

        SLLNode<Integer> node1 = list1.getFirst();
        SLLNode<Integer> node2 = list2.getFirst();
        SLL<Integer> result = new SLL<>();
        while (node1 != null && node2 != null) {
            if(node1.element < node2.element) {
                result.insertLast(node1.element);
                node1 = node1.succ;
            } else if (node1.element > node2.element) {
                result.insertLast(node2.element);
                node2 = node2.succ;
            } else if( node1.element == node2.element) {
                result.insertLast(node1.element);
                node1 = node1.succ;
                node2=node2.succ;
            }
        }

        if(node1 != null) {
            while (node1 != null) {
                result.insertLast(node1.element);
                node1=node1.succ;
            }
        }

        if(node2 != null) {
            while (node2 != null) {
                result.insertLast(node2.element);
                node2 = node2.succ;
            }
        }

        SLLNode<Integer> node = result.getFirst();
        while (node != null) {
            SLLNode<Integer> pom = node.succ;
            while (pom != null) {
                if(node.element > pom.element) {
                    int tmp = node.element;
                    node.element = pom.element;
                    pom.element = tmp;
                } else if (node.element == pom.element) {
                    result.delete(pom);
                }
                pom = pom.succ;
            }
            node = node.succ;
        }

        node = result.getFirst();
        while (node != null) {
            System.out.print(node.element  + " ");
            node = node.succ;
        }
    }
}
