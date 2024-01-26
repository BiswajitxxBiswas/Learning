import java.util.Scanner;
public class Q7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int largestPosition = 0;
        int smallestPosition = 0;

        for (int i = 1; i <= 3; i++) {
            System.out.println("Enter element " + i);
            int num = input.nextInt();

            if (num > largest) {
                largest = num;
                largestPosition = i;
            }

            if (num < smallest) {
                smallest = num;
                smallestPosition = i;
            }
        }

        System.out.println("Largest number is: " + largest);
        System.out.println("Position of largest number is: " + largestPosition);
        System.out.println("Smallest number is: " + smallest);
        System.out.println("Position of smallest number is: " + smallestPosition);


    }
}