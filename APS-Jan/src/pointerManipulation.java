import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pointerManipulation {
    //1 2 3 4 5 6 7 8 9 10
    //1 10 2 9 3 8 4 7 5 6

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] parts = line.split(" ");
        DLL<Integer> list = new DLL<>();
        for(int i =0; i<parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));

        DLLNode<Integer> front = list.getFirst();
        DLLNode<Integer> back = list.getLast();
        DLL<Integer> result = new DLL<>();
        for (int i =0; i<list.length()/2; i++) {
            result.insertLast(front.element);
            result.insertLast(back.element);
            front= front.succ;
            back = back.pred;
        }
        System.out.println(result);

    }
}
