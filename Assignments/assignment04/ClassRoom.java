package assignment04.assignment04;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class ClassRoom{
  private Set<Student> roster = new TreeSet<>();
  private String className;

  public ClassRoom(){}

  public ClassRoom(String cName){
    this.className = cName;
  }

  public List<Student> getRoster(){
    return new ArrayList<>(roster);
  }

  public String getClassName(){
    return this.className;
  }

  public void addStudent(Student s){
    roster.add(s);
  }

  public void dropStudent(int id){
    var iter = roster.iterator();
    while(iter.hasNext()){
      if(iter.next().getId() == id) iter.remove();
    }
  }

  public String toString(){
		var sb = new StringBuilder(className);
    for(var x : roster) sb.append("\n" + x);
    return sb.toString();
	}

  public boolean isRegistered(int id){
    for(var stu : roster){
      if(stu.getId() == id) return true;
    }
    return false;
  }

  //make you're returning for null or 0 length right
   public List<Student> alsoRegisteredIn(ClassRoom... others){
     if(others == null || others.length == 0) return (new ArrayList<>(roster));
     var temp = new TreeSet<Student>(roster);
     for(var cRoom : others){
       temp.retainAll(cRoom.roster);
     }
     return new ArrayList<>(temp);
   }

   //make you're returning for null or 0 length right
   public static List<Student> registeredInOne(ClassRoom... others){
     if(others == null || others.length == 0) return (new ArrayList<>());
     var temp = new TreeSet<Student>();
     for(var cRoom : others){
       temp.addAll(cRoom.roster);
     }
     return new ArrayList<>(temp);
   }



}
