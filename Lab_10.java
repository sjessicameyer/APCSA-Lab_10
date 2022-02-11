/**Lab 10**********************************************/
/*	Your name: Sarah Meyer
		Class block: 	G			Date Started: Feb 3 2022
		Lab Number: Lab 10
		Title: The Movies
		Purpose: Learn about the ArrayList class, use for_each loops and further improve knowledge of classes.
*/

import java.util.*;
import java.io.*;
import java.lang.String;

public class Lab_10{

  private static Scanner inputConsole;
  private static Scanner inputFile;

  Lab_10(){
    
    ArrayList<Movie> movies = new ArrayList<Movie>();

    //Setup Scanners
    inputConsole = new Scanner(System.in);

    System.out.print("What file would you like to import Movies from?: ");

    String pathname=inputConsole.next();
    File file = new File(pathname);
    try{
      inputFile = new Scanner(file);
    }catch(FileNotFoundException ex){
      System.out.println("Could not open file: "+pathname);
      System.exit(1);
    }

    //add each file into array list

    for(var i = 0; inputFile.hasNextLine(); i++){
      int year=0;
      String title="";
      String director="";
      String genre="";
      int numActors=0;
      
      String line = inputFile.nextLine();
      for(int x = 0; x < 5; x++){
        int endIndex=line.indexOf(',');
        if (x==0)
          year = Integer.parseInt(line.substring(0, endIndex));
        else if(x==1)
          title = line.substring(0, endIndex);
        else if(x==2)
          director = line.substring(0, endIndex);
        else if(x==3)
          genre = line.substring(0, endIndex);
        else
          numActors = Integer.parseInt(line.substring(0, endIndex));
        line = line.substring(endIndex+2);
      }

      ArrayList<String> actors = new ArrayList<String>();
      for (var x = 0; x<numActors; x++){
        int endIndex=line.indexOf(',');
        if (endIndex==-1)
          actors.add(line);
        else{
          actors.add(line.substring(0, endIndex));
          line = line.substring(endIndex+2);
        }
      }

      int y = 0;
      Movie movie = new Movie(year, title, director, genre, actors);
      while(y<movies.size()&&movies.get(y).compareTo(movie)>0)
        y++;
    
      movies.add(y, movie);

    }

    while(true){
      System.out.print("\n1 - displayList\n2 - insertItem\n3 - removeItem\n4 - saveList\n5 - quit\n\nWhich of the above would you like to do (type number)?: ");
      int choice=inputConsole.nextInt();
      inputConsole.nextLine();
      if (choice == 1){
        displayList(movies);
      }else if (choice == 2){
        insertItem(movies,inputConsole);
      }else if (choice == 3){
        removeItem(movies,inputConsole);
      }else if (choice == 4){
        saveList(movies, file);
      }else{
        quit(movies,file);
      }
    }
  }

  public void displayList(ArrayList<Movie> movies){
    for (Movie movie : movies){
      System.out.println("\n"+movie.toString());
    }
  }

  public void insertItem(ArrayList<Movie> movies, Scanner input){
    //year, title, director, genre, numActors, Actors
    System.out.print("\n-Add new Movie-\n\nYear of release: ");
    int year=input.nextInt();
    input.nextLine();
    System.out.print("Title: ");
    String title = input.nextLine();
    System.out.print("Director: ");
    String director = input.nextLine();
    System.out.print("Genre: ");
    String genre = input.next();
    input.nextLine();
    System.out.print("Number of Actors: ");
    int numActors = input.nextInt();
    input.nextLine();

    ArrayList<String> actors = new ArrayList<String>();

    for (var x = 0; x<numActors; x++){
      System.out.print("Actor #"+(x+1)+": ");
      actors.add(input.nextLine());
    }
    
    int y = 0;
    Movie movie = new Movie(year, title, director, genre, actors);
    while(y<movies.size()&&movies.get(y).compareTo(movie)>0)
      y++;
    movies.add(y, movie);
  }

  public void removeItem(ArrayList<Movie> movies, Scanner input){
    System.out.print("\n-Remove Movie-\n\nTitle of Movie: ");
    String title=input.nextLine();
    for (int i = 0; i<movies.size() ;i++)
      if (movies.get(i).getTitle().equals(title))
        movies.remove(i);
  }

  public void saveList(ArrayList<Movie> movies, File targetFile){
    System.out.print("\n-Saving List-\n");
    PrintWriter output = null;
	  try
	  {
		  output = new PrintWriter(targetFile);
	  }
	  catch (FileNotFoundException ex)
	  {
		  System.out.println("Cannot overwrite file");
		  System.exit(1);  // quit the program
	  }

    for (Movie movie: movies){
      output.append(movie.getYear()+", ");
      output.append(movie.getTitle()+", ");
      output.append(movie.getDirector()+", ");
      output.append(movie.getGenre()+", ");
      output.append(String.valueOf(movie.getActors().size()));
      for (int i = 0; i<movie.getActors().size() ; i++){
        output.append(", "+movie.getActors().get(i));
      }
    }
  }

  public void quit(ArrayList<Movie> movies, File file){
    saveList(movies,file);
    System.out.println("... Quitting Program");
    System.exit(1);
  }
}