import java.util.ArrayList;

public class Librairie {

	/*
	 * Classe librairie qui initialise une liste d'utilisateurs inscrits et de livres disponibles dans la librairie
	 * */

	private static ArrayList<Utilisateur> listeDesUtilisateurs = new ArrayList<Utilisateur>();
	private static ArrayList<Livre> listeDesLivres = new ArrayList<Livre>();

	// Retourne l'utilisateur lorsqu'il est dans la liste des inscrits
	public Utilisateur utilisateurDansLaListe(int identifiantUtilisateur) {
		for (int i = 0; i < listeDesUtilisateurs.size(); i++) {
			if (listeDesUtilisateurs.get(i).getIdentifiant() == identifiantUtilisateur) return listeDesUtilisateurs.get(i);
		}
		return null;
	}

	// Ajoute un nouvel utilisateur dans la liste des inscrits
	public void ajouterUnUtilisateur(Utilisateur utilisateurAAjouter) {
		listeDesUtilisateurs.add(utilisateurAAjouter);
		System.out.println("L'utilisateur " + utilisateurAAjouter.getIdentifiant() + " a été ajouté");
	}

	// Ajoute un livre dans la librairie (seul les libraires peuvent le faire)
	public void ajouterUnLivre(Utilisateur utilisateurConnecte, String titre, String auteur) {
		if (utilisateurConnecte instanceof Libraire) {
			listeDesLivres.add(new Livre(titre, auteur));
			System.out.println("Le livre " + titre + " a été ajouté");
		}
		else System.out.println("Vous n'avez pas la possibilité d'ajouter un livre");
	}

	// Afficher la liste des livres et s'ils sont empruntés ou non (tous les utilisateurs peuvent le faire invité compris)
	public void voirLaCollection() {
		for (int i = 0; i < listeDesLivres.size(); i++) {
			System.out.print(listeDesLivres.get(i).getTitre() + " => ");
			if(listeDesLivres.get(i).estEmpruntable()) System.out.println("empruntable");
			else System.out.println("emprunté");
		}
	}

	// Emprunter un livre disponible dans la liste (seul les membres peuvent le faire)
	public void emprunterUnLivre(Utilisateur utilisateurConnecte, String titre, String auteur) {
		Livre livreAEmprunter = livreEmprunte(titre, auteur);
		if(utilisateurConnecte instanceof Membre) {
			if (livreEmpruntable(titre, auteur)) {
				livreAEmprunter.livreEmprunte(false);
				((Membre)utilisateurConnecte).nouvelEmprunt(livreAEmprunter);
				System.out.println(livreAEmprunter.getTitre() + " est emprunté par " + utilisateurConnecte.getIdentifiant());
			}
			else System.out.println("Le livre est emprunté");
		}
		else System.out.println("Vous ne pouvez pas emprunter de livre");
	}

	// Rendre un livre (seul les membres peuvent le faire)
	public void rendreUnLivre(Utilisateur utilisateurConnecte, String titre, String auteur) {
		Livre livreARendre = livreEmprunte(titre, auteur);
		if(utilisateurConnecte instanceof Membre) {
			if (((Membre) utilisateurConnecte).livreDansLaListe(livreARendre)) {
				livreARendre.livreEmprunte(true);
				((Membre)utilisateurConnecte).rendreLivre(livreARendre);
				System.out.println("Le livre est rendu");
			}
			else System.out.println("Vous n'avez pas ce livre, vous ne pouvez pas le rendre");
		}
		else System.out.println("Vous ne pouvez pas rendre de livre");
	}

	// Vérifie si un livre est dans la liste
	public boolean livreDansLaListe(Livre livreAEmprunter) {
		return listeDesLivres.contains(livreAEmprunter);
	}

	// Vérifie si un livre est empruntable
	public boolean livreEmpruntable(String titre, String auteur) {
		for (int i = 0; i < listeDesLivres.size(); i++) {
			if(listeDesLivres.get(i).getTitre().equals(titre) && listeDesLivres.get(i).getAuteur().equals(auteur)) {
				return listeDesLivres.get(i).estEmpruntable();
			}
		}
		return false;
	}

	// Renvoie le livre emprunté
	public Livre livreEmprunte(String titre, String auteur) {
		for (int i = 0; i < listeDesLivres.size(); i++) {
			if(listeDesLivres.get(i).getTitre().equals(titre) && listeDesLivres.get(i).getAuteur().equals(auteur)) {
				return listeDesLivres.get(i);
			}
		}
		return null;
	}

}
