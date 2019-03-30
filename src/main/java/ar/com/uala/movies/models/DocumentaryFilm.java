package ar.com.uala.movies.models;

import java.time.LocalDate;

public class DocumentaryFilm extends Product {

	
	
	public DocumentaryFilm(LocalDate premiere, Integer duration, String title) {
		super(premiere, duration, title);
	}

	@Override
	Boolean isInteresting() {
		if (title.contains("unofficial")) { 
			return true;
		}
		return false;
	}

}
