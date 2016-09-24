package io.egen.movies.service;

import java.util.List;


import io.egen.movies.entity.Movie;

public interface MovieService {

	List<Movie> findAll();
	Movie update(String movieId, Movie mv);
	void delete(String movieId);
	Movie  createMovie(Movie mv);
	List<Movie> topRated(String type);
	List<Movie> sortByImdbRatings();
	List<Movie> sortByImdbVotes();
	List<Movie> sortByYear();
	Movie findById(String movieId);
	List<Movie> freeTextSearch(String freeText);
	void updateAvgRating(String movieId,Movie movie);
}
