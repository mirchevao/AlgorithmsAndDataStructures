import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class poparnost {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String line =  bufferedReader.readLine();
        String[] parts = line.split(" ");
        DLL<Integer> list = new DLL<>();
        for(int i =0; i<n; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        DLLNode<Integer> back = list.getLast();
        DLLNode<Integer> front = list.getFirst();
        double len = Math.ceil(list.length()/2);

        DLL<Integer> odd = new DLL<>();
        DLL<Integer> even = new DLL<>();
        for(int i =0; i<(int)len + 1; i++) {
            if(front.element % 2 == 0) {
                even.insertLast(front.element);
                front = front.succ;
            } else {
                odd.insertLast(front.element);
                front = front.succ;
            }

            if(back.element % 2 == 0) {
                even.insertLast(back.element);
                back = back.pred;
            } else {
                odd.insertLast(back.element);
                back=back.pred;
            }
        }

        DLLNode<Integer> node1 = even.getFirst();
        DLLNode<Integer> node2 = odd.getFirst();

        while (node1 != null) {
            DLLNode<Integer> tmp = node1.succ;
            while (tmp!=null) {
                if(node1.element == tmp.element) {
                    even.delete(tmp);
                    tmp = tmp.succ;
                } else tmp = tmp.succ;
            }
            node1 = node1.succ;
        }

        while (node2 != null) {
            DLLNode<Integer> tmp = node2.succ;
            while (tmp!=null) {
                if(node2.element == tmp.element) {
                    odd.delete(tmp);
                    tmp = tmp.succ;
                } else tmp = tmp.succ;
            }
            node2 = node2.succ;
        }

        node1 = even.getFirst();
        node2=odd.getFirst();

        while (node1!=null) {
            System.out.print(node1.element + " ");
            node1=node1.succ;
        }
        System.out.println();
        while (node2!=null) {
            System.out.print(node2.element + " ");
            node2=node2.succ;
        }
    }
}
