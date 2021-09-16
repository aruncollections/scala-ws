package ds.array;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {

    public static void main(String[] args) {
        deleteDuplicates(Arrays.asList(1, 1, 2, 3, 4, 4, 5));
        //removeDuplicates(new int[]{1, 1, 2, 3, 4, 4, 5});
    }

    public static int deleteDuplicates(List<Integer> list) {
        int slow = 0;
        int fast = 0;
        int size = list.size();

        while (fast < size) {
            int value = list.get(fast);
            System.out.println("value " + value + ", fast " + fast);
            while (fast < size && list.get(fast) == value) {
                fast++;
            }

            System.out.println("slow " + slow + ", fast " + fast + ", list: " + list);
            list.set(slow++, value);
            System.out.println("slow " + slow + ", fast " + fast + ", list: " + list);
            System.out.println();
        }

        int curr = slow;
        while (curr < size) {
            list.set(curr++, null);
        }

        System.out.println(list);
        return slow;
    }

    // duplicates moved away
    static int removeDuplicates(int arr[]) {
        int n= arr.length;

        // Return, if array is empty
        // or contains a single element
        if (n == 0 || n == 1)
            return n;

        int[] temp = new int[n];

        // Start traversing elements
        int j = 0;
        for (int i = 0; i < n - 1; i++)
            // If current element is not equal
            // to next element then store that
            // current element
            if (arr[i] != arr[i + 1])
                temp[j++] = arr[i];

        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        temp[j++] = arr[n - 1];

        // Modify original array
        for (int i = 0; i < j; i++)
            arr[i] = temp[i];

        for (int a: arr) {
            System.out.println(a + ", ");
        }
        return j;
    }

    // duplicates moved away
    static void deleteDuplicates2(List<Integer> list) {
        if (list.isEmpty()) return;

        int writeIndex = 1;

        for (int i = 1; i < list.size(); i++) {
            if (!list.get(writeIndex - 1).equals(list.get(i))) {
                list.set(writeIndex++, list.get(i));
            }
        }

        System.out.println(writeIndex);
        System.out.println(list);
    }
}
