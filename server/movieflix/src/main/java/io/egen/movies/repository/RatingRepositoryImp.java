package io.egen.movies.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.movies.entity.Movie;
import io.egen.movies.entity.Rating;

@Repository
public class RatingRepositoryImp implements RatingRepository{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Rating createRating(Rating rating) {
		em.persist(rating);
		updateAvgRating(rating);
		return rating;
	}

	@Override
	public List<Rating> getComments(Movie movie) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.getComments", Rating.class);
		query.setParameter("movie", movie);
		List<Rating> comments = query.getResultList();
		if(comments!=null)
			return comments;
		else
			return null;
	}

	@Override
	public double updateAvgRating(Rating rating) {
		Movie  movie =  rating.getMovie();
		TypedQuery<Double> query= em.createQuery("SELECT AVG(u.rating) FROM Rating u where u.movie=:movie",Double.class);
		query.setParameter("movie", movie);
		
		return  query.getSingleResult();
	}
	

}
