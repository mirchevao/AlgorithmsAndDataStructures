import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prevrtiLista {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        DLL<Integer> list = new DLL<>();
        String[] parts = bufferedReader.readLine().split(" ");
        for(int i =0; i<n; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }

        DLLNode<Integer> node = list.getLast();
        DLL<Integer> result = new DLL<>();

        while (node != null) {
            if(node.element % 2 == 0) {
                result.insertLast(node.element);
                node = node.pred;
            }
            else node = node.pred;
        }

        node = list.getLast();
        while (node != null) {
            if(node.element % 2 != 0) {
                result.insertLast(node.element);
                node = node.pred;
            } else node = node.pred;
        }
        
        node = result.getFirst();
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.succ;
        }
    }
}
