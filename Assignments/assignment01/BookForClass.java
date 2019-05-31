package assignment01;

public class BookForClass{
  private int numPages;
  private String title;

  public BookForClass(int nPages, String aTitle){
    this.numPages = nPages;
    this.title = aTitle;
  }

  public double pagesNeededPerDayToRead(int maxDays){
    return ((double)numPages/maxDays);
  }

  public int daysNeededToRead(int pagesReadPerDay){
    return ((int)Math.ceil(numPages/pagesReadPerDay) + 1);
  }

  public int needToRead(int fromPage, int toPage, int daysToDeadline){
    return ((int)Math.ceil((toPage-fromPage)/(double)daysToDeadline));
  }
}
