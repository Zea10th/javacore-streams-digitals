import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4};

        int[] positivesInts = getFilteredInts(ints, x -> x > 0);
        int[] oddInts = getFilteredInts(positivesInts, x -> x % 2 == 0);

        int[] sortedInts = Arrays.copyOf(oddInts, oddInts.length);
        Arrays.sort(sortedInts);

        for (int i = 0; i < sortedInts.length; i++) {
            System.out.print(sortedInts[i] + " ");
        }
    }

    public static int[] getFilteredInts(int[] integers, Predicate<Integer> predicate) {
        int size = 0;

        for (int i = 0; i < integers.length; i++) {
            size += predicate.test(integers[i]) ? 1 : 0;
        }

        int[] result = new int[size];

        for (int i = 0, j = 0; i < integers.length; i++) {
            if (predicate.test(integers[i])) {
                result[j] = integers[i];
                j++;
            }
        }
        return result;
    }
}
