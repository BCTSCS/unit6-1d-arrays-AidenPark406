import java.io.IOException;
import java.io.File;
import java.util.Scanner; 

public class DataAnalyzer {
    public static int LinearSearch(int[] numbers, int targetNumber) {
        int index = 0;
        while (index < numbers.length) {
            if (numbers[index] == targetNumber) {
                return index;
            }

            index++;
        }

        return -1;

    }


    public static int BinarySearch(int[] numbers, int targetNumber) {
        int minIndex = 0;
        int maxIndex = numbers.length - 1;

        while (minIndex <= maxIndex) {
            int middleIndex = (minIndex + maxIndex) / 2;
            if (targetNumber == numbers[middleIndex]) {
                return middleIndex;
            }
            else {
                if (targetNumber > numbers[middleIndex]) {
                    minIndex = middleIndex + 1;
                }

                else {
                    maxIndex = middleIndex - 1;
                }
            }
        }
        return -1;

    }

    public static int[] ReverseList(int[] numbers) {
        int originalIndex = 0;
        int length = numbers.length;
        int[] newlist = new int[length];
        for (int i = length-1; i >= 0; i--) {
            newlist[i] = numbers[originalIndex];
            originalIndex++;
        }

        return newlist;
    }

    public static String ReverseListToString(int[] numbers) {
        String finalString = "[";
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) {finalString = finalString + numbers[i];}
            else {finalString = finalString + numbers[i] + ", ";}
        }

        finalString = finalString + "]";
        return finalString;
    }

    public static void main(String[] args) {

        int[] numbers = new int[100];        

        try {
            File f = new File("numbers.txt");
            Scanner input = new Scanner(f);
            for (int i = 0; i < 100; i++) {
                int temp = input.nextInt();
                numbers[i] = temp;
            }

            input.close();
        }

        catch(IOException e) {
            System.out.println("file not found!");
        }

        System.out.println(LinearSearch(numbers, 35));
        System.out.println(BinarySearch(numbers, 35));
        System.out.println(ReverseListToString(ReverseList(numbers)));
    }
}
