package testFonctionnels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.Sabot;

class TestSabot {
	private Sabot sabot1;
	@BeforeEach
	void setUp() throws Exception {
		sabot1 = new Sabot();
	}

	@Test
	void test() {
		
		while (!sabot1.estVide()) {
			System.out.println("je pioche " + sabot1.piocher().toString());
		}
	}

	
	@Test
	void test2() {
		
		while (!sabot1.estVide()) {
			System.out.println("je pioche " + sabot1.piocher().toString());
		}
	}
}
