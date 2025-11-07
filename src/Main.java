import java.util.*;
import java.util.Scanner;

public class Main {
    // Distributeur Automatique
    // menu-display
    public static int menuprincipal() {
        Scanner scanner = new Scanner(System.in);
        int choix =0;
        System.out.println("bienvenus ");
        System.out.println("1. Afficher le produit\n 2.Achater\n 3.quitter\n");
        System.out.println("entrer votre choix :  ");
        choix=scanner.nextInt();
        return choix;
    }

    // afficherProduits
    // acheterProduit
    // afficherStock
    public static void main(String[] args) {
        ArrayList<String> produits = new ArrayList<>(List.of("Eau", "Soda", "Chips", "Chocolat"));
        ArrayList<Double> prix = new ArrayList<>(List.of(5.0, 8.0, 12.0, 15.0));
        ArrayList<Integer> stock = new ArrayList<>(List.of(10, 5, 7, 3));
        System.out.println(menuprincipal());

    }

}



