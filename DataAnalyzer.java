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
        int minIndex = 1;
        int maxIndex = numbers.length;

        while (minIndex < maxIndex) {
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

        int[] bruh = {0,1,2,3,4};
        System.out.println(LinearSearch(bruh, 2));
        System.out.println(BinarySearch(bruh, 4));
        System.out.println(ReverseListToString(ReverseList(bruh)));
    }
}
