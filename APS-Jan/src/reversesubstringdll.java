import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reversesubstringdll {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        DLL<Integer> list = new DLL<>();
        for(int i =0; i<parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));
        int n = Integer.parseInt(bufferedReader.readLine());
        int m =  Integer.parseInt(bufferedReader.readLine());
        int distance = m-n;
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getFirst();

        for(int i =0; i<n; i++)
            first = first.succ;
        for(int i =0; i<m; i++)
            last = last.succ;

        DLLNode<Integer> help = first;

        for(int i =0; i<distance; i++) {
            list.insertAfter(help.element, last);
            help = help.succ;
        }
        DLLNode<Integer> help2 = first;
        for(int i =0; i<distance; i++) {
            list.delete(help2.succ);
        }
        list.delete(help2);
        System.out.println(list);

    }
}
