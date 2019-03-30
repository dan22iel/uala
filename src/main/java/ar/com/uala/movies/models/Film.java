package ar.com.uala.movies.models;

import java.time.LocalDate;

public class Film extends Product {

	public Boolean hasOscar;
		
	
	public Film(LocalDate premiere, Integer duration, String title, Boolean hasOscar) {
		super(premiere, duration, title);
		this.hasOscar = hasOscar;
	}

	@Override
	Boolean isInteresting() {
		if(hasOscar){
			return true;
		}
		return false;
	}

}
