import java.util.HashMap;
import java.util.spi.AbstractResourceBundleProvider;

public class TwoArraysEqual {

    public static void equal(int[] arr1, int[] arr2, int m, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i<m; i++) {
            map.put(i, arr1[i]);
        }
        int flag = 1;
        for(int i =0; i<n; i++) {
            if (m != n) {
                System.out.println("no");
                break;
            } else {

                if (map.containsValue(arr2[i]))
                    flag = 1;
                else flag = 0;

            }
        }
        if(flag == 1)
            System.out.println("yes");
        else System.out.println("no");
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 6};
        int arr2[] = {2, 3, 1, 4};
        int m = 5, n = 4;
        equal(arr1, arr2, m, n);
    }
}
