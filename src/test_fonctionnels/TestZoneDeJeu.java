package test_fonctionnels;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Borne;
import cartes.DebutLimite;
import cartes.FinLimite;
import jeu.ZoneDeJeu;

class TestZoneDeJeu {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		ZoneDeJeu zone = new ZoneDeJeu();
		zone.deposer(new Borne(25));
		zone.deposer(new Borne(50));
		zone.deposer(new Borne(75));
		
		System.out.println("Total de bornes : "+ zone.donnerKmParcourus());
		
		System.out.println("Limite: "+ zone.donnerLimitationVitesse());
		zone.deposer(new DebutLimite());
		System.out.println("Limite: "+ zone.donnerLimitationVitesse());
		zone.deposer(new FinLimite());
		System.out.println("Limite: "+ zone.donnerLimitationVitesse());

	}

}
