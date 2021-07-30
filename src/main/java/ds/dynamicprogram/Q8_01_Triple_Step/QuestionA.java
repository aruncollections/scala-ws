package ds.dynamicprogram.Q8_01_Triple_Step;

public class QuestionA {
	
	public static int countWays(int n) {
        System.out.println("calc count " + n);

		if (n < 0) {
			System.out.println("returning 0 for " + n);
			return 0;
		} else if (n == 0) {
			System.out.println("returning 1");
			return 1;
		} else {
			return countWays(n - 1) + zero(n) +  countWays(n - 2) + countWays(n - 3);
		}
	}

    public static int zero(int i) {
        System.out.println("\nCalling next with " + i);
        return 0;
    }
	
	public static void main(String[] args) {
		int n = 5;
		int ways = countWays(n);
		System.out.println(ways);
	}

}
