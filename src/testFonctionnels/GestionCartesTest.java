package testFonctionnels;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utils.GestionCartes;

class GestionCartesTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 1, 2, 1, 3));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(1, 4, 3, 2, 4, 2, 1));

		List<Integer> l3 = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 1));
		List<Integer> l4 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
		List<Integer> l5 = new ArrayList<>();

		
		assertTrue(GestionCartes.verifierMelange(l1,l3));
		assertTrue(!GestionCartes.verifierMelange(l1,l2));
		assertTrue(!GestionCartes.verifierMelange(l1,l4));
		
		assertTrue(!GestionCartes.verifierRassemblement(l2));
		System.out.println(GestionCartes.verifierRassemblement(GestionCartes.rassembler(l2)));
		System.out.println(GestionCartes.rassembler(l2));
		
		assertTrue(GestionCartes.verifierRassemblement(GestionCartes.rassembler(l2)));

		System.out.println(GestionCartes.melanger(l1));
		System.out.println(GestionCartes.rassembler(l2));
		

	}

}
