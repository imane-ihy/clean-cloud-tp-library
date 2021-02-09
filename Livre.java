public class Livre {
	
	/*
	 * Classe livre qui sert à initialiser un livre
	 * */
	
	private final String titre;
	private final String auteur;
	private boolean empruntable;
	
	public Livre(String titre, String auteur) {
		this.titre = titre;
		this.auteur = auteur;
		this.empruntable = true;
	}
	
	public void livreEmprunte(boolean emprunt) {
		this.empruntable = emprunt;
	}

	public boolean estEmpruntable() {
		boolean emprunt = this.empruntable;
		return emprunt;
	}

	public String getTitre() {
		String titre = this.titre;
		return titre;
	}

	public String getAuteur() {
		String auteur = this.auteur;
		return auteur;
	}
}
