import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prevrti2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String [] parts1 = bufferedReader.readLine().split(" ");
        DLL<Integer> list1 = new DLL<>();
        for(int i =0; i<parts1.length; i++)
            list1.insertLast(Integer.parseInt(parts1[i]));

        String [] parts2 = bufferedReader.readLine().split(" ");
        DLL<Integer> list2 = new DLL<>();
        for(int i =0; i<parts2.length; i++)
            list2.insertLast(Integer.parseInt(parts2[i]));

        DLLNode<Integer> node1 = list1.getFirst();
        DLLNode<Integer> node2 = list2.getLast();

        DLL<Integer> result = new DLL<>();
        while (node1 != null && node2 != null) {
            if(node1.element % 2 == 0) {
                result.insertLast(node1.element);
                node1 = node1.succ;
            } else node1 = node1.succ;

            if(node2.element % 2 == 0) {
                result.insertLast(node2.element);
                node2 = node2.pred;
            } else node2 =  node2.pred;
        }

        if(node1 != null) {
            while (node1 != null) {
                if(node1.element % 2 == 0) {
                    result.insertLast(node1.element);
                    node1=node1.succ;
                } else node1 = node1.succ;
            }
        }

        if(node2 != null) {
            while (node2 != null) {
                if(node2.element % 2 == 0) {
                    result.insertLast(node2.element);
                    node2 = node2.pred;
                } else node2 =node2.pred;
            }
        }
        node1 = list1.getFirst();
        while (node1!=null) {
            if(node1.element % 2 != 0) {
                result.insertLast(node1.element);
                node1 = node1.succ;
            } else node1 = node1.succ;
        }

        node2 = list2.getLast();
        while (node2 != null) {
            if(node2.element % 2 != 0) {
                result.insertLast(node2.element);
                node2 = node2.pred;
            } else node2 = node2.pred;
        }

        System.out.println(result);
    }
}
