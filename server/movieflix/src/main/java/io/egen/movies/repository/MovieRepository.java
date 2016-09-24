package io.egen.movies.repository;

import java.util.List;

import io.egen.movies.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();
	public Movie update(String movieId, Movie mv);
	public void delete(Movie mv);
	public Movie  create(Movie mv);
	public Movie findByImdb(String imdbID);
	public Movie findone(String movieId);
	public List<Movie> topRated(String type);
	public List<Movie> sortByImdbRatings();
	public List<Movie> sortByImdbVotes();
	public List<Movie> sortByYear();
	public Movie updateAvgRating(String movieId,Movie movie);
	public List<Movie> freeTextSearch(String freeText);
}
