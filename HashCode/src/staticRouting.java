import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class staticRouting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Hashtable<String, RouterNetwork> table = new Hashtable<>(2*n);
        for(int i =0; i<n; i++) {
            String router = bufferedReader.readLine();
            String network = bufferedReader.readLine();

            RouterNetwork routerNetwork = new RouterNetwork(network);
            table.put(router,routerNetwork);
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        for(int i =0; i<m; i++) {
            String router = bufferedReader.readLine();
            String network = bufferedReader.readLine();

            if(table.containsKey(router)) {
                if(table.get(router).has(network))
                    System.out.println("postoi");
                else System.out.println("ne postoi");
            } else System.out.println("ne postoi");
        }
    }
}
class RouterNetwork {
    String[] networks;
   public RouterNetwork(String network) {
        String[] parts = network.split("\\.");
        networks = new String[parts.length];
        for(int i =0; i<parts.length; i++)
            networks[i] = parts[i];
    }
    public boolean has(String obj ) {
        String[] n = obj.split("\\.");
        for(int i =0; i<networks.length; i++) {
            String[] r = networks[i].split("\\.");
            if(n[0].equals(r[0]) && n[1].equals(r[1]) && n[2].equals(r[2]))
                return true;
        }
        return false;
    }
}
