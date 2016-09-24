package io.egen.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movies.entity.Movie;
import io.egen.movies.entity.Rating;
import io.egen.movies.entity.User;
import io.egen.movies.repository.MovieRepository;
import io.egen.movies.repository.RatingRepository;
import io.egen.movies.repository.UserRepository;

@Service
public class RatingServiceImp implements RatingService{

	@Autowired
	RatingRepository ratingrepository;
	@Autowired
	MovieRepository movierepository;
	@Autowired
	UserRepository userrepository;

	@Autowired
	MovieService movieservice;
	
	@Override
	@Transactional
	public Rating createRating(Rating rating) {
		Movie movie =  movierepository.findone(rating.getMovie().getMovieId());
		User user  =  userrepository.findById(rating.getUser().getUserId());
		rating.setMovie(movie);
		rating.setUser(user);
		Rating rat  = ratingrepository.createRating(rating);
		updateAvgRating(rat);
		return rat;
	}
	
	@Override
	public List<Rating> getComments(Movie movie) {
		
		return ratingrepository.getComments(movie);
	}

	@Override
	public void updateAvgRating(Rating rating) {
		
		double avgRating = ratingrepository.updateAvgRating(rating);
		rating.getMovie().setAvgRating(avgRating);
		movieservice.updateAvgRating(rating.getMovie().getMovieId(), rating.getMovie());
	}

	
	
}

