package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

@Autowired
    MovieService movieServiceObj;      // created object of MovieService class by @Autowired

@PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie)
    {
       String serviceResult = movieServiceObj.addMovieToRepo(movie);
       return new ResponseEntity<>(serviceResult, HttpStatus.ACCEPTED);
    }
@PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director)
    {

    }

}
