package ar.com.uala.movies.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Product {
	
	public LocalDate premiere;
	public Integer duration; //en minutos
	public String title;
	
	public Product(LocalDate premiere, Integer duration, String title) {
		this.premiere = premiere;
		this.duration = duration;
		this.title = title;
	}

	public Boolean isOld() {
		if(ChronoUnit.YEARS.between(premiere, LocalDate.now()) > 1) return true; 
		return false;
	}
	
	public LocalDate getPremiere() {
		return premiere;
	}

	public void setPremiere(LocalDate premiere) {
		this.premiere = premiere;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	abstract Boolean isInteresting();

}
