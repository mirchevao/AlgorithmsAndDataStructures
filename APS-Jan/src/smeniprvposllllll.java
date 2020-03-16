import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class smeniprvposllllll {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        SLL<Integer> list = new SLL<>();
        for(int i =0; i<parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        SLLNode<Integer> last = list.getFirst();
        while (last.succ != null)
            last = last.succ;


        SLLNode<Integer> first = list.getFirst();
        list.insertFirst(last.element);
        list.insertLast(first.element);

        list.delete(last);
        list.delete(first);

        System.out.println(list);


    }
}
