package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

@Autowired
    MovieService movieServiceObj;      // created object of MovieService class by @Autowired
// Add Movie
@PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie)
    {
       String serviceResult = movieServiceObj.addMovieToservice(movie);
       return new ResponseEntity<>(serviceResult, HttpStatus.ACCEPTED);
    }

// add Director
@PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director)
    {
        String serviceResult = movieServiceObj.addDirectorToservice(director);
        return new ResponseEntity<>(serviceResult, HttpStatus.ACCEPTED);
    }

// add movie-Director pair
@PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair
        (@RequestParam("movieName")String movieName, @RequestParam("directorName")String directorName)
    {
        String servResult = movieServiceObj.addMovieDirectorPair(movieName,directorName);
        if(servResult!=null)
         return new ResponseEntity<>(servResult,HttpStatus.CREATED);
        else
            return new ResponseEntity<>("failed..please enter valid names",HttpStatus.NOT_FOUND);
    }

// get movie by name
@GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
    {
        Movie response = movieServiceObj.getMovieByName(name);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

//get director by name
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
    {
        Director response = movieServiceObj.getDirectorByName(name);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

//Get List of movies name for a given director name
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director)
    {
        List <String> response = movieServiceObj.getMoviesByDirectorName(director);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
// get all movies in watchlist
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies()
    {
        List<String> response = movieServiceObj.findAllMovies();
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
//Delete a director and its movies from the records
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName")String name)
    {
        String response = movieServiceObj.deleteDirectorByName(name);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
//Delete all directors and all movies by them from the records
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        String response = movieServiceObj.deleteAllDirectors();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
