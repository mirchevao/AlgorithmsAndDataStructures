import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class apteka {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Map<cureName, Cure> table = new HashMap<>();
        for (int i =0; i<n; i++){
            String[] parts =  bufferedReader.readLine().split(" ");
            String name = parts[0];
            int positive = Integer.parseInt(parts[1]);
            int price = Integer.parseInt(parts[2]);
            int number = Integer.parseInt(parts[3]);
            Cure cure = new Cure(name,positive,price,number);
            cureName cureName = new cureName(name);
            table.put(cureName,cure);

        }

        while (true) {
            String name = bufferedReader.readLine();
            if(name.equals("KRAJ"))
                break;
            int number = Integer.parseInt(bufferedReader.readLine());
            cureName cureName = new cureName(name);
            if(table.containsKey(cureName)) {
                Cure cure = table.get(cureName);
                System.out.println(cure);
                if(cure.makeOrder(number))
                    System.out.println("napravena e naracka");
                else System.out.println("nema dovolno lekovi");
            } else System.out.println("nema takov lek");
        }
    }
}
class Cure {
    String name;
    int positive;
    int price;
    int number;

    Cure(String name, int positive, int price, int number) {
        this.name = name;
        this.number = number;
        this.positive = positive;
        this.price = price;
    }

    String getPositive(){
        if(positive == 1)
            return "POZ";
        else return "NEG";
    }
    boolean makeOrder(int n) {
        if(number >= n) {
            number-=n;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + "\n");
        stringBuilder.append(getPositive() + "\n");
        stringBuilder.append(price + "\n");
        stringBuilder.append(number);
        return stringBuilder.toString();
    }

}
class cureName {
    String name;

    cureName(String name) {
        this.name = name;
    }
    @Override
    public int hashCode() {
        return (29 * (29 * (29 * 0 + name.charAt(0)) + name.charAt(1))+ name.charAt(2)) % 102780;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj==null)
            return false;
        if(getClass()!=obj.getClass())
            return false;
        cureName other = (cureName) obj;
        if(name == null) {
            if(other.name !=null)
                return false;
            else if(!name.equals(other.name))
                return false;
        }
        return true;
    }
}