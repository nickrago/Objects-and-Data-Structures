package lab02;

public class Library{
  public static void main(String[] args){
    Book[] library = new Book[3];
    library[0] = new Book("Old Man and the Sea", 400);
    library[1] = new Book("Catcher in the Rye", 200);
    library[2] = new Book("Harry Potter and the Sorcerer's Stone", 650);

    System.out.println("Titles:");

    // standard for loop
    for(int i = 0; i<library.length; i++)
      System.out.println(library[i].getTitle());

    System.out.println(" ");

    System.out.println("Page Numbers:");

    // enchanced for loop
    for(Book currentElement : library)
      System.out.println(currentElement.getNumPages());

    System.out.println(" ");

    System.out.println("Hand Calculated Num Pages: " + (library[0].getNumPages() + library[1].getNumPages() + library[2].getNumPages()));
    System.out.println("Num Pages in Library Function: " + numPagesInLibrary(library));

    System.out.println();

    System.out.println("Hand Calculated Most Pages: " + library[2].getNumPages());
    System.out.println("Most Pages in Library Function: " + mostPages(library));
  }

  public static int numPagesInLibrary(Book[] books){
    int sum = 0;
    for(Book currentElement : books)
      sum += currentElement.getNumPages();

    return sum;
  }

  public static int mostPages(Book[] books){
    int mostPages = books[0].getNumPages();
    for(int i = 0; i < books.length; i++){
      if(books[i].getNumPages() > mostPages) mostPages = books[i].getNumPages();
    }
    return mostPages;
  }

}
