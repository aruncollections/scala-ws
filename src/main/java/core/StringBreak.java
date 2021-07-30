package core;

public class StringBreak {

    public static void main(java.lang.String[] args) {

       System.out.println(new String("x"));
    }

    static class String {
        java.lang.String s;

        public String(java.lang.String s) {
            this.s = s;
        }

        @Override
        public java.lang.String toString() {
            return s;
        }
    }
}
