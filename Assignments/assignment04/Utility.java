package assignment04.assignment04;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utility{
  public static int[] concat(int[]... listOfArrays){
    if(listOfArrays == null) return null;
    if(listOfArrays.length == 0) return (new int[0]);

    //counts the number of elements in all of the arrays
    int numElements = 0;
    for(int i = 0; i<listOfArrays.length; i++){
      for(var num : listOfArrays[i]){
        numElements++;
      }
    }

    //makes one array with all elements
    int[] newArray = new int[numElements];
    //loop them all here
    int index = 0;
    for(int j = 0; j<listOfArrays.length; j++){
      for(var element : listOfArrays[j]){
        newArray[index] = element;
        index++;
      }
    }

    return newArray;
  }

  public static int[] merge(int[]... listOfArrays){
    //counts the number of elements in all of the arrays
    int numElements = 0;
    for(int j = 0; j<listOfArrays.length; j++){
      for(var num : listOfArrays[j]){
        numElements++;
      }
    }

    int[] newArray = new int[numElements];
    //adds all elements to newArray
    int index = 0;
    for(int x = 0; x<listOfArrays.length; x++){
      for(var element : listOfArrays[x]){
        newArray[index] = element;
        index++;
      }
    }
    Arrays.sort(newArray);

    //Arrays.sort(newArray);
    return newArray;
  }

}
