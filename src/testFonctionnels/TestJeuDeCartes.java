package testFonctionnels;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.JeuDeCartes;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestJeuDeCartes {
	private JeuDeCartes jeu;
	@BeforeEach
	void setUp() throws Exception {
		jeu = new JeuDeCartes();
	}

	@Test
	void test() {
		jeu.affichageJeuDeCartes();
	}

}
