import javax.swing.text.DefaultEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dvedvo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts1 = bufferedReader.readLine().split(" ");
        DLL<Integer> list1 = new DLL<>();
        for(int i =0; i< parts1.length; i++)
            list1.insertLast(Integer.parseInt(parts1[i]));

        String[] parts2 = bufferedReader.readLine().split(" ");
        DLL<Integer> list2 = new DLL<>();
        for(int i =0; i<parts2.length; i++)
            list2.insertLast(Integer.parseInt(parts2[i]));

        DLLNode<Integer> node1 = list1.getFirst();
        DLLNode<Integer> node2 = list2.getLast();

        int sum1 = 0;
        for(int i = 0; i<list1.length(); i++) {
            sum1 += node1.element;
            node1 = node1.succ;
        }

        int sum2 = 0;
        for(int i =0; i<list2.length(); i++) {
            sum2+=node2.element;
            node2 = node2.pred;
        }

        DLL<Integer> result = new DLL<>();
        node1 = list1.getFirst();
        node2 = list2.getLast();
        DLLNode<Integer> resnode = result.getFirst();
        int res = sum1/list1.length() + sum2/list2.length();
        int pom1 = 0;
        int pom2 = 0;
        while (node1 != null) {
            pom1+= node1.element;
            if(pom1 > res) {
                break;
            } else {
                result.insertLast(node1.element);
                node1=node1.succ;
            }
        }

        while (node2!=null) {
            pom2+=node2.element;
            if(pom2 > res) {
                break;
            } else {
                result.insertLast(node2.element);
                node2 = node2.pred;
            }
        }


        System.out.println(result);

    }
}
