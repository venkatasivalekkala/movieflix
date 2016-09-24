package io.egen.movies.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({ 
	@NamedQuery(name = "Rating.getComments", query = "SELECT e FROM Rating e where e.movie =:movie")
})
public class Rating {
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String ratingId;
	private String comment;
	private int rating;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne
	private User user;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne
	private Movie movie;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

		public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", comment=" + comment + ", rating=" + rating + ", user=" + user + ", movie=" + movie + "]";
	}
	
}
