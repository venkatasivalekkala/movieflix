package io.egen.movies.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movies.exception.MovieAlreadyExistsException;
import io.egen.movies.exception.MovieNotFoundException;
import io.egen.movies.entity.Movie;
import io.egen.movies.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService{
	@Autowired
	MovieRepository movierepository;
	
	@Override
	public List<Movie> findAll() {
		return movierepository.findAll();
	}

	@Override
	@Transactional
	public Movie update(String movieId, Movie mv) throws MovieNotFoundException{
		Movie existing = movierepository.findone(mv.getMovieId());
		if(existing==null){
			throw new MovieNotFoundException("Movie with id:" + movieId + " not found");
		}
		return movierepository.update(movieId, mv);
	}

	@Override
	@Transactional
	public Movie createMovie(Movie mv) throws MovieAlreadyExistsException{
		Movie existing = movierepository.findByImdb(mv.getImdbID());
		if (existing != null) {
			throw new MovieAlreadyExistsException("Movie already exists: " + mv.getImdbID());
		}
		return movierepository.create(mv);
	}
	
	@Override
	@Transactional
	public void delete(String movieId) throws MovieNotFoundException{
		Movie existing = movierepository.findone(movieId);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with id:" + movieId + " not found");
		}
		movierepository.delete(existing);
	}

	@Override
	public List<Movie> topRated(String type) {
		return movierepository.topRated(type);
	}

	@Override
	public List<Movie> sortByImdbRatings() {
		return movierepository.sortByImdbRatings();
	}

	@Override
	public List<Movie> sortByImdbVotes() {
		return movierepository.sortByImdbVotes();
	}

	@Override
	public List<Movie> sortByYear() {
		return movierepository.sortByYear();
	}

	@Override
	public Movie findById(String movieId) throws MovieNotFoundException{
		Movie movie  = movierepository.findone(movieId);
		if(movie!=null)
			return movie;
		else
			throw new MovieNotFoundException("Movie with id:" + movieId + " not found");
	}

	@Override
	public List<Movie> freeTextSearch(String freeText) {
			return movierepository.freeTextSearch(freeText);
	}
	
	@Override
	public void updateAvgRating(String movieId, Movie movie) {
		movierepository.findone(movie.getMovieId());		
		movierepository.update(movieId, movie);
	}
}
