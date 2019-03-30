package ar.com.uala.movies;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.com.uala.movies.models.DocumentaryFilm;
import ar.com.uala.movies.models.Film;
import ar.com.uala.movies.models.Notification;
import ar.com.uala.movies.models.Product;
import ar.com.uala.movies.models.Serie;
import ar.com.uala.movies.models.User;;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		List<Notification> notifications = new ArrayList<>();
		notifications.add(new Notification(Notification.Type.EMAIL, true));
		notifications.add(new Notification(Notification.Type.SMS, false));

		List<Product> products = new ArrayList<>();

		products.add(new Film(LocalDate.parse("2017-02-05"), 20, "Capitana Marvel", false));
		products.add(new Serie(LocalDate.now(), 120, "The Walking Dead", 2));
		products.add(new Film(LocalDate.parse("2011-07-28"), 124, "Capitan America", false));
		products.add(new Serie(LocalDate.now(), 120, "Gotham", 2));
		products.add(new Film(LocalDate.parse("1999-02-05"), 180, "Titani", true));
		products.add(new Serie(LocalDate.parse("2004-09-27"), 43, "Lost", 6));
		products.add(new DocumentaryFilm(LocalDate.parse("2010-06-25"), 93, "Restrepo"));

		
		final User user = new User(User.State.MELANCOLICO, Arrays.asList(products.get(1)), notifications);

		final Boolean isOld = user.isOld();
		user.getNotifications();
		System.out.println("Saber si un cliente es un antiguo. Lo es cuando solo mira productos viejos -  " + isOld);
		
		System.out.println("Saber si un cliente mira algo interesante " + user.watchSomeinteresting());
				
		System.out.println("Poder pedirle recomendaciones al sistema" + user.getRecomendaciones(products));
	}
}
