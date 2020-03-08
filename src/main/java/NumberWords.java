import java.util.Scanner;

public class NumberWords

{
    private static final String[] thousandsString = {
            "",
            " thousand"
    };

    private static final String[] tensString = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numberString = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    private String convertLessThanOneThousand(int number) {
        String current;

        if (number % 100 < 20){
            current = numberString[number % 100];
            number = number / 100;
        }
        else {
            current = numberString[number % 10];
            number = number / 10;

            current = tensString[number % 10] + current;
            number = number / 10;
        }
        if (number == 0) return current;
        return numberString[number] + " hundred" + current;
    }

    public String convert(int number) {

        if (number == 0) { return "zero"; }

        String prefix = "";
        String current = "";
        int index = 0;

        do {
            int num = number % 1000;
            if (num != 0) {
                String numText = convertLessThanOneThousand(num);
                current = numText + thousandsString[index] + current;
            }

            index++;
            number /= 1000;
        } while (number > 0);

        return (prefix + current).trim();
    }

    public static void main(String[] args) {

        // Test cases
        NumberWords numberWords = new NumberWords();
        int[] testNumbers = new int[] {123/*0, 2, 11, 17, 23, 100, 114, 756, 1010, 5500, 10000, 10001, 14389, 99999*/};

        for(int i : testNumbers) {
            System.out.println("Result: " + i + " => " + numberWords.convert(i));
        }


        while(true) {
            System.out.println("\nEnter your number:");
            Scanner sc = new Scanner(System.in);
            String nun = sc.nextLine();

            try {
                System.out.println("Result: " + numberWords.convert(Integer.parseInt(nun)));
            } catch(NumberFormatException ex) {
                System.out.println("Invalid number entered, " + ex);
            }
        }
     }
}
