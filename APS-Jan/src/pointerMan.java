import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pointerMan {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        SLL<Integer> list = new SLL<>();
        for(int i =0; i<parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        SLLNode<Integer> first = list.getFirst();

        if(parts.length > 2) {
            for(int i =0; i<parts.length/2; i++) {
                SLLNode<Integer> lastptr = list.getFirst();
                SLLNode<Integer> nextToLast = list.getFirst();

                while (lastptr.succ != null) {
                    lastptr =lastptr.succ;
                }

                while(nextToLast.succ.succ !=  null) {
                    nextToLast = nextToLast.succ;
                }

                lastptr.succ = first.succ;
                first.succ = lastptr;
                nextToLast.succ = null;
                first = first.succ.succ;
            }
        }

        System.out.println(list);
    }
}
