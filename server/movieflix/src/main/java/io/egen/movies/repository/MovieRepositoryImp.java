package io.egen.movies.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.movies.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	
	}

	@Override
	public Movie update(String movieId, Movie mv) {
		return em.merge(mv);
	}

	@Override
	public void delete(Movie mv) {
		em.remove(mv);
	}
	
	@Override
	public Movie create(Movie mv) {
		 em.persist(mv);
		 return mv;
	}

	@Override
	public Movie findByImdb(String imdbID) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByImdb", Movie.class);
		query.setParameter("pImdbId", imdbID);
		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1) {
			return movies.get(0);
		}
		return null;
		
	}

	@Override
	public List<Movie> topRated(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.topRated", Movie.class);
		query.setParameter("type", type);
		List<Movie> movies =query.getResultList();
		if ( movies.size() > 0) {
			return movies;
		}
		return null;
		 
	}

	@Override
	public List<Movie> sortByImdbRatings() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByImdbRatings", Movie.class);
		List<Movie> movies =query.getResultList();
		if ( movies.size() > 0) {
			return movies;
		}
		return null;

	}

	@Override
	public List<Movie> sortByImdbVotes() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByImdbVotes", Movie.class);
		List<Movie> movies =query.getResultList();
		if ( movies.size() > 0) {
			return movies;
		}
		return null;

	}

	@Override
	public List<Movie> sortByYear() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.sortByYear", Movie.class);
		List<Movie> movies =query.getResultList();
		if ( movies.size() > 0) {
			return movies;
		}
		return null;

	}

	@Override
	public Movie findone(String movieId) {
		Movie movie  = em.find(Movie.class, movieId);
		if(movie!=null)
			return movie;
		else return null;
	}

	@Override
	public List<Movie> freeTextSearch(String freeText) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.freeTextSearch", Movie.class);
		query.setParameter("freeText", "%"+ freeText + "%");
		List<Movie> movies =query.getResultList();
		if ( movies.size() > 0) {
			return movies;
		}
		return null;
	}

	@Override
	public Movie updateAvgRating(String movieId, Movie movie) {
		return em.merge(movie);

	}
}
