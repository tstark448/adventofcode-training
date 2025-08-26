import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1Part2Code {
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

    List<Integer> simList = new ArrayList<>();

    for (int i = 0; i < colB.size(); i++) {
      int colAValue = colA.get(i);
      int numberFrequency = Collections.frequency(colB, colAValue);
      if (numberFrequency > 0) {
        // System.out.println("Frequency of "+colAValue + " : " + numberFrequency);
        int simScore = colAValue * numberFrequency;
        // System.out.println(simScore);
        simList.add(simScore);
      }
    }
    // System.out.println(simList);
    int sum = 0;
    for (int i = 0; i < simList.size(); i++) {
        sum += simList.get(i);
    }
    System.out.println(sum);
  }
}