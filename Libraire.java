public class Libraire extends Utilisateur {

	public Libraire(String nom, String prenom) {
		super(nom, prenom);
	}
	
	public void ajouterUnLivreALaLibrairie(String titre, String auteur) {
		Livre nouveauLivre = new Livre(titre, auteur);
		livresDeLaLibrairie.add(nouveauLivre);
	}

}
