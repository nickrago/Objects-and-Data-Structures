package lab05;

public class Zipper{
	public Zipper(){}

	public static int[] zip(int[] arr1, int[] arr2){		
		
		if((arr1 == null || arr2 == null) || (!(arr1.length == arr2.length))) throw new IllegalArgumentException("Bad Input");	
		int[] altArray = new int[arr1.length + arr2.length];
		int x = 0; int y = 0;
		for(int i = 0; i<altArray.length; i++){
			if(i%2 == 0){altArray[i] = arr1[x]; x++;}
			if(!(i%2 == 0)){altArray[i] = arr2[y]; y++;};		
		}
		return altArray;
	}
}
