import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class listaodlisti {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        DLL<DLL<Integer>> list = new DLL<>();
        for(int i =0; i<n; i++) {
            DLL<Integer> tmp = new DLL<>();
            for(int j = 0; j<m; j++){
                tmp.insertLast(scanner.nextInt());
            }
            list.insertLast(tmp);
        }
        scanner.close();
        System.out.println(findMagicNumber(list));
    }

    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        DLLNode<DLL<Integer>> main = list.getFirst();
        DLLNode<Integer> nodeList = main.element.getFirst();
        long sum = 0;
        long product = 1;
        while (main !=null){
            sum = 0;
            nodeList = main.element.getFirst();
            while (nodeList != null)  {
                sum+=nodeList.element;
                nodeList=nodeList.succ;
            }
            product*=sum;
            main = main.succ;
        }
        return product;
    }
}
