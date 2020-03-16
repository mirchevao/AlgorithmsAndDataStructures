import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class spoidvapodva {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String [] parts1 = bufferedReader.readLine().split(" ");
        SLL<Integer> list1 = new SLL<>();
        for(int i =0; i<parts1.length; i++)
            list1.insertLast(Integer.parseInt(parts1[i]));

        String [] parts2 = bufferedReader.readLine().split(" ");
        SLL<Integer> list2 = new SLL<>();
        for(int i =0; i<parts2.length; i++)
            list2.insertLast(Integer.parseInt(parts2[i]));

        SLLNode<Integer> node1 = list1.getFirst();
        SLLNode<Integer> node2 = list2.getFirst();

        SLL<Integer> result = new SLL<>();

        while (node1 != null && node2 != null && node1.succ != null && node2.succ != null) {
            result.insertLast(node1.element);
            result.insertLast(node1.succ.element);
            result.insertLast(node2.element);
            result.insertLast(node2.succ.element);
            node1 = node1.succ.succ;
            node2 = node2.succ.succ;
        }

        if(node1 != null)  {
            while (node1 != null) {
                result.insertLast(node1.element);
                node1=node1.succ;
            }
        }
        if(node2!=null) {
            while (node2!=null){
                result.insertLast(node2.element);
                node2=node2.succ;
            }
        }
        System.out.println(result);
    }
}
