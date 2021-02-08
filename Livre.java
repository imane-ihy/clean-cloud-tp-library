public class Livre {
	
	private final String titre;
	private final String auteur;
	private boolean emprunte;
	
	public Livre(String titre, String auteur) {
		this.titre = titre;
		this.auteur = auteur;
		this.emprunte = false;
	}
	
	public void livreEmprunte(boolean emprunt) {
		this.emprunte = emprunt;
	}

	public boolean estEmpruntable() {
		boolean emprunt = this.emprunte;
		return emprunt;
	}

	public String getTitre() {
		String titre = this.titre;
		return titre;
	}

}
