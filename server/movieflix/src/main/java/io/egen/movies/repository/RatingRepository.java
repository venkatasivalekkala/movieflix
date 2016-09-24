package io.egen.movies.repository;

import java.util.List;

import io.egen.movies.entity.Movie;
import io.egen.movies.entity.Rating;

public interface RatingRepository {
	Rating createRating(Rating rating);
	List<Rating> getComments(Movie movie);
	double updateAvgRating(Rating rating);

}
