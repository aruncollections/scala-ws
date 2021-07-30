import java.util.*;

public class QuickCheckJava {

    public static void main(String[] ar) {
        // System.out.println(lengthOfLongestSubstring("13234567"));
        //printMissingNumber(new int[]{1,2,4},4);
        //System.out.println(removeDuplicates(Arrays.asList(new Integer[]{1, 2, 2, 3, 3, 4})));
        System.out.println(decode("BB"));
        System.out.println(decode("ZA"));
    }

    static int decode(String column) {
        int result = 0;

        for(int i = 0; i < column.length(); i++) {
            char c = column.charAt(i);
            result = result * 26 + c - 'A' + 1;
        }

        return result;
    }

    public static int removeDuplicates(List<Integer> list) {
        int writeIndex = 1;

        for (int i = 1; i < list.size(); ++i) {
            if (!list.get(writeIndex - 1).equals(list.get(i))) {
                list.set(writeIndex++, list.get(i));
            }
        }


        list.forEach(System.out::print);
        System.out.println("---");
        return writeIndex;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i++] = nums[j];
                nums[i] = nums[j];
            }
        }

        for (int x = 0; x < nums.length; x++)
            System.out.print(nums[x]);

        return i + 1;
    }

    public static int negate(int a) {
        int neg = 0;
        int newSign = a < 0 ? 1 : -1;
        while (a != 0) {
            neg += newSign;
            a += newSign;
        }
        return neg;
    }

    static int lengthOfLongestSubstring(String s) {
       /* int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;*/

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while (i < n && j < n) {
            // try to extend the range [i, j]
            System.out.println(i + ", " + j);
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    static void permutation(String perm, String word) {
        System.out.println("perm: " + perm + ", word: " + word);

        if (word.isEmpty()) {
            System.out.println(perm + word);

        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i),
                        word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }

    }

    static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            System.out.println("n: " + number);
            bitSet.set(number - 1);
        }

        System.out.println("input: " + bitSet);

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);
        int lastMissingIndex = 0;
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }

    static void testHashcodeAndEqualsInMap() {
        HashMap<Data, String> map = new HashMap<>();

        Data d = new Data();
        d.name = "a";
        map.put(d, "a");

        d = new Data();
        d.name = "b";
        map.put(d, "b");

        d = new Data();
        d.name = "c";
        map.put(d, "c");

        map.forEach((x, y) -> System.out.println("x: " + x));

        Data get = new Data();
        get.name = "a";
        System.out.println("res: " + map.get(get) + ", " + get.hashCode());

        get = new Data();
        get.name = "a";
        System.out.println("res: " + map.get(get) + ", " + get.hashCode());
    }
}


class Data {
    public String name = "def";

    final String fin;

    static {
        System.out.println("static {}");
    }

    {
        fin = "final";
        System.out.println("Data block{}: " + name);
    }

    public Data() {
        System.out.println("Constructor: " + name);
    }

    public Data(String n) {
        name = n;
        System.out.println("Const " + name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;

        Data data = (Data) o;

        System.out.println("Equals For: this=" + this.name + ", data=" + data.name);
        //return true;
        //return name.equals(data.name);
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        System.out.println("Haschcode For: " + this.name + ", this.name hash:" + this.name.hashCode());
        //return name.hashCode();
        // return 1;
        return super.hashCode();
    }

    public String toString() {
        return name;
    }


    void m(int i) {
        System.out.println("super m(int)");
    }

    void m(Integer i) {
        System.out.println("sub m(Integer)");
    }
}

class Sub extends Data {
    String name = "x";

    {
        System.out.println("Data and " + this);
    }

    Sub() {
        System.out.println("Sub constructor");
    }

    public String toString() {
        return name;
    }

    void m(Integer i) {
        System.out.println("sub m(Integer)");
    }


}