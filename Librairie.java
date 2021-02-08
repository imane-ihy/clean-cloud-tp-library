import java.util.ArrayList;

public class Librairie {

	private static ArrayList<Utilisateur> listeDesUtilisateurs = new ArrayList<Utilisateur>();
	private static ArrayList<Livre> listeDesLivres = new ArrayList<Livre>();

	public Utilisateur utilisateurDansLaListe(int identifiantUtilisateur) {
		for (int i = 0; i < listeDesUtilisateurs.size(); i++) {
			if (listeDesUtilisateurs.get(i).getIdentifiant() == identifiantUtilisateur) return listeDesUtilisateurs.get(i);
		}
		return null;
	}

	public void ajouterUnUtilisateur(Utilisateur utilisateurAAjouter) {
		listeDesUtilisateurs.add(utilisateurAAjouter);
		System.out.println("L'utilisateur " + utilisateurAAjouter.getIdentifiant() + " a été ajouté");
	}

	public void ajouterUnLivre(Utilisateur utilisateurConnecte, String titre, String auteur) {
		if (utilisateurConnecte instanceof Libraire) {
			listeDesLivres.add(new Livre(titre, auteur));
			System.out.println("Le livre " + titre + " a été ajouté");
		}
		else System.out.println("Vous n'avez pas la possibilité d'ajouter un livre");
	}

	public void voirLaCollection() {
		for (int i = 0; i < listeDesLivres.size(); i++) {
			System.out.print(listeDesLivres.get(i).getTitre() + " => ");
			if(listeDesLivres.get(i).estEmpruntable()) System.out.println("empruntable");
			else System.out.println("emprunté");
		}
	}

	public void emprunterUnLivre(Utilisateur utilisateurConnecte, Livre livreAEmprunter) {
		if(utilisateurConnecte instanceof Membre && livreDansLaListe(livreAEmprunter)) {
			if (livreEmpruntable(livreAEmprunter)) {
				livreAEmprunter.livreEmprunte(true);
				((Membre)utilisateurConnecte).nouvelEmprunt(livreAEmprunter);
				System.out.println(livreAEmprunter.getTitre() + " est emprunté par " + utilisateurConnecte.getIdentifiant());
			}
			else System.out.println("Le livre est emprunté");
		}
		else System.out.println("Vous ne pouvez pas emprunter de livre");
	}

	public void rendreUnLivre(Utilisateur utilisateurConnecte, Livre livreARendre) {
		if(utilisateurConnecte instanceof Membre) {
			((Membre)utilisateurConnecte).rendreLivre(livreARendre);
		}
		System.out.println("Vous ne pouvez pas rendre de livre");
	}

	public boolean livreDansLaListe(Livre livreAEmprunter) {
		return listeDesLivres.contains(livreAEmprunter);
	}

	public boolean livreEmpruntable(Livre livreAEmprunter) {
		for (int i = 0; i < listeDesLivres.size(); i++) {
			if(listeDesLivres.get(i).equals(livreAEmprunter)) {
				return listeDesLivres.get(i).estEmpruntable();
			}
		}
		return false;
	}

}
