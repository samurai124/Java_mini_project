import java.util.*;
public class VendingMachine {
    static Scanner scanner = new Scanner(System.in);
    // acheterProduit
    public static void acheterProduitv2(ArrayList<String> produits,ArrayList<Double> prix,ArrayList<Integer> stock){
        System.out.println("Entrer votre choixe :");
        int choix = scanner.nextInt();
        System.out.println("Entrer le montent :");
        double montent = scanner.nextDouble();
        double prix_produit = prix.get(choix-1);
        if(prix_produit > montent){
            System.out.println("l'argent ne suffit pas");
        } else if (prix_produit == montent) {
            if(stock.get(choix-1) > 0) {
                stock.set(choix-1,stock.get(choix-1)-1);
                System.out.println("Vous avez acheté : "+produits.get(choix-1));
            }else{
                System.out.println("Le produit est en rupture de stock");
            }
        }else{
            if(stock.get(choix-1) > 0) {
                double rest = montent - prix_produit;
                stock.set(choix-1,stock.get(choix-1)-1);
                System.out.println("Vous avez acheté : "+produits.get(choix-1));
                System.out.println("Monnaie rendue : "+rest +" MAD ");
            }else{
                System.out.println("Le produit est en rupture de stock");
            }
        }

    }
    // afficherStock
    public static void afficherStock(ArrayList<String> produits ,ArrayList<Integer> stock){
        for (int i = 0; i < produits.size(); i++) {
            System.out.printf("Produit : %s ; Stock : %d ; \n",produits.get(i),stock.get(i));
        }
    }
    // menu-display
    public static int menuprincipal() {
        Scanner scanner = new Scanner(System.in);
        int choix =0;
        System.out.println("bienvenus ");
        System.out.println("1. Afficher le produit\n2.Achater\n3.mode admine\n4.quitter\n");
        System.out.println("entrer votre choix :");
        choix=scanner.nextInt();
        return choix;
    }
    // afficherProduits
    public static void afficherProduits(List<String> produits, ArrayList<Double> prix, List<Integer> stock) {
        System.out.println("Produits disponibles :");
        for (int i=0; i< produits.size(); i++){
            System.out.println((i+1)+". "+ produits.get(i) +" ( "+prix.get(i)+ " MAD) - Stock : "+stock.get(i));
        }
    }

    // acheterProduit invalide code cause its static code
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
    //mode administrateur
    public static void administrateur(List<String> produits, ArrayList<Double> prix, List<Integer> stock) {
        int produit_chneger = 0;
        afficherProduits(produits, prix, stock);
        System.out.print("Entrer le produit du stock tu veux changer :");
        produit_chneger = scanner.nextInt();
        System.out.print("Entrer la nouvelle quantite :");
        int new_stock = scanner.nextInt();
        stock.set(produit_chneger-1,new_stock);
    }
    // Distributeur Automatique
    public static void distributeur_automatique(List<String> produits, ArrayList<Double> prix, List<Integer> stock){
        int choix = 0;
        do {
            choix = menuprincipal();
            switch (choix) {
                case 1 -> afficherProduits(produits, prix, stock);
                case 2 -> acheterProduitv2((ArrayList<String>) produits, prix, (ArrayList<Integer>) stock);
                case 3 -> administrateur(produits,prix,stock);
                case 4 -> System.out.println("!!!!!!");
                default -> System.out.println("Choix invalide");
            }
        }while (choix != 4);
    }
    public static void main(String[] args) {
        ArrayList<String> produits = new ArrayList<>(List.of("Eau", "Soda", "Chips", "Chocolat"));
        ArrayList<Double> prix = new ArrayList<>(List.of(5.0, 8.0, 12.0, 15.0));
        ArrayList<Integer> stock = new ArrayList<>(List.of(10, 5, 7, 3));
        try {
            distributeur_automatique(produits, prix, stock);
        }catch (Exception e){
            System.out.println(e);
            distributeur_automatique(produits, prix, stock);
        }
    }
}