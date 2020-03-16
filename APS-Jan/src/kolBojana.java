import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kolBojana {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] parts = line.split(" ");
        int n = Integer.parseInt(bufferedReader.readLine());
        DLL<Integer> list = new DLL<>();
        for(int i =0; i<parts.length; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }
        DLLNode<Integer> node = list.getFirst();
        DLL<Integer> result = new DLL<>();

       while (node.succ.succ != null) {
           int x = node.element * 10 + node.succ.element;
           if( x > n) {
               result.insertLast(x);
               node = node.succ.succ;
           } else {
               result.insertLast(node.element);
               node = node.succ;
           }
       }


        DLLNode<Integer> node1 = result.getFirst();
        while (node1!=null) {
            System.out.print(node1.element + " ");
            node1=node1.succ;
        }
    }
}
