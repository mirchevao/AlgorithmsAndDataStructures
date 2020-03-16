import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class buknaiz {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        DLL<String> list = new DLL<>();
        String[] parts = bufferedReader.readLine().split(" ");
        for(int i =0; i<n; i++) {
            list.insertLast(parts[i]);
        }

        bukvi(list);
    }

    public static void bukvi(DLL<String> list) {
        DLLNode<String> node = list.getFirst();

        while (node.succ != null)  {
            if(node.element.equals(node.succ.element)) {
                list.delete(node);
                node = node.succ;
            } else node =  node.succ;
        }
        node = list.getFirst();

        while (node.succ != null) {
            if(node.element.equals("a") && (node.succ.element.equals("e") || node.succ.element.equals("i") || node.succ.element.equals("o") || node.succ.element.equals("u"))) {
                list.delete(node.succ);
                node = node.succ;
            } else if (node.element.equals("e") && (node.succ.element.equals("a") || node.succ.element.equals("i") || node.succ.element.equals("o") || node.succ.element.equals("u"))) {
                list.delete(node.succ);
                node = node.succ;
            } else if (node.element.equals("i") && (node.succ.element.equals("e") || node.succ.element.equals("a") || node.succ.element.equals("o") || node.succ.element.equals("u"))) {
                list.delete(node.succ);
                node = node.succ;
            } else if (node.element.equals("o") && (node.succ.element.equals("e") || node.succ.element.equals("a") || node.succ.element.equals("i") || node.succ.element.equals("u"))) {
                list.delete(node.succ);
                node = node.succ;
            } else if (node.element.equals("u") && (node.succ.element.equals("e") || node.succ.element.equals("a") || node.succ.element.equals("i") || node.succ.element.equals("o"))) {
                list.delete(node.succ);
                node = node.succ;
            } else node = node.succ;
        }

        DLLNode<String> nodefinal = list.getFirst();
        while (nodefinal!=null) {
            System.out.print(nodefinal.element + " ");
            nodefinal = nodefinal.succ;
        }


    }
}

