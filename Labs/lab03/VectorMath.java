//package lab03;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VectorMath{

	//returns the magnitude of vector
	public static Optional<Double> magnitude(List<Double> vect){
	    if((vect==null)){return Optional.empty();}
		if((vect.size()==0)){return Optional.of(0.0);}

		double sum = 0;
		for(int i = 0; i<vect.size(); i++){
			sum+= (vect.get(i) * vect.get(i));
		}

		return Optional.of(Math.sqrt(sum));
	}

	//multiplies vect by some scalar value
	//actually modifies the vector, does not return a separate one
	public static void scalarProduct(List<Double> vect, double scale){
	    if(!(vect == null)){
		for(int i = 0; i<vect.size(); i++){
		    vect.set(i, i*scale);
		}
	    }
	}

	//returns the dotProduct between two vectors
	public static Optional<Double> dotProduct(List<Double> vect1, List<Double> vect2){
		if((vect1 == null) || (vect2 == null)){return Optional.empty();}
		if((vect1.size() == 0) || (vect2.size() == 0)){return Optional.of(0.0);}
		double sum = 0;
		for(int i = 0; i<vect1.size() && i<vect2.size(); i++){
			sum+=(vect1.get(i) * vect2.get(i));
		}
		return Optional.of(sum);
	}

	//returns whether two vectors are orthogonal
	public static boolean isOrthogonal(List<Double> vect1, List<Double> vect2){
	    boolean returnVal = false;
	    Optional<Double> test = dotProduct(vect1, vect2);
	    if(test.isPresent()){
		returnVal = test.get() == 0.0;
	    }
	    return returnVal;
	}

	//performs vector addition, returning a new vector
	public static Optional<List<Double>> vectorAddition(List<Double> vect1, List<Double> vect2){
	    if((vect1 == null) || (vect2 == null)){return Optional.empty();}

		List<Double> list = new ArrayList<>();
		for(int i = 0; i < vect1.size() || i < vect2.size(); i++){
		    list.add(0.0);
		    if(vect1.size()>i){list.set(i, (list.get(i)+vect1.get(i)));}
			    if(vect2.size()>i){list.set(i, (list.get(i)+vect2.get(i)));}
		}
		return Optional.of(list);

	}
}
