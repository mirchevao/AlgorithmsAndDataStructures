import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class srv {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //sredna vrednost so lista
        String[] parts = bufferedReader.readLine().split(" ");
        SLL<Integer> list = new SLL<>();
        for(int i =0; i<parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        int sum = 0;
        SLLNode<Integer> node = list.getFirst();
        for(int i =0; i<list.length(); i++) {
            sum+=node.element;
            node=node.succ;
        }

        double avg = Math.floor(sum/list.length());
        System.out.println(avg);

        //sreden element
        int n = 0;
        node = list.getFirst();
        for (int i = 0; i < list.length() / 2; i++) {
                if(list.length()%2==0) {
                    n = node.element;
                    node=node.succ;
                } else {
                    n = node.succ.element;
                    node = node.succ;
                }
        }

        System.out.println(n);
    }
}
