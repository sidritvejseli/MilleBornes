package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	private static final Random random = new Random();

	public static <T> T extraire(List<T> liste) {

		int indiceAleatoire = (random.nextInt(liste.size()));

		return liste.remove(indiceAleatoire);
	}

	public static <T> T extraireIterator(List<T> liste) {

		int indiceAleatoire = (random.nextInt(liste.size()));
		ListIterator<T> iterateur = liste.listIterator(indiceAleatoire);
		T element = iterateur.next();

		iterateur.remove();
		return element;
	}

	public static <T> List<T> melanger(List<T> liste) {
		List<T> listeMelange = new ArrayList<>();

		for (int i = 0; i < liste.size(); i++) {
			listeMelange.add(extraireIterator(liste));
		}

		return listeMelange;

	}

	public static <T> boolean verifierMelange(List<T> list1, List<T> list2) {

		if (list1.size() != list2.size()) {
			return false;
		} else {
			for (T element1 : list1) {
				int freq1 = Collections.frequency(list1, element1);
				int freq2 = Collections.frequency(list2, element1);
				if (freq1 != freq2) {
					return false;
				}
			}
		}
		return true;
	}

	private static <T> void removeOccurrences(ListIterator<T> it, T element) {
		while (it.hasNext()) {
			if (it.next().equals(element)) {
				it.remove();
			}
		}

	}

	public static <T> List<T> rassembler(List<T> liste) {
		List<T> listeRassemble = new ArrayList<>();
		List<T> copie = new ArrayList<>(liste);

		while (!copie.isEmpty()) {
			T element = copie.get(0);
			for (T e : copie) {
				if (e.equals(element)) {
					listeRassemble.add(e);
				}
			}

			removeOccurrences(copie.listIterator(), element);

		}
		return listeRassemble;
	}

	private static <T> boolean resteContient(List<T> liste, int indice_debut, T val_trouve) {
		ListIterator<T> iterateur2 = liste.listIterator(indice_debut);
		while (iterateur2.hasNext()) {
			if (val_trouve.equals(iterateur2.next())) {
				return true;
			}
		}
		return false;
	}

	public static <T> boolean verifierRassemblement(List<T> liste) {

		ListIterator<T> iterateur1 = liste.listIterator();
		T precedent = iterateur1.next();
		while (iterateur1.hasNext()) {
			T courant = iterateur1.next();
			// changement de valeur : introduire le 2ieme iterateur
			if (!courant.equals(precedent)) {

				if (resteContient(liste, iterateur1.nextIndex(), precedent)) {
					return false;
				}

				precedent = courant;
			}
		}

		return true;
	}

}
