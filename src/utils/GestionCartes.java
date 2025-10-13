package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class GestionCartes {

	public static <T> T extraire(List<T> liste) {
//		List<T> elements = new ArrayList<>();
//		Collections.addAll(elements, liste);

		// indice de l'element a enlever
		int indiceAleatoire = (int) (Math.random() * liste.size());
//		ListIterator<T> iterateur = liste.listIterator(indiceAleatoire);
		T element = liste.get(indiceAleatoire);
		liste.remove(indiceAleatoire);
		return element;
	}

	// iterateur dans extraire -> utiliser la taille de la liste au debut;
	public static <T> List<T> melanger(List<T> liste) {
		List<T> listeMelange = new ArrayList<>();
		int taille = liste.size();

		for (int i = 0; i < taille; i++) {
			listeMelange.add(extraire(liste));
		}

		return listeMelange;

	}

	public static <T> boolean verifierMelange(List<T> list1, List<T> list2) {

		if (list1.size() != list2.size()) {
			return false;
		} else {
			for (T element1 : list1) {
				int freq1 = Collections.frequency(list1, element1);
				for (T element2 : list2) {
					if (element1.equals(element2)) {
						int freq2 = Collections.frequency(list2, element2);
						if (freq2 != freq1) {
							return false;
						}
					}
				}
			}
		}
		return true;
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
			
			   ListIterator<T> it = copie.listIterator();
		        while (it.hasNext()) {
		            if (it.next().equals(element)) {
		                it.remove();
		            }
		        }
		}
		return listeRassemble;
	}

	public static <T> boolean verifierRassemblement(List<T> liste) {

	    ListIterator<T> iterateur1 = liste.listIterator();
	    T precedent = iterateur1.next();
	    while (iterateur1.hasNext()) {
	        T courant = iterateur1.next();
	        if (!courant.equals(precedent)) {
	            ListIterator<T> iterateur2 = liste.listIterator(iterateur1.nextIndex());

	            while (iterateur2.hasNext()) {
	                T suivant = iterateur2.next();

	                if (suivant.equals(precedent)) {
	                    return false;
	                }
	            }

	            precedent = courant;
	        }
	    }

	    return true;
	}


}
