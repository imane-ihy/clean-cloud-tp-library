import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private static Librairie librairie = new Librairie();

	public static Utilisateur inscription() {
		try {
			Utilisateur utilisateurConnecte;
			Scanner scanner = new Scanner(System.in);
			System.out.println("Choisir le type d'utilisateur (entrez le nombre associé):\n1/ Libraire\n2/ Invité\n3/ Membre");
			int choixDuTypeDUtilisateur = scanner.nextInt();
			switch (choixDuTypeDUtilisateur) {
			case 1:
				utilisateurConnecte = new Libraire();
				System.out.println("Libraire " + utilisateurConnecte.getIdentifiant() + " est connecté");
				break;
			case 2:
				utilisateurConnecte = new Invite();
				System.out.println("Invité " + utilisateurConnecte.getIdentifiant() + " est connecté");
				break;
			case 3:
				utilisateurConnecte = new Membre();
				System.out.println("Membre " + utilisateurConnecte.getIdentifiant() + " est connecté");
				break;
			default:
				System.out.println("Vous avez entré le mauvais nombre");
				utilisateurConnecte = connexion();
				break;
			}
			return utilisateurConnecte;
		}
		catch (InputMismatchException e) {
			System.out.println("Vous n'avez pas entré un entier");
			return inscription();
		}
	}

	public static Utilisateur premiereConnexion() {
		Utilisateur utilisateurConnecte;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Premiere connexion? (répondez par \"oui\" ou par \"non\")");
		String premiereConnexionChoix = scanner.next();
		switch (premiereConnexionChoix) {
		case "oui":
			utilisateurConnecte = inscription();
			break;
		case "non":
			utilisateurConnecte = connexion();
		default:
			System.out.println("Vous n'avez pas répondu correctement à la question");
			utilisateurConnecte = premiereConnexion();
			break;
		}
		return utilisateurConnecte;
	}

	public static Utilisateur connexion() {
		Utilisateur utilisateur;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entrez votre identifiant");
		int identifiantUtilisateur = scanner.nextInt();
		utilisateur = librairie.utilisateurDansLaListe(identifiantUtilisateur);
		if(utilisateur!=null) {
			System.out.println("Vous êtes connecté");
			return utilisateur;
		}
		else {
			System.out.println("Cet utilisateur n'existe pas, vous êtes redirigé vers la première connexion");
			return premiereConnexion();
		}
	}

	public static void actionSouhaite(Utilisateur utilisateurConnecte) {
		try {
			Scanner scanner = new Scanner(System.in);
			String titre="";
			String auteur="";
			System.out.println("Que voulez-vous faire? (entrez le nombre associé)\n1/ Ajouter un livre\n2/ Voir la "
					+ "librairie\n3/ Emprunter un livre\n4/ Rendre un livre\n5/ Déconnexion");
			int actionChoix = scanner.nextInt();
			switch (actionChoix) {
			case 1:
				System.out.println("Entrez le titre:");
				titre = scanner.next();
				System.out.println("Entrez l'auteur:");
				auteur = scanner.next();
				System.out.println(utilisateurConnecte.getIdentifiant() + titre + " " + auteur);
				librairie.ajouterUnLivre(utilisateurConnecte, titre, auteur);
				break;
			case 2:
				librairie.voirLaCollection();
				break;
			case 3:
				System.out.println("Entrez le titre:");
				titre = scanner.next();
				System.out.println("Entrez l'auteur:");
				auteur = scanner.next();
				librairie.emprunterUnLivre(utilisateurConnecte, new Livre(titre, auteur));
				break;
			case 4:
				System.out.println("Entrez le titre:");
				titre = scanner.next();
				System.out.println("Entrez l'auteur:");
				auteur = scanner.next();
				librairie.rendreUnLivre(utilisateurConnecte, new Livre(titre, auteur));
				break;
			case 5:
				utilisateurConnecte  = premiereConnexion();
			} actionSouhaite(utilisateurConnecte);
		} catch (InputMismatchException e) {
			System.out.println("Vous n'avez pas entré un entier");
			actionSouhaite(utilisateurConnecte);
		}
	}

	public static void main(String[] args) {
		Utilisateur utilisateurConnecte = premiereConnexion();
		actionSouhaite(utilisateurConnecte);
	}
}
