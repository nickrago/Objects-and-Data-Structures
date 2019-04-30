package lab04;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileExtractor{
  private List<Integer> list;
  private int[] array;

  public FileExtractor(String fileName){
    list = new ArrayList<Integer>();
    try(Scanner sc = new Scanner(new File(fileName))){
      while(sc.hasNext()) list.add(sc.nextInt());
      array = new int[list.size()];
      for(int i = 0; i<list.size(); i++){
        array[i] = list.get(i);
      }
    }
    catch(FileNotFoundException e){
      int[] array = new int[0];
      System.out.println("File '" + fileName + "' not found, initializing both 'list' and 'array' to be empty\n");
    }
    catch(Exception e){
      System.out.println("Error occured while extracting data:\n");
      e.printStackTrace();
    }
  }

  public int[] getArray(){
    return this.array;
  }

  public List<Integer> getList(){
    return this.list;
  }

  public String toString(){
    return ("array: " + Arrays.toString(array) + "\nlist: " + list.toString());
  }

  public void removeOddElements(){
    int index = 0;
    int numEven = 0;
    for(int i : array){
      if(i%2 == 0) numEven++;
    }
    int[] tempArr = new int[numEven];

    for(int j : array){
      if(j%2 == 0){
        tempArr[index] = j;
        index++;
      }
    }
    array = tempArr;
  }

  public void removeEvenElements(){
    Iterator<Integer> iter = list.iterator();
    while(iter.hasNext()){
      Integer i = iter.next();
      if(i % 2 == 0) iter.remove();
    }
  }

  public FileExtractor(){}

  public static FileExtractor makeUsingStream(String fileName){
    var retVal = new FileExtractor();
    try(Stream<String> lines = Files.lines(Paths.get(fileName))){
      retVal.list = lines
        .map(line -> line.trim())
        .filter(line -> line.length() > 0)
        .map(Integer::valueOf)
        .collect(Collectors.toList());
      retVal.array = retVal.list.stream()
        .mapToInt(v -> v)
        .toArray();
    } catch (IOException e){
      e.printStackTrace();
    }
    return retVal;
  }

  public void streamRemoveOddElements(){
    array = list.stream()
      .mapToInt(v -> v)
      .filter(x -> x%2 == 0)
      .toArray();
  }

  public static FileExtractor oldWayButWorksOnAllFiles(String fileName){
    var retVal = new FileExtractor();
    retVal.list = new ArrayList<>();
    try (var b = new BufferedReader(new FileReader(fileName))){
      String readLine = "";
      while((readLine = b.readLine()) != null){
        retVal.list.add(Integer.valueOf(readLine.trim()));
      }
      retVal.array = new int[retVal.list.size()];
      int i = 0;
      for(int x : retVal.list) retVal.array[i++] = x;
    } catch (IOException e){
      e.printStackTrace();
    }
    return retVal;
  }
}
