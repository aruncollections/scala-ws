package ds.array;

import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        //System.out.println(permute(new int[]{1, 2, 3}));
        //System.out.println(subsets(new int[]{1, 2, 3}));
        //System.out.println(combinationSum(new int[]{1, 2, 2, 3}, 4));
        permutationUsingCollectionsSwap(Arrays.asList(1,2,3));
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

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        //System.out.println("list " + list + " | tempList" + tempList + " | start " + start);
        System.out.println("tempList: " + tempList + " | start: " + start);

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            System.out.println("\tB | tempList: " + tempList + " | start: " + start);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
            System.out.println("\tA | tempList: " + tempList + " | start: " + start);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack2(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack2(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack2(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    // Not working
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack3(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack3(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack3(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    // Not working exaclty
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack4(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack4(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack4(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void permutationUsingCollectionsSwap(List<Integer> list) {
        Random gen = new Random();
        Set<List<Integer>> result = new HashSet<>();
        int factorial = 0;

        for (int i = 0; i < list.size(); ++i) {
            int next = gen.nextInt(list.size() - i);
            System.out.println("next: " + next + ", i: " + i + ", factorial: " + factorial);
            Collections.swap(list, i, i + next);
            result.add(new ArrayList<>(list));

            if(i==2 && factorial < 6) {
                i = -1;
                factorial++;
            }
        }

        result.forEach(System.out::println);
    }

    static void random() {
        Random random = new SecureRandom();

        /*for(Provider p: Security.getProviders()) {
            System.out.println(p);
        }*/

        for (int i = 0; i < 3; i++) {
            System.out.println(random.nextInt(3));
        }
    }
}
