package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class GestionCartes {

	public static <T> T extraire(List<T> liste){
//		List<T> elements = new ArrayList<>();
//		Collections.addAll(elements, liste);
		
		// indice de l'element a enlever
		int indiceAleatoire = (int)(Math.random()*liste.size());
		ListIterator<T> iterateur = liste.listIterator(indiceAleatoire);
		T element = liste.get(indiceAleatoire);
		iterateur.remove();
		return element;
	}
	//iterateur dans extraire -> utiliser la taille de la liste au debut;
	public static <T> List<T> melanger(List<T> liste){
		List<T> listeMelange = new ArrayList<>();
		int taille = liste.size();
		
		for(int i =0; i<taille; i++) {
			listeMelange.add(extraire(liste));
		}
		
		return listeMelange;
		
	}
}
