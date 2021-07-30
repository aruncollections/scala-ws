public class StringManipulation {


    public static String removeDuplicates(char[] str) {
        if (str == null) return str.toString();
        int len = str.length;
        if (len < 2) return str.toString();

        int tail = 1;

        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) break;
            }
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;
        System.out.println("res : " + new String(str));
        return str.toString();
    }


    public static void main(String arg[]) {
        String s = "abc";
        String sArr[][] = new String[][]{{"1", "1"}, {"2", "2"}};


        for (int i = 0; i <= sArr.length - 1; i++) {
            System.out.println();
            for (int j = 0; j <= sArr[i].length - 1; j++) {
                sArr[i][j] = sArr[i][j] + 1;
                System.out.print(sArr[i][j]);
            }
        }
    }
}
