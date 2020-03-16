import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;

public class reversekelements {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        for(int i =0; i<n; i++) {
            String[] parts = bufferedReader.readLine().split(" ");
            int numEl = Integer.parseInt(parts[0]);
            int reverse = Integer.parseInt(parts[1]);
            LinkedQueue<Integer> queue = new LinkedQueue<>();
            String[] line = bufferedReader.readLine().split(" ");
            for(int j = 0; j<numEl; j++) {
                queue.enqueue(Integer.parseInt(line[j]));
            }
            LinkedStack<Integer> stack = new LinkedStack<>();
            for(int j = 0; j<reverse; j++) {
                stack.push(queue.dequeue());
            }
            for(int j =0; j<reverse; j++) {
                queue.enqueue(stack.pop());
            }

            while (!queue.isEmpty()) {
                System.out.print(queue.dequeue());
            }
        }
    }
}
