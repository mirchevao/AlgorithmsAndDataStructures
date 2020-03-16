import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class konsultacii {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int brkratki = Integer.parseInt(bufferedReader.readLine());
        LinkedQueue<String> kratkiPrasanja = new LinkedQueue<>();
        for(int i =0; i<brkratki; i++) {
            String line = bufferedReader.readLine();
            kratkiPrasanja.enqueue(line);
        }
        int brzadaci = Integer.parseInt(bufferedReader.readLine());
        LinkedQueue<String> zadaci = new LinkedQueue<>();
        for(int i =0; i<brzadaci; i++) {
            zadaci.enqueue(bufferedReader.readLine());
        }
        int zadve = Integer.parseInt(bufferedReader.readLine());
        LinkedQueue<String> dvete = new LinkedQueue<>();
        for(int i =0; i<zadve; i++) {
            dvete.enqueue(bufferedReader.readLine());
        }

        for(int i =0; i<zadve; i++) {
            String value = dvete.dequeue();
            kratkiPrasanja.enqueue(value);
            zadaci.enqueue(value);
        }
        LinkedQueue<String> finalred = new LinkedQueue<>();
        int flag = 1;
        int var = kratkiPrasanja.length+zadaci.length;

        for(int i =0; i<var; i++) {
            if((flag == 1 || zadaci.isEmpty()) && !kratkiPrasanja.isEmpty()) {
                finalred.enqueue(kratkiPrasanja.dequeue());
                flag = 0;
            }

            if((flag == 0 || kratkiPrasanja.isEmpty()) && !zadaci.isEmpty()) {
                finalred.enqueue(zadaci.dequeue());
                flag = 1;
            }
        }

        int len = finalred.length;
        for(int i =0; i<len; i++) {
            System.out.println(finalred.dequeue());
        }
    }
}
