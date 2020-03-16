import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mailSystem {


    static class Mail implements Comparable<Mail> {
        String naslov;
        int datum;
        int vreme;
        String sostojba;

        Mail(String naslov, int datum, int vreme, String sostojba) {
            this.naslov=naslov;
            this.datum=datum;
            this.vreme=vreme;
            this.sostojba=sostojba;
        }

        public int getDatum() {
            return datum;
        }

        public String getNaslov() {
            return naslov;
        }

        public int getVreme() {
            return vreme;
        }

        public String getSostojba() {
            return sostojba;
        }

        @Override
        public int compareTo(Mail mail) {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        CBHT<String,Mail> hash = new CBHT<String, Mail>(300);
        for(int i =0; i<n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            String naslov = parts[0];
            int datum = Integer.parseInt(parts[1]);
            int vreme = Integer.parseInt(parts[2]);
            String sostojba = parts[3];
            Mail mail = new Mail(naslov,datum,vreme,sostojba);
            hash.insert(sostojba,mail);

        }

        String sostojbi = bufferedReader.readLine();
        String[] parts = sostojbi.split(" ");
        for(int i =0; i<parts.length; i++) {
            String sostojbaa = parts[i];
            String[] finals =  sostojbaa.split("_");
            String sostojba = finals[0];
            String name = finals[1];
            String tmp = "";
            SLLNode<MapEntry<String,Mail>> node = null;
            if(sostojba.startsWith("READ")){
                 node = hash.search(sostojba);
                 if(node.element.value.getNaslov().equals(name)) {
                     sostojba = "DELETE";
                 }
            } else if (sostojba.startsWith("UNREAD"))  {
                node = hash.search(sostojba);
                if(node.element.value.getNaslov().equals(name)) {
                    sostojba = "READ";
                }
            } else if(sostojba.startsWith("DELETE")) {
                node = hash.search("DELETE");
                if(node.element.value.getNaslov().equals(name)) {
                    sostojba = "TRASH";
                }
            }
        }
        System.out.println(hash);
    }
}
