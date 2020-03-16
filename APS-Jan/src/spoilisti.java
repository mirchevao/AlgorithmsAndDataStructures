import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class spoilisti {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        DLL<Integer> list1 = new DLL<>();
        String line1 = bufferedReader.readLine();
        String[] parts1 = line1.split(" ");
        for(int i =0; i<n; i++)
            list1.insertLast(Integer.parseInt(parts1[i]));

        int m = Integer.parseInt(bufferedReader.readLine());
        DLL<Integer> list2 = new DLL<>();
        String line2 = bufferedReader.readLine();
        String[] parts2 = line2.split(" ");
        for(int i =0; i<m; i++)
            list2.insertLast(Integer.parseInt(parts2[i]));

        DLL<Integer> result = new DLL<>();
        DLLNode<Integer> front = list1.getFirst();
        DLLNode<Integer> back = list2.getLast();

        while (front != null && back != null) {
            if(front.element % 2 == 0) {
                result.insertLast(front.element);
                list1.delete(front);
                front = front.succ;
            } else front = front.succ;

            if(back.element % 2 == 0) {
                result.insertLast(back.element);
                list2.delete(back);
                back = back.pred;
            } else back = back.pred;
        }

        front = list1.getFirst();
        if(front != null) {
            while (front != null) {
                if(front.element % 2 == 0) {
                    result.insertLast(front.element);
                    list1.delete(front);
                    front = front.succ;
                } else front = front.succ;
            }
        }
        back = list2.getLast();
        if(back != null) {
            while (back!=null) {
                if(back.element % 2 == 0) {
                    result.insertLast(back.element);
                    list2.delete(back);
                    back=back.pred;
                } else back = back.pred;
            }
        }

        front = list1.getFirst();
        if(front != null) {
            while (front != null) {
                if(front.element % 2 != 0) {
                    result.insertLast(front.element);
                    front=front.succ;
                } else front = front.succ;
            }
        }
        back = list2.getLast();
        if(back!=null) {
            while (back!=null) {
                if(back.element % 2 != 0) {
                    result.insertLast(back.element);
                    back = back.pred;
                } else back = back.pred;
            }
        }

        DLLNode<Integer> finalnode = result.getFirst();
        while (finalnode != null) {
            System.out.print(finalnode.element + " ");
            finalnode=finalnode.succ;
        }
    }
}
