package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepositoryObj;       // created object of MovieRepository class by @Autowired

   String addMovieToRepo(Movie movie)
   {
       String repoResult = movieRepositoryObj.addMovieToDB(movie);
         // adding movie to database
       return repoResult;
   }

}
