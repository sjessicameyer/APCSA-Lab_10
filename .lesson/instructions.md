# Lab 10
### The Movies

#### Objective: 
Learn about the `ArrayList` class, use for_each loops and further improve knowledge of classes. 

#### Description:
Write a menu-driven program to maintain a database of Movie(s) in a list stored in numerical order by year using Java’s `ArrayList` class, and appropriately use `for_each` loops.  

**First:** create a class called Movie.  The data that a Movie object must maintain include the following:

    - Year of release 
    - Title of Movie
    - Director of Movie
    - Genre of Movie
    - a built-in array of actors

In addition to the above class data members you need constructors, getters and setters, a toString for displaying the information, an equals method (two movies are deemed the same if the year *and* title are the same) and a compareTo using the year for sorting purposes.  

*Note:* If multiple movies have the same year of release then we use the tile to determine the order.

**Second:** create a text file containing a few of your favorite movies and all the needed information.  Your file format must match the format described below.  Do not list too many and be sure they are not already in sorted order.  Your program should *prompt* the user for a text file name and then read the data from the file, inserting each movie into your ArrayList so that the list is ordered by year as you insert them.  Movies with the same year are sorted by the title secondarily.   **Do not read them all in and then sort.**

**Finally:** your program should loop around a menu providing these options, each as a separate method:

- 1 - displayList : Print out the list, one movie with all it’s info per line
- 2 - insertItem : Add a new movie in the correct place.
- 3 - removeItem : Prompt for a Movie to be removed (By Title is advised).
- 4 - saveList : Output the list, overwriting the existing file.
- 5 - quit : End the program, over-writing your current list in the file.  


#### Tips:

Make sure your program works with an empty text-file, adding movies to the following list positions: first, interim, and last spots of a non-empty list.  

Do not allow duplicate movies into your ordered list, though they may be entered by the user for adding.  

Also verify that one can ask to remove an item that is not in the list.

You may use Integer class methods if you feel you have to.  Maximum number of actors is 9, Minimum is 1.

#### Required File Format:

	Year, Title of Movie, Director’s name, Movie Genre, # of actors, Actor #1, Actor #2… etc.

#### Example:

1989, Field of Dreams, Phil Alden Robinson, Drama, 5, Kevin Costner, Amy Madigan, James Earl Jones, Ray Liotta, Burt Lancaster

### Scoring Guide

| Requirement | Possible Points |
| :---        |    :----:   | 
| On time submission | 4 | 
| Header filled in with name, block, etc. | 2 |
| Correctly uploaded zipped replit project to Google Classroom | 2 |
| Movie class created and meeting all specs in Lab | 12 |
| Proper initialization of ArrayList | 2 |
| Properly read through a text file inserting Movies correctly into the list | 4 |
| Proper menu method with 5 options that loops | 3 |
| Proper display method | 2 |
| Properly functioning insert method (no dupes) | 5 |
| Properly functioning remove method | 3 |
| Properly Output the list to a text file method | 3 |
| Properly wtitten Quit and output method | 2 |
| Proper usage of for_each loop | 3 |
| Properly thought out code that is efficient | 3 |
| **Total:** | **50** |

***  