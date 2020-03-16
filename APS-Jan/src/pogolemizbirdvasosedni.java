import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class pogolemizbirdvasosedni {
    /*
9 8 7 6 5 4 3 2 1 2 3 4 5 6 7 8 9
40
98<->76<->54<->3<->2<->1<->2<->3<->45<->67<->89<->
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        DLL<Integer> list = new DLL<>();
        for(int i =0; i< parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));
        int n = Integer.parseInt(bufferedReader.readLine());
        DLLNode<Integer> node = list.getFirst();
        DLL<Integer> result = new DLL<>();
        while (node.succ != null && node != null && node.succ.succ != null) {
            int num = node.element*10 + node.succ.element;
            if(num > n) {
                result.insertLast(num);
                node = node.succ.succ;
            } else {
                result.insertLast(node.element);
                node =  node.succ;
            }
        }

        DLLNode<Integer> last = list.getLast();
        int x = last.element*10 + last.pred.element;
        if(x > n) {
            result.insertLast(x);
        } else {
            result.insertLast(last.pred.element);
            result.insertLast(last.element);
        }
        System.out.println(result);
    }
}
