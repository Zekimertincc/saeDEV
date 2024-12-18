import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;



public class methodesJeuNaval {
//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

//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 TOKEN DENIS
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] plateau = new String[11][11];
        remplirPlateauVide(plateau);
        numéroterPlateau(plateau);

        ArrayList<Integer> bateau1=saisirBat(1);
        ArrayList<Integer> bateau2=saisirBat(2);
        ArrayList<Integer> bateau3=saisirBat(3);

        //afficherPlateau(plateau);


    }


    public static void remplirPlateauVide(String[][] plateau) { // Cette procédure remplit un tableau 2D vide de 11*11 avec des "-"
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                plateau[i][j] = "- ";
            }
        }
    }

    public static void afficherPlateau(String[][] plateau) { // Cette procédure affiche le tableau 2D en forme de tableau (I J)
        System.out.println("La bataille navale oppose deux joueurs. Chaque joueur dispose de deux grilles carrées de côté 10, dont les lignes sont numérotées de 1 à 10 et les colonnes de A à J, ainsi que d'une flotte composée de quelques bateaux d'une à cinq cases de long.\n" +
                "\n" +
                "L'une des grilles représente la zone contenant sa propre flotte. Au début du jeu, chaque joueur place ses bateaux sur sa grille, en s'assurant que deux bateaux ne sont pas adjacents. L'autre représente la zone adverse, où il cherchera à couler les bateaux de son adversaire.\n" +
                "\n" +
                "Chaque joueur, à son tour, annonce une case (par exemple « B6 »), et son adversaire lui répond si le tir tombe à l'eau ou au contraire s'il touche un bateau. Dans ce dernier cas, il annonce « touché » s'il reste des cases intactes au bateau ciblé, et « touché-coulé » si non6.\n" +
                "\n" +
                "Diverses variantes existent, par exemple le fait de tirer les coups par salves et de ne donner que le résultat global de la salve. ");
        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 11; j++) {
                System.out.print(plateau[i][j] + "\t");

            }
            System.out.println();

        }
    }


    public static void numéroterPlateau(String[][] plateau) { // Cette méthode remplace la première ligne et colonne par des chiffres afin d'avoir des coordonnées,le plateau de jeu devient donc 10*10 avec des numéros

        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 11; j++) {
                plateau[0][j] = Integer.toString(j + 1);
                plateau[i][0] = Integer.toString(i + 1);
            }
        }
    }

/*
    public static void saisieLongueurBateaux() { //Cette procédure demande à l'utilisateur d'entrer plusieurs données:
        // -Les coordonnées X et Y d'un bateau de longueur 1
        // -Les coordonnées X et Y du début du bateau de longueur 2 ainsi que les coordonnées X et Y de la fin
        // - Idem pour longueur 3
        Scanner scanner = new Scanner(System.in);
        int taillebat ;
        int nbBat ;








            System.out.println("quelle taille de bateaux");
            taillebat = scanner.nextInt();
            ArrayList<Integer> bat1 = new ArrayList<Integer>();
            bat1=  saisirBat(taillebat);
            for (int i = 0; i < bat1.size() ; i++) {
                int current = bat1.get(i);
                System.out.println(current);
            }


            System.out.println("quelle taille de bateaux");
            taillebat = scanner.nextInt();
            ArrayList<Integer> bat2 = new ArrayList<Integer>();
            bat2=  saisirBat(taillebat);
            for (int i = 0; i < bat2.size() ; i++) {
                int current = bat2.get(i);
                System.out.println(current);
            }



            System.out.println("quelle taille de bateaux");
            taillebat = scanner.nextInt();
            ArrayList<Integer> bat3 = new ArrayList<Integer>();
            bat3=  saisirBat(taillebat);
            for (int i = 0; i < bat3.size() ; i++) {
                int current = bat3.get(i);
                System.out.println(current);
            }






    }
*/
    public static boolean peutEtrePlacé(int[] tab){
        boolean toutVerifié=false;
        boolean toutOk=false;
        int i=0;





        while(toutVerifié && i<9){
            if(bateau1)
        }
    }


    public static ArrayList<Integer>  saisirBat(int longueur) {
        int saisie;
        boolean saisieCorrecte = false;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> tab = new ArrayList<Integer>();
            if (longueur>1){

                do{
                    System.out.println("donner x et y apres");
                    for (int i = 0; i < 2 ; i++) {
                        saisie = scanner.nextInt();
                        tab.add(saisie);
                        if ( saisie<= 10 && saisie>= 1 ){
                            counter++;
                        }
                    }
                    System.out.println("saisir la direction de la façon suivante : 1 pour nord 2 pour sud 3 pour est et 4 pour ouest");
                    saisie = scanner.nextInt();
                    tab.add(saisie);
                    if (saisie<= 4 && saisie>= 1 ){
                        counter++;
                    }
                    if (counter == 3){
                        saisieCorrecte = true;
                    }

                }while (!saisieCorrecte);



            }
            else{

                do{
                    System.out.println("donner x et y apres");
                    for (int i = 0; i < 2 ; i++) {
                        saisie = scanner.nextInt();
                        tab.add(saisie);
                        if ( saisie<= 10 && saisie>= 1 ){
                            counter++;
                        }
                    }

                    if (counter == 2){
                        saisieCorrecte = true;
                    }

                }while (!saisieCorrecte);


            }

        return tab;


        }



        public static void ajouterSurPlateau(String[][] plateaux , ArrayList<Integer> tab){

            ArrayList<Integer> bateau1 = new ArrayList<>();
            bateau1=saisirBat(1);
            










        }











































    }







    //public static void mettreBateuxSurPlateaux(int[]b1, int[]b2, int[]b3,String[][] plateau) {


