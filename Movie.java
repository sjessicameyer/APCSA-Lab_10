import java.util.ArrayList;

public class Movie { //implements Comparable<Movie>{
  
  private int year;
  private String title;
  private String director;
  private String genre;
  private ArrayList<String> actors;
  
  //constructors
  Movie(int year){
    this.year = year;
  }
  
  Movie(int year, String title, String director, String genre, ArrayList<String> actors){
    this.year = year;
    this.title = title;
    this.director=director;
    this.genre=genre;
    this.actors=actors;
  }


  //methods
  public int getYear() {
    return year;
  }

  public String getTitle() {
    return title;
  }

  public String getGenre() {
    return genre;
  }

  public ArrayList getActors() {
    return actors;
  }
  
  public String getDirector() {
    return director;
  }

  public void setActors(ArrayList actors) {
    this.actors = actors;
  }
  
  public void setDirector(String director) {
    this.director = director;
  }
  
  public void setGenre(String genre) {
    this.genre = genre;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public void setYear(int year) {
    this.year = year;
  }

  public String toString() {
    return "Year of release: "+this.getYear()+ ", Title: "+this.getTitle()+", Director: "+ getDirector()+", Genre: "+this.getGenre()+", Actors: "+actors.toString();
  }

  public boolean equals(Movie this2) {
    if (this.getTitle()==this2.getTitle()&&this.getYear()==this2.getYear())
      return true;
    return false;
  }

  public int compareTo(Movie this2){
    if (this.getYear()==this2.getYear())
      return this2.getTitle().compareTo(this.getTitle());
    return this2.getYear()-this.getYear();
  }

}