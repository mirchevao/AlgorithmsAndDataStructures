import java.util.HashSet;
public class arraySubsetOfAnotherArray {

    private static boolean isSubset(int arr1[], int arr2[], int m, int n)  {
        HashSet<Integer> hashSet =  new HashSet<>();
        for(int i =0; i< m; i++) {
            if(!hashSet.contains(arr1[i]))
                hashSet.add(arr1[i]);
        }
        for(int i =0; i<n; i++) {
            if(!hashSet.contains(arr2[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
