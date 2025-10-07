package testFonctionnels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

class TestMethodeEquals {
	JeuDeCartes jeu = new JeuDeCartes();
	Sabot sabot = new Sabot(jeu.donnerCartes());

	@Test
	void test() {
		Carte carte1 = sabot.piocher();
		Carte carte2 = sabot.piocher();

		Carte cinquanteKm = new Borne(50);

		Carte feuRouge1 = new Attaque(Type.FEU);
		Carte feuRouge2 = new Attaque(Type.FEU);

		Carte crevaison = new Attaque(Type.CREVAISON);
		assertTrue(carte1.equals(carte2));
		assertTrue(!(carte1.equals(cinquanteKm)));
		assertTrue(feuRouge1.equals(feuRouge2));
		assertTrue(!feuRouge1.equals(crevaison));

	}

}
