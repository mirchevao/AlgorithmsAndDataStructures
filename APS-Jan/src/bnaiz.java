import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bnaiz {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts =  bufferedReader.readLine().split(" ");
        DLL<String> list = new DLL<>();
        for(int i =0; i< parts.length; i++)
            list.insertLast(parts[i]);

        DLLNode<String> node = list.getFirst();

        while (node!=null) {
            DLLNode<String> tmp = node.succ;
            while (tmp != null) {
                if(node.element.equals(tmp.element)) {
                    list.delete(tmp);
                    tmp =  tmp.succ;
                } else tmp = tmp.succ;

            }
            node =node.succ;
        }

        node = list.getFirst();
        while (node.succ != null) {
            DLLNode<String> tmp = node.succ;
                if(node.element.equals("a") && (tmp.element.equals("e") || tmp.element.equals("i") || tmp.element.equals("o") || tmp.element.equals("u"))) {
                    list.delete(tmp);
                    tmp = tmp.succ;
                } else if (node.element.equals("e") && (tmp.element.equals("a") || tmp.element.equals("i") || tmp.element.equals("o") || tmp.element.equals("u"))) {
                    list.delete(tmp);
                    tmp = tmp.succ;
                } else if (node.element.equals("i") && (tmp.element.equals("e") || tmp.element.equals("a") || tmp.element.equals("o") || tmp.element.equals("u"))) {
                    list.delete(tmp);
                    tmp =  tmp.succ;
                } else if (node.element.equals("o") && (tmp.element.equals("e") || tmp.element.equals("i") || tmp.element.equals("a") || tmp.element.equals("u"))) {
                    list.delete(tmp);
                    tmp = tmp.succ;
                } else if (node.element.equals("u") && (tmp.element.equals("e") || tmp.element.equals("i") || tmp.element.equals("o") || tmp.element.equals("a"))) {
                    list.delete(tmp);
                    tmp = tmp.succ;
                } else
                    tmp = tmp.succ;

            node = node.succ;
            }

        System.out.println(list);
    }
}
//brisi duplikati
//ako se dve samoglaski edno do dr brisi
// ako se dva duplikati edno do dr brisi