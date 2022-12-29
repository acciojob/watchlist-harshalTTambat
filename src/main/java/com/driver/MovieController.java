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
    Movie movie;
    Director director;

@PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie)
    {
       String serviceResult = movieServiceObj.addMovieToservice(movie);
       return new ResponseEntity<>(serviceResult, HttpStatus.ACCEPTED);
    }
@PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director)
    {
        String serviceResult = movieServiceObj.addDirectorToservice(director);
        return new ResponseEntity<>(serviceResult, HttpStatus.ACCEPTED);
    }
@PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair
        (@RequestParam("name")String movieName, @RequestParam("name")String directorName)
    {
        String servResult = movieServiceObj.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(servResult,HttpStatus.CREATED);
    }
@GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathParam("name")String MovieName)
    {
        Movie response = movieServiceObj.getMovieByName(MovieName);
        if (response == null)
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathParam("name")String DirectorName)
    {
        Director response = movieServiceObj.getDirectorByName(DirectorName);
        if (response == null)
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

//Get List of movies name for a given director name
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<ArrayList<String>> getMoviesByDirectorName(@PathParam("director") String directorName)
    {
        ArrayList <String> response = movieServiceObj.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
// get all movies in watchlist
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<ArrayList<String>> findAllMovies()
    {
        ArrayList<String> response = movieServiceObj.findAllMovies();
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
//Delete a director and its movies from the records
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String name)
    {
        String response = movieServiceObj.deleteDirectorByName(name);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
