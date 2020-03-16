import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class spojListiNaizmenicno {
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
        SLL<Integer> list2 = new SLL<>();
        line = bufferedReader.readLine();
        String[] partss = line.split(" ");
        for(int i =0; i<m; i++) {
            list2.insertLast(Integer.parseInt(partss[i]));
        }

        SLLNode<Integer> node1 =  list1.getFirst();
        SLLNode<Integer> node2 = list2.getFirst();
        SLL<Integer> result = new SLL<>();
        while (node1.succ != null && node2.succ != null) {
            result.insertLast(node1.element);
            result.insertLast(node1.succ.element);
            result.insertLast(node2.element);
            result.insertLast(node2.succ.element);
            node1 = node1.succ.succ;
            node2=node2.succ.succ;
        }

        if(node1 != null) {
            while (node1!=null) {
                result.insertLast(node1.element);
                node1=node1.succ;
            }
        }

        if(node2 != null) {
            while (node2 !=  null) {
                result.insertLast(node2.element);
                node2=node2.succ;
            }
        }

        SLLNode<Integer> node = result.getFirst();
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.succ;
        }
    }
}
