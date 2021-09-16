package ds.array;

import java.util.ArrayList;
import java.util.List;

public class PrintSubSequences {

    public static void main(String[] args) {
        int[] arrA = {1, 2, 3, 4};
        new PrintSubSequences().printSubArrays2(arrA);
    }

    public void printSubArrays2(int[] arrA) {
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < arrA.length; i++) {
            List<Integer> sub = new ArrayList<>();
            List<Integer> temp;

            for (int j = i; j < arrA.length; j++) {
                sub.add(arrA[j]);
                //System.out.println(sub);
                temp = new ArrayList<>(sub);
                lists.add(temp);
            }
        }

        System.out.println(lists);
    }

    public void printSubArrays(int[] arrA) {
        int arrSize = arrA.length;
        //start point
        for (int startPoint = 0; startPoint < arrSize; startPoint++) {
            //group sizes
            for (int grps = startPoint; grps <= arrSize; grps++) {
                //if start point = 1 then
                //grp size = 1 , print 1
                //grp size = 2, print 1 2
                //grp size = 3, print 1 2 3 ans so on
                for (int j = startPoint; j < grps; j++) {
                    System.out.print(arrA[j] + " ");
                }
                System.out.println();
            }
        }
    }


}
