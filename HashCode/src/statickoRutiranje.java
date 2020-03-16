import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Scanner;

public class statickoRutiranje {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        scan.nextLine();

        Hashtable<String, RouterNetworks> ipTable = new Hashtable<String, RouterNetworks>(2*n);

        for(int i =0; i<n; i++) {
            String router = scan.nextLine();
            String network = scan.nextLine();

            RouterNetworks networks = new RouterNetworks(network);
            ipTable.put(router,networks);
        }

        int m = scan.nextInt();
        scan.nextLine();

        for(int i=0; i<m; i++) {
            String router = scan.nextLine();
            String network = scan.nextLine();

            if(ipTable.containsKey(router)) {
                if(ipTable.get(router).has(network))
                    System.out.println("postoi");
                else System.out.println("ne postoi");
            } else System.out.println("ne postoi");
        }
        scan.close();
    }
}
class RouterNetworks {
    String[] networks;

    public RouterNetworks(String network) {
        String [] parts = network.split(",");
        networks = new String[parts.length];
        for(int i =0;i<parts.length;i++)
            networks[i] = parts[i];
    }

    public boolean has(String obj) {
        String[] n = obj.split("\\.");
        for(int i =0; i<networks.length; i++) {
            String[] r = networks[i].split("\\.");
            if(n[0].equals(r[0])&&n[1].equals(r[1]) && n[2].equals(r[2]))
                return true;
        }
        return false;
    }
}
