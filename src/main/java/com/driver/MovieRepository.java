package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDB = new HashMap<>();
       // created Movie database using HashMap <MovieName, Movie object>
    HashMap<String,Director> directorDB = new HashMap<>();
        // created director database using HashMap <MovieName, Movie object>
    HashMap<String, List<String>> directorMovieList = new HashMap<>();
          // store movies names list which made by particular director

    //Add a movie
    String addMovieToDB(Movie movie)
    {
        String key = movie.getName();
        movieDB.put(key,movie);

        return "Movie added successfully..";
    }
// add director to db
    String addDirectorToDB(Director director)
    {
        String key = director.getName();
        directorDB.put(key,director);

        return "Director added successfully..";
    }
// add by director name and movie list of that director
    String addDirect_movieToDB(String movieName, String directorName)
    {
        if (directorDB.containsKey(directorName) && movieDB.containsKey(movieName))
        {
            if (directorMovieList.containsKey(directorName)) // if director name & list of movies already present
            {
                List<String> t = directorMovieList.get(directorName);
                t.add(movieName);
                directorMovieList.put(directorName, t);
            }
            else {
                List<String> a = new ArrayList<>();  // new list,
                a.add(movieName);
                directorMovieList.put(directorName, a);
            }
            return "successfully added ..movie - director pair added";
        }
        else return null;
    }
//Get Movie by movie name
    Movie getMovieByMovieNameFromDB(String name)
    {
        if (movieDB.containsKey(name)) return movieDB.get(name);
        else return null;
    }
//Get Director by Director name
    Director getDirectorByNameFromDB(String name)
    {
        for(String directorName: directorDB.keySet())
        {
            if(name.equals(directorName))
                return directorDB.get(directorName);
        }
        return null;
    }
//Get List of movies name for a given director name
    List<String> getByDirectorMovieList(String name)
    {
        List<String> moviesList = new ArrayList<String>();
        if(directorMovieList.containsKey(name)) moviesList = directorMovieList.get(name);
        return moviesList;
    }
//Get List of all movies added
   public List<String> getListAllOfMovies()
    {
       List<String> list = new ArrayList<>();
        for (String s: movieDB.keySet())
        {
           list.add(s);
        }
        return list;
    }
//Delete a director and its movies from the records
    String deleteDirectorByNameFromDB(String name)
    {
        directorDB.remove(name);
        List<String> temp = directorMovieList.get(name);
        directorMovieList.remove(name);
        for(int i =0;i<temp.size();i++)
        {
            if (movieDB.containsKey(temp.get(i)))
            {
                movieDB.remove(temp.get(i));
            }
        }
        return "Successfully Deleted a director and its movies from the records";
    }
//Delete all directors and all movies by them from the records
    String deleteAllDirectors()
    {
        for(String s: directorDB.keySet())
        {
            if(directorMovieList.containsKey(s)) // check if director present
            {
                List<String> temp = directorMovieList.get(s); //
                for(int i=0;i<temp.size();i++)   // delete all movies which are in movieNameList
                {
                    movieDB.remove(i);// delete all movies which are by this director
                }
                directorMovieList.remove(s);
            }
            directorDB.remove(s); // delete director from db
        }
        return "successfully Deleted all directors and all movies by them from the records  ";
    }
}
