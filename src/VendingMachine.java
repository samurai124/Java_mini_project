import java.util.*;
public class VendingMachine {
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

    Scanner scanner = new Scanner(System.in);
    public static int acheterProduit(ArrayList<Integer> stock){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro du produit : ");
        int choix = scanner.nextInt();
        int montant = 0;

        switch (choix) {
            case 1:
                do {
                    System.out.println("Entrez le montant inséré : ");
                    montant = scanner.nextInt();
                    if (montant < 5) {
                        System.out.println("Monnaie insuffisante");
                    }
                }while (montant < 5);

                if (stock.get(0) > 1) {
                    System.out.println("Vous avez acheté : Eau");
                    int rendue = montant - 5;
                    System.out.println("Monnaie rendue : " + rendue + " MAD");

                } else {
                    System.out.println("stock insuffisant");
                }
                break;
            case 2:
                do {
                    System.out.println("Entrez le montant inséré : ");
                    montant = scanner.nextInt();
                    if (montant < 8) {
                        System.out.println("Monnaie insuffisante");
                    }
                }while (montant < 8);

                if (stock.get(1) > 1) {
                    System.out.println("Vous avez acheté : Soda");
                    int rendue = montant - 8;
                    System.out.println("Monnaie rendue : "+ rendue +" MAD");

                } else { System.out.println("stock insuffisant");}

                break;
            case 3:
                do {
                    System.out.println("Entrez le montant inséré : ");
                    montant = scanner.nextInt();
                    if (montant < 12) {
                        System.out.println("Monnaie insuffisante");
                    }
                }while (montant < 12);

                if (stock.get(1) > 1) {
                    System.out.println("Vous avez acheté : Chips");
                    int rendue = montant - 12;
                    System.out.println("Monnaie rendue : "+ rendue +" MAD");

                } else { System.out.println("stock insuffisant");}
                break;
            case 4:
                do {
                    System.out.println("Entrez le montant inséré : ");
                    montant = scanner.nextInt();
                    if (montant < 15) {
                        System.out.println("Monnaie insuffisante");
                    }
                }while (montant < 15);
                if (stock.get(1) > 1) {
                    System.out.println("Vous avez acheté : Chocolat");
                    int rendue = montant - 15;
                    System.out.println("Monnaie rendue : "+ rendue +" MAD");

                } else { System.out.println("stock insuffisant");}
                break;
        }
        return choix;
    }

    // afficherStock
    public static void main(String[] args) {
        ArrayList<String> produits = new ArrayList<>(List.of("Eau", "Soda", "Chips", "Chocolat"));
        ArrayList<Double> prix = new ArrayList<>(List.of(5.0, 8.0, 12.0, 15.0));
        ArrayList<Integer> stock = new ArrayList<>(List.of(10, 5, 7, 3));
        menuprincipal();

    }
}