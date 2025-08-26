import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1Part1Code {
    public static void main(String[] args) {  

    List<Integer> colA = new ArrayList<>();
    List<Integer> colB = new ArrayList<>();

    try {
      File myFile = new File("input.csv");
      Scanner scanner = new Scanner(myFile);  
      while (scanner.hasNextLine()) {
        colA.add(scanner.nextInt());
        colB.add(scanner.nextInt());
        // String data = scanner.nextLine(); 
      }
      scanner.close();
    } 
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    Collections.sort(colA);
    Collections.sort(colB);
    // System.out.println(colA);
    // System.out.println(colB);
    int colACounter = 0;
    int colBCounter = 0;
    List<Integer> diffList = new ArrayList<>();
    while (colACounter <1000 && colBCounter <1000) {
        int colAValue = colA.get(colACounter);
        int colBValue = colB.get(colBCounter);
        int diff = Math.abs(colAValue - colBValue);
        diffList.add(diff);      
        colACounter++;
        colBCounter++;
    }
    // System.out.println(diffList);
    int sum = 0;
        for (int i = 0; i < diffList.size(); i++) {
            sum += diffList.get(i);
        }
    System.out.println(sum);
  }  
}

































































    //    try {
    //         List<String> lines = Files.readAllLines(Paths.get(file));
    //         for (String line : lines) {
    //             String[] values = line.split(","); // Simple split by comma
    //             // Clean up each value
    //             for (int i = 0; i < values.length; i++) {
    //                 String value = values[i].trim(); // remove leading/trailing spaces
    //                 if (value.isEmpty()) {
    //                     value = ""; // replace blank cells
    //                 } else {
    //                     value = value.replace("   ", ","); // replace spaces inside with ","
    //                 }
    //                 values[i] = value; // update array
    //             }
    //             rows.add(values);
    //         }


    //         //print CSV
    //         for (String[] row : rows) {
    //             System.out.println(Arrays.toString(row));
    //         }

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }