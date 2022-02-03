/** Heading  Lab 10**********************************************/
/*	Your name: Sarah Meyer
		Class block: 	G			Date Started: Feb 3 2022
		Lab Number: Lab 10
		Title: The Movies
		Purpose: Learn about the ArrayList class, use for_each loops and further improve knowledge of classes.
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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
      int year;
      String title;
      String director;
      String genre;
      int numActors=0;
      
      String line = inputFile.nextLine();
      for(int x = 0; x < 4; x++){
        int endIndex=line.indexOf(',');
        if (x==0)
          year = Integer.parseInt(line.substring(0, endIndex));
        if(x==1)
          title = line.substring(0, endIndex);
        if(x==2)
          director = line.substring(0, endIndex);
        if(x==4)
          genre = line.substring(0, endIndex);
        else
          numActors = Integer.parseInt(line.substring(0, endIndex));
        line = line.substring(endIndex+2);
      }

      //TODO: FIX ERRORS
      ArrayList<String> actors = new ArrayList<String>();
      for (var x = 0; x<numActors; i++){
        int endIndex=line.indexOf(',');
        if (endIndex==-1){
          actors.add(line);
        }else{
          actors.add(line.substring(0, endIndex));
          line = line.substring(endIndex+2);
        }
      }

      Movie movie = new Movie(year, title, director, genre, actors);
      movies.add(movie);
    }

    for (Movie movie : movies){
      System.out.println(movie.toString());
    }
  }
}