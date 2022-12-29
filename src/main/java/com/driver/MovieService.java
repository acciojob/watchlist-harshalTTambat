package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepositoryObj;       // created object of MovieRepository class by @Autowired

   public String addMovieToservice(Movie movie)
   {
       String repoResult = movieRepositoryObj.addMovieToDB(movie);
         // adding movie to database
       return repoResult;
   }

    public String addDirectorToservice(Director director)
    {
        String repoResult = movieRepositoryObj.addDirectorToDB(director);
        // adding movie to database
        return repoResult;
    }
    public String addMovieDirectorPair(String movieName, String directorName)
    {
        String repoResp = movieRepositoryObj.addDirect_movieToDB(movieName,directorName);
        return repoResp;
    }
    public Movie getMovieByName(String name)
    {
        Movie repoResp = movieRepositoryObj.getMovieByMovieNameFromDB(name);
        return repoResp;
    }
    public Director getDirectorByName(String name)
    {
        Director repoResp = movieRepositoryObj.getDirectorByNameFromDB(name);
        return repoResp;
    }
    public List<String> getMoviesByDirectorName(String name)
    {
        return movieRepositoryObj.getByDirectorMovieList(name);
    }
    List<String> findAllMovies()
    {
        List<String> result = movieRepositoryObj.getListAllOfMovies();
        return result;
    }
    String deleteDirectorByName(String name)
    {
        String result = movieRepositoryObj.deleteDirectorByNameFromDB(name);
        return result;
    }
    String deleteAllDirectors()
    {
        String result = movieRepositoryObj.deleteAllDirectors();
        return result;
    }

}
