import java.util.*;
public class VendingMachine {
    static Scanner scanner = new Scanner(System.in);
    // Distributeur Automatique
    // menu-display
    // afficherProduits
    // acheterProduit
    public static void acheterProduit(ArrayList<String> produits,ArrayList<Double> prix,ArrayList<Integer> stock){
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
    // admin_functions
    public static void admin_menu(ArrayList<String> produits,ArrayList<Double> prix,ArrayList<Integer> stock){
        Scanner input = new Scanner(System.in);
        int admin_choice = 0;
        System.out.print("1 : Ajouter de nouveaux produits \n2 : supprimer un produit \n 3 : modifier le prix d'un produit \n 4 : modifier la quantité d'un produit \n5 : quitter l'Admin menu !!!");
        admin_choice = input.nextInt();
    }

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
    public static void afficherProduits(List<String> produits, ArrayList<Double> prix, List<Integer> stock) {
        System.out.println("Produits disponibles :");
        for (int i=0; i< produits.size(); i++){
            System.out.println((i+1)+". "+ produits.get(i) +" ( "+prix.get(i)+ " MAD) - Stock : "+stock.get(i));
        }
    }

    // acheterProduit
    // afficherStock
    public static void main(String[] args) {
        ArrayList<String> produits = new ArrayList<>(List.of("Eau", "Soda", "Chips", "Chocolat"));
        ArrayList<Double> prix = new ArrayList<>(List.of(5.0, 8.0, 12.0, 15.0));
        ArrayList<Integer> stock = new ArrayList<>(List.of(10, 5, 7, 3));
        afficherStock(produits,stock);
        afficherProduits(produits,prix,stock);
        menuprincipal();
    }
}