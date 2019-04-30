package lab05;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Division{
	private List<Double> list = new ArrayList<Double>();
	
	public Division(double[] array){
	
		if((array == null) || (array.length == 0)){
			throw new IllegalArgumentException("Need to enter an array with at least one double");			
		} else{
			for(int i = 0; i<array.length; i++){
				list.add(i, array[i]);		
			}	
		}
		
	}

	public void removeZeroes(){
		for(int i = 0; i<list.size(); i++){
			if(list.get(i) == 0.0){
				list.remove(i);
				i--;
			} 		
		}	
	}

	public void divide(int divisor){
		if(divisor == 0){
			throw new IllegalArgumentException("Can't divide by zero");
		} else {
			for(int i = 0; i<list.size(); i++){
				list.set(i, list.get(i) / divisor);			
			}		
		}
	}

	public String toString(){
		return list.toString();	
	}
}
