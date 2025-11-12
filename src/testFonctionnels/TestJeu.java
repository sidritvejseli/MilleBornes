package testFonctionnels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.Jeu;
import jeu.Joueur;

class TestJeu {


	@Test
	void test() {
		Jeu jeuCourant = new Jeu();
		Joueur jack = new Joueur("Jack");
		Joueur bill = new Joueur("Bill");
		Joueur luffy = new Joueur("Luffy");
		
		jeuCourant.inscire(jack);
		jeuCourant.inscire(bill);
		jeuCourant.inscire(luffy);
		
		jeuCourant.distribuerCartes();
		
		System.out.println(jeuCourant.jouerTour(jack));
		System.out.println(jeuCourant.jouerTour(bill));
		System.out.println(jeuCourant.jouerTour(luffy));

		

	}

}
