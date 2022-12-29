package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;


@Repository
public class MovieRepository {
    HashMap<String,Movie> movieDB = new HashMap<>();
       // created Movie database using HashMap <MovieName, Movie object>
    HashMap<String,Director> directorDB = new HashMap<>();
        // created director database using HashMap <MovieName, Movie object>
    HashMap<String, ArrayList<String>> directorMovieList = new HashMap<>();
          // store movies names which made by particular director

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
        if (directorMovieList.containsKey(directorName))
        {
            ArrayList<String> t = directorMovieList.get(directorName);
            t.add(movieName);
            directorMovieList.put(directorName, t);
        }
        else {
            ArrayList<String> a = new ArrayList<>();
            a.add(movieName);
            directorMovieList.put(directorName, a);
        }
       return "movie - director pair added";
    }
//Get Movie by movie name
    Movie getMovieByMovieNameFromDB(String name)
    {
        for(String movieN : movieDB.keySet())
        {
            if(name.equals(movieN))
                return movieDB.get(movieN);
        }
        return null;
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
    ArrayList<String> getByDirectorMovieList(String name)
    {
        return directorMovieList.get(name);
    }
//Get List of all movies added
    ArrayList<String> getListAllOfMovies()
    {
        ArrayList<String> list = new ArrayList<>();
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
        ArrayList<String> temp = directorMovieList.get(name);
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
}
