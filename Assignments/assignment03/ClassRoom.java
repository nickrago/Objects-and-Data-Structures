package assignment03;
import java.util.List;
import java.util.ArrayList;

public class ClassRoom{
  private List<Student> roster = new ArrayList<>();

  public List<Student> getRoster(){
    return this.roster;
  }

  public void addStudent(Student s){
    roster.add(s);
  }

  public void dropStudent(int id){
    for(int i = 0; i<roster.size(); i++){
      if(roster.get(i).getId() == id){roster.remove(i);}
    }
  }

  public String toString(){
		return roster.toString();
	}

  public void sortById(){
    for(int i = 0; i < roster.size(); i++){
      for(int j = 1; j < (roster.size() - i); j++){
        if(roster.get(j-1).getId() > roster.get(j).getId()){
          Student temp = roster.get(j-1);
          roster.set(j-1, roster.get(j));
          roster.set(j, temp);
        }
      }
    }
  }

  public static void sortById(List<Student> list){
    for(int i = 0; i < list.size(); i++){
      for(int j = 1; j < (list.size() - i); j++){
        if(list.get(j-1).getId() > list.get(j).getId()){
          Student temp = list.get(j-1);
          list.set(j-1, list.get(j));
          list.set(j, temp);
        }
      }
    }
  }

  public boolean isRegistered(int id){
    boolean returned = false;
    for(int i = 0; i < roster.size(); i++){
      if(id == roster.get(i).getId())
        returned = true;
    }
    return returned;
  }

   public List<Student> alsoRegisteredIn(ClassRoom... others){
     if(others == null || others.length == 0) return roster;
     ArrayList alsoInDup = new ArrayList<>();
     for(int i = 0; i < roster.size(); i++){
       for(ClassRoom c : others){
           if(roster.get(i).getId() == c.getRoster().get(i).getId()){
              alsoInDup.add(roster.get(i));
          }
        }

      }

      ArrayList alsoInDis = new ArrayList<>();

      for(int j = 0; j < alsoInDup.size(); j++){
        if(!(alsoInDis.contains(alsoInDup.get(j)))){
          alsoInDis.add(alsoInDup.get(j));
        }
      }

     return alsoInDis;
   }

   public static List<Student> registeredInAll(ClassRoom... others){
     ArrayList inAllDup = new ArrayList<>();
     ArrayList inAll = new ArrayList<>();
     if(others == null || others.length == 0) return inAll;


     for(int i = 0; i < others[0].getRoster().size(); i++){
       for(ClassRoom c : others){
           if(others[0].getRoster().get(i).getId() == c.getRoster().get(i).getId()){
              inAllDup.add(others[0].getRoster().get(i));
          }
        }

      }

    for(int j = 0; j<inAllDup.size(); j++){
      if(numAppears(inAllDup, inAllDup.get(j).toString()) == others.length){
        inAll.add(inAllDup.get(j));
        inAllDup.set(j, new Student(0, "null"));
      }
    }

     return inAll;
   }

   //helper method
   public static int numAppears(List<Student> list, String name){
     int ret = 0;
     for(Student s : list){
       if(name == s.getName()) ret++;
     }
     return ret;
   }


   public static List<Student> registeredInOne(ClassRoom... others){
     ArrayList inOneA = new ArrayList<>();
     ArrayList inOneB = new ArrayList<>();
     ArrayList inOneF = new ArrayList<>();
     if(others == null || others.length == 0) return inOneA;

     for(int i = 0; i < others[0].getRoster().size(); i++){
       for(ClassRoom c : others){
           if(others[0].getRoster().get(i).getId() == c.getRoster().get(i).getId()){
              inOneA.add(others[0].getRoster().get(i));
          }
        }
      }

      for(int j = 0; j<inOneA.size(); j++){
        if(numAppears(inOneA, inOneA.get(j).toString()) > 1){
          inOneB.add(inOneA.get(j));
          inOneA.set(j, new Student(0, "null"));
        }
      }

      for(int q = 0; q<inOneB.size(); q++){
        for(int w = 1; w<inOneB.size(); w++){
          if((inOneB.get(q) == inOneB.get(w)) && (w != inOneB.size()-1))inOneB.remove(w);
        }
      }

     return inOneB;

   }



}
