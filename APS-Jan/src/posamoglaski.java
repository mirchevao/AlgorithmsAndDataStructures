import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class posamoglaski {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        DLL<String> list = new DLL<>();
        String line = bufferedReader.readLine();
        String[] parts = line.split(" ");

        for(int i=0; i<n; i++)
            list.insertLast(parts[i]);

        DLLNode<String> back = list.getLast();
        DLLNode<String> front = list.getFirst();

        int middle = list.length()/2;
        DLL<String> samoglaski = new DLL<>();
        DLL<String> soglaski = new DLL<>();

        for(int i =0; i<middle + 1; i++) {
            if(front.element.equals("a") || front.element.equals("e") || front.element.equals("i") || front.element.equals("o") || front.element.equals("u")) {
                samoglaski.insertLast(front.element);
                front = front.succ;
            } else  {
                soglaski.insertLast(front.element);
                front=front.succ;
            }

            if(back.element.equals("a")  || back.element.equals("e")  || back.element.equals("i")  || back.element.equals("o")  || back.element.equals("u")) {
                samoglaski.insertLast(back.element);
                back=back.pred;
            } else {
                soglaski.insertLast(back.element);
                back= back.pred;
            }
        }

        DLLNode<String> samoglaska = samoglaski.getFirst();
        DLLNode<String> soglaska = soglaski.getFirst();

        while (samoglaska != null) {
            DLLNode<String> tmp = samoglaska.succ;
            while (tmp != null) {
                if(samoglaska.element == tmp.element) {
                    samoglaski.delete(tmp);
                    tmp = tmp.succ;
                } else tmp=tmp.succ;
            }
            samoglaska=samoglaska.succ;
        }

        while (soglaska != null) {
            DLLNode<String> tmp = soglaska.succ;
            while (tmp!=null) {
                if(soglaska.element == tmp.element) {
                    soglaski.delete(tmp);
                    tmp = tmp.succ;
                } else tmp=tmp.succ;
            }
            soglaska=soglaska.succ;
        }

        samoglaska = samoglaski.getFirst();
        soglaska = soglaski.getFirst();

        while (samoglaska!=null) {
            System.out.print(samoglaska.element + " ");
            samoglaska = samoglaska.succ;
        }
        System.out.println();
        while (soglaska != null) {
            System.out.print(soglaska.element + " ");
            soglaska = soglaska.succ;
        }
    }
}
