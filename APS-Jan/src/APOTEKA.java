import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class APOTEKA {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        HashMap<Key,Lek> hashMap = new HashMap<>();
        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            Lek lek = new Lek(parts[0].toUpperCase(),Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
            Key ime = new Key(parts[0].toUpperCase());
            hashMap.put(ime,lek);
        }

        while (true) {
            String line = bufferedReader.readLine();
            if(line.equals("KRAJ"))
                break;
            int amount = Integer.parseInt(bufferedReader.readLine());
            if(!hashMap.containsKey(new Key(line.toUpperCase()))){
                System.out.println("Nema takov lek");
            } else {
                Lek lek = hashMap.get(new Key(line.toUpperCase()));
                int test = lek.shop(amount);
                if(test == -1) {
                    System.out.println(lek.getIme());
                    System.out.println(lek.getType());
                    System.out.println(lek.getCena());
                    System.out.println(lek.getZaliha());
                    System.out.println("Nema dovolno lekovi");
                } else {
                    System.out.println(lek.getIme());
                    System.out.println(lek.getType());
                    System.out.println(lek.getCena());
                    System.out.println(test);
                    System.out.println("Napravena naracka");
                }
            }
        }



    }

    static class Key  {
        String name;

        public Key(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int hashCode() {
            int sum = 0;
            for(int i =0; i<name.length(); i++) {
                sum+= (int) name.toUpperCase().charAt(i);
            }

            return ((29 *(29 *( 29 + sum))) % 102780);
        }

       public boolean equals(Object object) {
            if(object == null || object.getClass() != this.getClass())
                return false;
            Key key = (Key) object;
            return name.equals(key.name);
       }
    }

    static class Lek {
        String ime;
        String type;
        int cena;
        int zaliha;

        public Lek(String ime, int type, int cena, int zaliha) {
            this.ime = ime;
            if(type == 0) {
                this.type = "NEG";
            } else this.type = "POZ";

            this.cena = cena;
            this.zaliha = zaliha;
        }

        public String getIme() {
            return ime;
        }

        public String getType() {
            return type;
        }

        public int getCena() {
            return cena;
        }

        public int getZaliha() {
            return zaliha;
        }

        public int shop(int amount) {
            if(amount <= zaliha) {
                zaliha-=amount;
                return zaliha + amount;
            }
            else return -1;
        }
    }
}
