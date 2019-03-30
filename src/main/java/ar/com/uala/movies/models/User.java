package ar.com.uala.movies.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {
	
	public State state;
	private List<Product> products = new ArrayList<>();
	private List<Notification> notifications = new ArrayList<>();
	
	
	
	public User(State state, List<Product> products, List<Notification> notifications) {
		super();
		this.state = state;
		this.products = products;
		this.notifications = notifications;
	}


	public Boolean isOld(){
		return products.parallelStream().anyMatch(Product::isOld);
	}
	
	public enum State {
		TRISTE {
			@Override
			public String toString() {
				return "triste";
			}
		},
		CONTENTO {
			@Override
			public String toString() {
				return "contento";
			}
		},
		MELANCOLICO {
			@Override
			public String toString() {
				return "melancólico";
			}
		}
	}
	
	public String getState() {
		return this.state.toString();
		}
	

	public void setState(State state) {
		this.state = state;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public List<Notification> getNotifications() {
		return notifications;
	}


	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	
	public Boolean watchSomeinteresting() {
		return products.parallelStream().anyMatch(Product::isInteresting);
	}
	
	public List<Product> getRecomendaciones(final List<Product> products) {
		if (state == State.TRISTE)
			return products.parallelStream()
					.filter(p -> p.getDuration() >= 120)
					.collect(Collectors.toList());
		
		else if (state == State.MELANCOLICO)
			return products.parallelStream()
					.filter(p -> ChronoUnit.YEARS.between(p.getPremiere(), LocalDate.now()) >= 10)
					.collect(Collectors.toList());
		
		return products;
			
	}
}
