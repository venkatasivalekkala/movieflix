package io.egen.movies.service;

import java.util.List;

import io.egen.movies.entity.Movie;
import io.egen.movies.entity.Rating;

public interface RatingService {
	Rating createRating(Rating rating);
	List<Rating> getComments(Movie movie);
	void updateAvgRating(Rating rating);
}
