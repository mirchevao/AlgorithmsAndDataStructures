import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeDLL {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        DLL<Integer> list = new DLL<>();
        String line = bufferedReader.readLine();
        String[] parts = line.split(" ");
        for(int i =0; i<n; i++) {
            list.insertLast(Integer.parseInt(parts[i]));
        }

        int len = list.length();
        int middle = (int)len/2;
        DLLNode<Integer> node1 = list.getFirst();
        DLLNode<Integer> node2 = list.getLast();
        boolean flag = false;
        for(int i =0; i<middle; i++) {
            if(node1.element != node2.element) {
                System.out.println("-1");
                break;
            } else flag= true;
        }

        if(flag)
            System.out.println("1");
    }
}
