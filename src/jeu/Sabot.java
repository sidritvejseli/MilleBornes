package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Sabot implements Iterable<Carte> {
	int indiceIterateur = 0;
	int nombreOperations = 0;

	int nbCartes;
	Carte[] cartes;
	JeuDeCartes jeu;

	public Sabot(Carte[] cartes) {
		jeu = new JeuDeCartes();
		this.cartes = cartes;
		nbCartes = cartes.length;
	}

	public boolean estVide() {
		
		return nbCartes == 0;
	}

	public void ajouterCarte(Carte carte) {
		if (nbCartes == cartes.length) {
			throw new IllegalStateException("Le sabot est plein");
		}
		cartes[nbCartes - 1] = null;
		cartes[nbCartes] = carte;
		nombreOperations++;
		nbCartes++;
	}

	public Carte piocher() {
		if (estVide()) {
			throw new IllegalStateException("Le sabot est vide");
		}

		Carte cartePioche = cartes[0];
		for (int i = 0; i < nbCartes - 1; i++) {
			cartes[i] = cartes[i + 1];
		}
		nbCartes--;
		nombreOperations++;
		return cartePioche;

	}

	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nombreOperationsReference = nombreOperations;


		private void verificationConcurrence() {
			if (nombreOperations != nombreOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}

		@Override
		public boolean hasNext() {
			return indiceIterateur < cartes.length;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new NoSuchElementException();
			}
			;
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i + 1];
			}
			nextEffectue = true;
			indiceIterateur--;
			nbCartes--;
		}

	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

}
