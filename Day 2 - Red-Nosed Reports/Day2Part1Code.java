import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day2Part1Code {
  public static void main(String[] args) {  
    List<String> myList = new ArrayList<>();

    try {
      File myFile = new File("input.csv");
      Scanner scanner = new Scanner(myFile);  
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        myList.add(line);
      }
      scanner.close();
    } 
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    int safeReports = 0;
    int unsafeReports = 0;

    for (String line : myList) {
      String[] values = line.split("\\s+");
      List<Integer> numbers = new ArrayList<>();
      for (String value : values) {
        numbers.add(Integer.parseInt(value));
      }

      boolean ascending = true;
      boolean descending = true;
      boolean safe = false;

      for (int i = 0; i < numbers.size() - 1; i++) {
        System.out.println("Row: " + numbers);
        int current = numbers.get(i);
        int next = numbers.get(i + 1);
        int difference = Math.abs(current - next);

        if (difference > 3) {
          System.out.println(current + " is more then 3 from " + next);
          safe = false;
          System.out.println(safe);
        }
        else if (difference == 0 ) {
          System.out.println(current + " is equal to " + next);
          safe = false;
          System.out.println(safe);
        }
        else if (difference <= 3 ) {
          System.out.println(current + " is " + difference +" from " + next);
          safe = true;
          System.out.println(safe);
        }
        if (!safe) {          
           System.out.println("Report is not safe.");
           unsafeReports++;
           break;
        }
        else {
          if (current < next) {
              descending = false;
          } else if (current > next) {
              ascending = false;
          }
          if (ascending) {
            safe = true;
            System.out.println("Numbers are ascending");
            System.out.println(safe);
          }
          else if (descending ) {
            safe = true;
            System.out.println("Numbers are descending");
            System.out.println(safe);
          } 
          else {
            safe = false;
            System.out.println("Numbers are mixed (not fully ascending/descending)");
            System.out.println(safe);
            System.out.println("Report is not safe.");
            unsafeReports++;
            break;
          }
        }
      }
      if (safe) {
        System.out.println("Report is safe.");
        safeReports++;
        }

    }
    System.out.println("\nSafe Reports: " + safeReports);
    System.out.println("Not Safe Reports: " + unsafeReports);
  }
}

