package ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        dfs(nums, results, new ArrayList<>(), 1);
        return results;
    }

    public static void dfs(int[] numbers, List<List<Integer>> results, List<Integer> result,
                           int recursion) {
        System.out.println("\ndfs | results: " + results);

        if (numbers.length == result.size()) {
            List<Integer> temp = new ArrayList<>(result);
            results.add(temp);
            System.out.println();
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("i = " + i);
            if (!result.contains(numbers[i])) {
                result.add(numbers[i]);
                System.out.println("recursion: " + recursion + ", i: " + i);
                System.out.println("result: " + result);
                dfs(numbers, results, result, (recursion == numbers.length ? 1 : ++recursion));
                System.out.println("i: " + i + ", removing " + result.get(result.size() - 1) + " from " + result);
                result.remove(result.size() - 1);
            }
        }
    }
}
