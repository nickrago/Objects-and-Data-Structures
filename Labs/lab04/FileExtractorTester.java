package lab04;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;


public class FileExtractorTester{
    public static void main(String[] args){
      try{
        if(args.length != 1){
          throw new IllegalArgumentException();
        }
        FileExtractor file = new FileExtractor(args[0]);
        System.out.println("~~~~~~~Printing List and Array~~~~~~~");
        System.out.println("Excpected: [5, 20, 8, 13, 46, 7]");
        System.out.println("\nActual:\n" + file);

        System.out.println("\n~~~~~~~Removing Odd Numbers~~~~~~~");
        System.out.println("Excpected: [20, 8, 46]");
        file.removeOddElements();
        System.out.println("Actual: " + Arrays.toString(file.getArray()));

        System.out.println("\n~~~~~~~Removing Even Numbers~~~~~~~");
        System.out.println("Excpected: [5, 13, 7]");
        file.removeEvenElements();
        System.out.println("Actual: " + file.getList());
      }
      catch(IllegalArgumentException e){
        System.out.println("The program requires exactly 1 argument, the name of a file to be opened");
      }


      System.out.println("\n~~~~~~~ForEach Loop Examples~~~~~~~");
      int[] arrayI = new int[5];
      int n = 0;
      for(int i : arrayI){
        i = n;
        n++;
      }
      System.out.println(Arrays.toString(arrayI));

      String[] arr = new String[]{"One", "Two", "Three", "Four"};
      System.out.print("[ ");
      for(String s : arr){
        System.out.print(s + " ");
      }
      System.out.print("]");
      System.out.println(" ");

      System.out.println("\n~~~~~~~Extra Code~~~~~~~");
      var test1 = FileExtractor.makeUsingStream(args[0]);
      test1.streamRemoveOddElements();
      System.out.println(test1);

      var test2 = FileExtractor.oldWayButWorksOnAllFiles(args[0]);
      test2.streamRemoveOddElements();
      System.out.println(test2);
    }
}
