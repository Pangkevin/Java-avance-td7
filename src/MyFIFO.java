
public class MyFIFO <T> {
	// int taille;
	T[]tab_o;
	int ideb = 0; // indice debut
	int ifin = 0; // indice de fin

	public MyFIFO(int tailleMax) {
		if (tailleMax <= 0) {
			throw new IllegalArgumentException();
		}
		tab_o = (T[]) new Object[tailleMax];
		// taille = tailleMax;

	}

	public void offer(T o) {
		if (!(o == null)) { // .equals interdit sur le null

			// Pour savoir si il reste de la place
			if (tab_o[ifin] == null) {
				// On ajoute dans la file
				tab_o[ifin] = o;

				// on incrémente
				ifin = (ifin + 1) % tab_o.length;
			} else {
				// Si la file est pleine, on attend qu'une place se libère
				// Ou on annule l'opération = Exception ? On interdit ? On previent ?
				throw new IllegalStateException("Pile pleine");
			}

		} else {
			throw new NullPointerException();
		}
	}

	public T poll() {
		if (this.isEmpty()) {
			throw new IllegalStateException();
		}

		T objTemp = tab_o[ideb];
		tab_o[ideb] = null;
		ideb++;
		// ideb= (ideb+1)%tab_o.length;
		if (ideb == tab_o.length)
			ideb = 0;

		return objTemp;
	}

	public boolean isEmpty() {
		if (ideb == ifin && tab_o[ideb] == null)
			return true;
		return false;
	}

	public int size() {
		
		if ((ifin - ideb) == 0 && tab_o[ifin] == null) {
			return 0;
		} else if ((ifin - ideb) == 0 && tab_o[ifin] != null) {
			return tab_o.length;
		} else if (ifin < ideb) {
			return (ideb - ifin);
		} else {
			return ifin - ideb;
		}
	}

	@Override
	public String toString() {
		
		String res = "";
		for(int i= tab_o.length -1; i >= 0; i--) {
			
			if(tab_o[i] != null) {
				if(i == 0) {
			res = tab_o[i]+res;
				}
				else {
					res = ", "+tab_o[i]+res;
				}
			}
		}
		
		return "["+res+"]";
	}

}
