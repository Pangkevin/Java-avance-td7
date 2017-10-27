
public class MyEnlargedFIFO<T> {
	
	T[]tab_o;
	int ideb = 0; // indice debut
	int ifin = 0; // indice de fin
	
	public MyEnlargedFIFO (int tailleMax) {
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
				// on aggrandit le tableau 
				
				
			//	T tab_newTab
			//stop ici
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
	
	public static void main(String[] args) {
		
		MyEnlargedFIFO<String> f = new MyEnlargedFIFO<>(3);
		f.offer("a");
		f.offer("b");
		f.poll();
		f.offer("c");
		f.poll();
		f.offer("d");
		f.offer("e");
		f.offer("f");
		System.out.println(f);
		
	}

}
