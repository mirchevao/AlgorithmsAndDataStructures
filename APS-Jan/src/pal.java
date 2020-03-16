import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = bufferedReader.readLine().split(" ");
        DLL<Integer> list = new DLL<>();

        for(int i =0; i<parts.length; i++)
            list.insertLast(Integer.parseInt(parts[i]));
        boolean flag = false;
        DLLNode<Integer> node = list.getFirst();
        DLLNode<Integer> node1 = list.getLast();
        for(int i =0; i<list.length()/2; i++) {
            if(node.element == node1.element)
                flag =  true;
            else {
                System.out.println("-1");
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("1");
    }
}
