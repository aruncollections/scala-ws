
import java.util.*;

public class BalancedString {

    static String[] bal(String[] values) {
        String res[] = new String[values.length];

         for(int i =0; i<values.length; i++) {
             System.out.println("Testing: " + values[i]);
            res[i] = isBalanced(values[i]) ? "YES" : "NO";
         }

         return res;
    }

    public static boolean isBalanced(String in) {
        Stack<String> st = new Stack<String>();

        for (String ch : in.split(""))
        {
            System.out.println("For - " + ch);

            switch (ch)
            {
                case "{":
                case "(":
                case "[":
                    System.out.println("->Pushing " + ch);
                    st.push(ch);
                    break;
                case "]":
                    System.out.println("peek:" + st.peek());
                    if (st.isEmpty() || !st.pop().equals("[")) {
                        return false;
                    }
                    break;
                case ")":
                    System.out.println("peek:" +st.peek());
                    if (st.isEmpty() || !st.pop().equals("(")) {
                        return false;
                    }
                    break;
                case "}":
                    System.out.println("peek:" +st.peek());
                    if (st.isEmpty() || !st.pop().equals("{")) {
                        return false;
                    }
                    break;
            }
        }


        System.out.println("res: " + st.isEmpty());
        return st.isEmpty();
    }


    public static boolean isBalanced1(String in) {
        Stack<Character> st = new Stack<Character>();

        for (char chr : in.toCharArray()) {
            switch (chr) {
                case '{':
                case '(':
                case '[':
                    st.push(chr);
                    break;
                case ']':
                    if (st.isEmpty() || st.pop() != '[')
                        return false;
                    break;
                case ')':
                    if (st.isEmpty() || st.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (st.isEmpty() || st.pop() != '{')
                        return false;
                    break;
            }
        }
        return st.isEmpty();
    }


    public static void main(String args[]) {
        /*for(String s : bal(new String[]{"[(abc)]", "{[aa][bb]}", "[ds{"})) {
             System.out.println(s);
        }*/


        System.out.println(isBalanced("{[]}"));
    }
}



