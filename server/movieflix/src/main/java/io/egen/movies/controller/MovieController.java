package io.egen.movies.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movies.entity.Movie;
import io.egen.movies.exception.MovieAlreadyExistsException;
import io.egen.movies.exception.MovieNotFoundException;
import io.egen.movies.service.MovieService;

@RestController
@RequestMapping(path = "movies")
public class MovieController {
	
	@Autowired
	MovieService movieservice;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie mv) throws MovieAlreadyExistsException{
		System.out.println("Inside the controller  create");
		return movieservice.createMovie(mv);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll(){
		return movieservice.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET,path = "findTitleById/{movieid}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findById(@PathVariable("movieid") String movieId){
		return movieservice.findById(movieId);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("movieId") String movieId, @RequestBody Movie mv) throws MovieNotFoundException{
		return movieservice.update(movieId, mv);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{movieId}")
	public void delete(@PathVariable("movieId") String movieId) throws MovieNotFoundException{
		movieservice.delete(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "type/{type}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> topRated(@PathVariable("type") String type){
		return movieservice.topRated(type);
	}

	@RequestMapping(method = RequestMethod.GET, path = "imdbRating/{imdbRating}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByImdbRatings(){
		return movieservice.sortByImdbRatings();
	}

	@RequestMapping(method = RequestMethod.GET, path = "imdbVotes/{imdbVotes}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByImdbVotes(){
		return movieservice.sortByImdbVotes();
	}

	@RequestMapping(method = RequestMethod.GET, path="year/{year}" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortByYear(){
		return movieservice.sortByYear();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "freeText/{freeText}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> freeTextSearch(@PathVariable("freeText") String freeText){
		return movieservice.freeTextSearch(freeText);
	}
	
	
}
