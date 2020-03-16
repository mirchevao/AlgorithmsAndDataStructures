import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class company {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        SLL<Vraboten> list = new SLL<>();
        for(int i =0; i<n; i++) {
            String idline = bufferedReader.readLine();
            String plataline = bufferedReader.readLine();
            int id = Integer.parseInt(idline);
            int plata = Integer.parseInt(plataline);
            Vraboten vraboten = new Vraboten(id,plata);
            list.insertLast(vraboten);
        }

        int amount = Integer.parseInt(bufferedReader.readLine());

        SLLNode<Vraboten> node = list.getFirst();
        while (node != null) {
            if(node.element.plata < amount) {
                list.delete(node);
                node = node.succ;
            } else  {
                node = node.succ;
            }
        }


        node = list.getFirst();
        while (node != null) {
            SLLNode<Vraboten> tmpNode = node.succ;
            while (tmpNode!=null) {
                if(node.element.id < tmpNode.element.id) {
                    int tmp1 = node.element.id;
                    node.element.id = tmpNode.element.id;
                    tmpNode.element.id=tmp1;

                    int tmp2 = node.element.plata;
                    node.element.plata = tmpNode.element.plata;
                    tmpNode.element.plata=tmp2;
                }
                tmpNode=tmpNode.succ;
            }
            node=node.succ;
        }

        node = list.getFirst();
        while (node!=null) {
            System.out.println(node.element.id + " " + node.element.plata);
            node=node.succ;
        }
    }

    static class Vraboten {
        int id;
        int plata;

        public Vraboten(int id, int plata) {
            this.id = id;
            this.plata = plata;
        }

        public int getId() {
            return id;
        }

        public int getPlata() {
            return plata;
        }
    }
}
