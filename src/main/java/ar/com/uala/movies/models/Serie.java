package ar.com.uala.movies.models;

import java.time.LocalDate;

public class Serie extends Product {

	public Integer seasons;
	

	public Serie(LocalDate premiere, Integer duration, String title, Integer seasons) {
		super(premiere, duration, title);
		this.seasons = seasons;
	}


	@Override
	Boolean isInteresting() {
		if(seasons >= 4) {
			return true;
		}
		return false;
	}

}
