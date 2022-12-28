package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MovieRepository {

    // creating database using HashMap <MovieName, Movie object>
    HashMap<String, Movie> movieDB = new HashMap<>();

    String addMovieToDB(Movie movie)
    {
        String key = movie.getName();
        movieDB.put(key,movie);

        return "Movie added successfully..";
    }

    String addDirectorToDB(Director director)
    {
       // String key = Director.getName();
       // movieDB.put(key,Movie);

        return "Director added successfully..";
    }

}
