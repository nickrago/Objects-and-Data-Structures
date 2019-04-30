package lab05;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class FunWithStrings{
	public static void swapMaxes(List<String> list, List<String> list2){
		if((list == null || list2 == null) || (list.size() == 0 || list2.size() == 0))
			throw new IllegalArgumentException("Cannot swap maxes of empty lists, null lists, or list with all null elements");
		
		int maxListIndex = 0;
		int maxList2Index = 0;		
		for(int i = 0; i<list.size(); i++){
			if((!(list.get(i) == null)) && (list.get(i).length() > list.get(maxListIndex).length())) maxListIndex = i;	
		}
		for(int j = 0; j<list2.size(); j++){
			if((!(list2.get(j) == null)) && (list2.get(j).length() > list2.get(maxList2Index).length())) maxList2Index = j;
		}

		String temp = list.get(maxListIndex);
		list.set(maxListIndex , list2.get(maxList2Index));
		list2.set(maxList2Index, temp);
	}
}
