import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dedomrazulici {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(bufferedReader.readLine());
        CBHT<String, Address> tabela = new CBHT<>(n);
        CBHT<String,String> changes;

        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            String ime = line;
            line = bufferedReader.readLine();
            String[] parts =  line.split(" ");
            String ulica = parts[0];
            int broj = Integer.parseInt(parts[1]);
            String grad = parts[2];
            String drzava = parts[3];
            Address address = new Address(ulica,broj,grad,drzava);
            tabela.insert(ime,address);
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        changes = new CBHT<>(m);
        for(int i =0; i<m; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            String staro = parts[0];
            String novo = parts[1];
            changes.insert(staro,novo);
        }
        String dete = bufferedReader.readLine();
        SLLNode<MapEntry<String,Address>> searchNode = tabela.search(dete);
        if(searchNode != null) {
            String streetname = searchNode.element.value.getUlica();
            SLLNode<MapEntry<String,String>> changed = changes.search(streetname);
            if(changed != null) {
                System.out.println(changed.element.value);
            } else System.out.println(streetname);
        } else System.out.println("nema");

    }

    static class Address{
        String ulica;
        int broj;
        String grad;
        String drzava;

        public Address(String ulica, int broj, String grad, String drzava) {
            this.ulica = ulica;
            this.broj = broj;
            this.grad = grad;
            this.drzava = drzava;
        }

        public String getUlica() {
            return ulica;
        }

        public int getBroj() {
            return broj;
        }

        public String getGrad() {
            return grad;
        }

        public String getDrzava() {
            return drzava;
        }
    }
}
