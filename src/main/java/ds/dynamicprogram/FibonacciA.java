package ds.dynamicprogram;

public class FibonacciA {
	public static int fibonacci(int i) {
		if (i == 0) {
			return 0;
		}
		if (i == 1) {
			return 1;
		}

		System.out.println("i="+i);
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
	
	public static void main(String[] args) {
		/*int max = 35; // WARNING: If you make this above 40ish, your computer may serious slow down.
		int trials = 10; // Run code multiple times to compute average time.
		double[] times = new double[max]; // Store times
		
		
		for (int j = 0; j < trials; j++) { // Run this 10 times to compute
			for (int i = 0; i < max; i++) {
				long start = System.currentTimeMillis();
				int res = fibonacci(i);
				System.out.println("For " + i + ", " + res);
				long end = System.currentTimeMillis();
				long time = end - start;
				times[i] += time; 
			}
		}
		
		for (int j = 0; j < max; j++) {
			System.out.println(j + ": " + times[j] / trials + "ms");
		}*/

		System.out.println(fibonacci(5));
	}

}
