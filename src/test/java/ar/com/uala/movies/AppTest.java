package ar.com.uala.movies;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.com.uala.movies.models.DocumentaryFilm;
import ar.com.uala.movies.models.Film;
import ar.com.uala.movies.models.Notification;
import ar.com.uala.movies.models.Product;
import ar.com.uala.movies.models.Serie;
import ar.com.uala.movies.models.User;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	List<Notification> notifications = new ArrayList<>();
	List<Product> products = new ArrayList<>();
	@Before
	public void initialize() {
		
		notifications.add(new Notification(Notification.Type.EMAIL, true));
		notifications.add(new Notification(Notification.Type.SMS, false));
		notifications.add(new Notification(Notification.Type.PHONE, false));

		products.add(new Film(LocalDate.parse("2018-02-05"), 200, "Capitana Marvel", false));
		products.add(new Film(LocalDate.parse("2011-07-28"), 119, "Capitan America", false));
		products.add(new Film(LocalDate.parse("1999-02-05"), 180, "Titani", true));
		products.add(new Serie(LocalDate.parse("2009-12-05"), 55, "The Walking Dead", 2));
		products.add(new Serie(LocalDate.now(), 45, "Gotham", 2));
		products.add(new Serie(LocalDate.parse("2004-09-27"), 43, "Lost", 6));
		products.add(new DocumentaryFilm(LocalDate.parse("2010-06-25"), 93, "Restrepo"));
		products.add(new DocumentaryFilm(LocalDate.parse("2003-03-03"), 98, "Living with Michael Jackson unofficial"));

	}
	
	@Test
	public void testIsUserOld() {
		User user = new User(User.State.MELANCOLICO, Arrays.asList(products.get(1), 
				products.get(4)), notifications);
		assertTrue(user.isOld());
		user = new User(User.State.MELANCOLICO, Arrays.asList(products.get(0), 
				products.get(4)), notifications);
		assertFalse(user.isOld());
	}
	
	@Test
	public void testUserWatchSomeInteresting() {
		User user = new User(User.State.MELANCOLICO, Arrays.asList(products.get(2), products.get(3), 
						products.get(7)), notifications);
		assertTrue(user.watchSomeinteresting());
		user = new User(User.State.MELANCOLICO, Arrays.asList(products.get(0), products.get(3), 
						products.get(6)), notifications);
		assertFalse(user.watchSomeinteresting());
	}
	
	@Test
	public void testGetRecomendaciones() {
		User user = new User(User.State.TRISTE, Arrays.asList(products.get(2)), notifications);
		user.getRecomendaciones(products).forEach(p -> {
			assertTrue(p.getDuration() > 120);
		});
		user.setState(User.State.MELANCOLICO);
		user.getRecomendaciones(products).forEach(p -> {
			assertTrue(ChronoUnit.YEARS.between(p.getPremiere(), LocalDate.now()) >= 10);
		});
	}
	
	@Test
	public void testActivarNotificacion() {
		User user = new User(User.State.TRISTE, Arrays.asList(products.get(2)), notifications);
		user.getNotifications().forEach(p -> {
			if(p.getType().equals(Notification.Type.SMS)) {
				assertFalse(p.getActive());
			}
		});
		user.activarNotificacion(Notification.Type.SMS);
		user.getNotifications().forEach(p -> {
			if(p.getType().equals(Notification.Type.SMS)) {
				assertTrue(p.getActive());
			}
		});
	}
	
	@Test
	public void testDesactivarNotificacion() {
		User user = new User(User.State.TRISTE, Arrays.asList(products.get(2)), notifications);
		user.getNotifications().forEach(p -> {
			if(p.getType().equals(Notification.Type.EMAIL)) {
				assertTrue(p.getActive());
			}
		});
		user.desactivarNotificacion(Notification.Type.EMAIL);
		user.getNotifications().forEach(p -> {
			if(p.getType().equals(Notification.Type.EMAIL)) {
				assertFalse(p.getActive());
			}
		});
	}

}
