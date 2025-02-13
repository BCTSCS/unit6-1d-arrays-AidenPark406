import java.io.*;
import java.util.Scanner;

public class FileOperator {
    private String filePath;

    public FileOperator(String filePath) {
        this.filePath = filePath;
    }

    public String[] toStringArray(int arraySize) {
        String[] array = new String[arraySize];
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int index = 0;
            while (scanner.hasNext() && index < arraySize) {
                array[index] = scanner.nextLine();
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
        return array;
    }

    public int[] toIntArray(int arraySize) {
        int[] array = new int[arraySize];
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int index = 0;
            while (scanner.hasNextInt() && index < arraySize) {
                array[index] = scanner.nextInt();
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
        return array;
    }

    public double[] toDoubleArray(int arraySize) {
        double[] array = new double[arraySize];
        try (Scanner scanner = new Scanner(new File(filePath))) {
            int index = 0;
            while (scanner.hasNextDouble() && index < arraySize) {
                array[index] = scanner.nextDouble();
                index++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
        return array;
    }

    public static void main(String[] args) {
        FileOperator fileOperator = new FileOperator("test.txt"); // insert file here i guess

        // arraySize must be known for the code to work
        String[] stringArray = fileOperator.toStringArray(500); // random test value
        int[] intArray = fileOperator.toIntArray(500);
        double[] doubleArray = fileOperator.toDoubleArray(500);
    }

}
