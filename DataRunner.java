
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

public class DataRunner {

    String fileName;
    int totalLines;

    public DataRunner(String fileName, int totalLines) {
        this.fileName = fileName;
        this.totalLines = totalLines;
    }

    public String[] sort() { // this method aims to sort any file in alphabetical order
        try {
            String[] words = new String[totalLines];
            Scanner scanner = new Scanner(new File(fileName));

            int index = 0;
            while (scanner.hasNextLine() && index < totalLines) {
                words[index++] = scanner.nextLine();
            }
            scanner.close();

            bubbleSort(words);
            return words;
        } 

        catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return new String[0];}
        }
        

        private static void bubbleSort(String[] arr) {
            int n = arr.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - 1 - i; j++) {
                    if (arr[j].compareTo(arr[j + 1]) > 0) {
                        String temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }
                if (!swapped) break;
            }
        }


    public static void main(String[] args) {

        DataRunner test1 = new DataRunner("albums.txt", 498);
        String[] sortedWords = test1.sort();
        
        System.out.println("\nSorted Words:");
        for (String word : sortedWords) {
            System.out.println(word);
        }
    }
}
