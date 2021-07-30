import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitCollection {


    public static void main(String s[]) throws Exception {
        String thisLine = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int read = 1;

        int total = 0;
        List<Integer> list = new ArrayList<>();


        while ((thisLine = br.readLine()) != null) {
            //System.out.println(thisLine);

            if (read == 1)
                total = Integer.parseInt(thisLine.trim());

            if (read == 2) {
                String[] numbers = thisLine.split("\\s");
                Arrays.asList(numbers).forEach(n -> list.add(Integer.parseInt(n.trim())));
            }

            if (read >= 2)
                break;

            read++;
        }

        System.out.println(split(total, list));

    }

    private static List<List<Integer>> split(int n, List<Integer> list) {
        System.out.println("args: " + n + ", " + list);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        result.add(list1);
        result.add(list2);


        if (n % 2 == 0) {
            for (int i = 0; i <= (list.size()/2)-1; i++) {
                list1.add(list.get(i));
            }

            for (int i = list.size()/2; i <= list.size()-1; i++) {
                list2.add(list.get(i));
            }

        } else {
            for (int i = 0; i <= (list.size())/2; i++) {
                list1.add(list.get(i));
            }

            for (int i = (list.size()/2)+1; i <= list.size()-1; i++) {
                list2.add(list.get(i));
            }
        }



        return result;
    }
}
