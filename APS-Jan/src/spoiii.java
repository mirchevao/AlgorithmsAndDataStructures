import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class spoiii {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] parts1 = bufferedReader.readLine().split(" ");
        SLL<Integer> list1 =  new SLL<>();
        for(int i =0; i<n; i++)
            list1.insertLast(Integer.parseInt(parts1[i]));

        int m =  Integer.parseInt(bufferedReader.readLine());
        String[] parts2 = bufferedReader.readLine().split(" ");
        SLL<Integer> list2 = new SLL<>();
        for(int i =0; i<m; i++) {
            list2.insertLast(Integer.parseInt(parts2[i]));
        }

        SLL<Integer> result = new SLL<>();
        SLLNode<Integer> node1 = list1.getFirst();
        SLLNode<Integer> node2 = list2.getFirst();

        while (node1 != null && node2 != null) {
            result.insertLast(node1.element);
            result.insertLast(node2.element);
            node1=node1.succ;
            node2=node2.succ;
        }

        if(node1 != null) {
            while (node1 != null) {
                result.insertLast(node1.element);
                node1=node1.succ;
            }
        }

        if (node2 != null) {
            while (node2 != null) {
                result.insertLast(node2.element);
                node2= node2.succ;
            }
        }

        SLLNode<Integer> resnode = result.getFirst();
        while (resnode != null) {
            SLLNode<Integer> tmp = resnode.succ;
            while (tmp != null) {
                if(resnode.element > tmp.element) {
                    int pom = resnode.element;
                    resnode.element = tmp.element;
                    tmp.element = pom;
                } else if (resnode.element == tmp.element)  {
                    result.delete(tmp);
                }
                tmp =  tmp.succ;
            }
            resnode = resnode.succ;
        }
        System.out.println(result);
    }
}
