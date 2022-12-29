package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepositoryObj;       // created object of MovieRepository class by @Autowired

   String addMovieToservice(Movie movie)
   {
       String repoResult = movieRepositoryObj.addMovieToDB(movie);
         // adding movie to database
       return repoResult;
   }

    String addDirectorToservice(Director director)
    {
        String repoResult = movieRepositoryObj.addDirectorToDB(director);
        // adding movie to database
        return repoResult;
    }
    String addMovieDirectorPair(String movieName, String directorName)
    {
        String repoResp = movieRepositoryObj.addDirect_movieToDB(movieName,directorName);
        return repoResp;
    }
    Movie getMovieByName(String name)
    {
        Movie repoResp = movieRepositoryObj.getMovieByMovieNameFromDB(name);
        return repoResp;
    }
    Director getDirectorByName(String name)
    {
        Director repoResp = movieRepositoryObj.getDirectorByNameFromDB(name);
        return repoResp;
    }
    ArrayList<String> getMoviesByDirectorName(String name)
    {
        ArrayList<String> result = movieRepositoryObj.getByDirectorMovieList(name);
        return result;
    }

    ArrayList<String> findAllMovies()
    {
        ArrayList<String> result = movieRepositoryObj.getListAllOfMovies();
        return result;
    }
    String deleteDirectorByName(String name)
    {
        String result = movieRepositoryObj.deleteDirectorByNameFromDB(name);
        return result;
    }

}
