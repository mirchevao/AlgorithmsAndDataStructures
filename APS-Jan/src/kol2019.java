import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kol2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String [] parts1 = bufferedReader.readLine().split(" ");
        DLL<Integer> list1 = new DLL<>();
        for(int i =0; i<parts1.length; i++)
            list1.insertLast(Integer.parseInt(parts1[i]));

        String [] parts2= bufferedReader.readLine().split(" ");
        DLL<Integer> list2 = new DLL<>();
        for(int i =0; i<parts2.length; i++)
            list2.insertLast(Integer.parseInt(parts2[i]));

        DLLNode<Integer> node1 = list1.getFirst();
        DLLNode<Integer> node2 = list2.getFirst();

        DLL<Integer> result = new DLL<>();

        while (node1 != null) {
            if(node1.element % 2 == 0) {
                result.insertLast(node1.element);
                node1 = node1.succ;
            } else node1 = node1.succ;
        }

        while (node2 != null) {
            if(node2.element % 2 != 0) {
                result.insertLast(node2.element);
                node2 = node2.succ;
            } else node2 = node2.succ;
        }

        DLLNode<Integer> res = result.getFirst();
        while (res != null) {
            DLLNode<Integer> tmp = res.succ;
            while (tmp!= null) {
                if(res.element > tmp.element) {
                    int pom = res.element;
                    res.element =  tmp.element;
                    tmp.element = pom;
                }
                tmp = tmp.succ;
            }
            res = res.succ;
        }

        System.out.println(result);
    }
}
