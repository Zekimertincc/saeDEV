import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;



public class methodesJeuNaval {
//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

//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 TOKEN DENIS
    public static void main(String[] args) {

        String[][] plateau = new String[11][11];
        String[][]plateauOrdi = new String[11][11];

        remplirPlateauVide(plateauOrdi);
        numéroterPlateau(plateauOrdi);
        afficherPlateau(plateauOrdi);
        saisirBateauxPlateauOrdi(plateauOrdi);
        afficherPlateau(plateauOrdi);
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

        for (int j = 1; j < plateau[0].length; j++) {
            plateau[0][j] = Integer.toString(j);
        }

        // İlk sütunu harflerle (A, B, C, ...)
        for (int i = 1; i < plateau.length; i++) {
            plateau[i][0] = Character.toString((char) ('A' + i - 1));
        }

    }

    public static boolean peutEtrePlacé(ArrayList<Integer> tab, String[][] plateau, int l ) {
        boolean dispo = true;
        int x = tab.get(0);
        int y = tab.get(1);
        if (l == 1){
            if (plateau[x][y].equals("- ")) {
                return dispo;
            }
            else{
                dispo = false;
            }
        }else{
            int dir = tab.get(2);
            if (plateau[x][y].equals("- ")) {
                if ((dir == 1 && plateau[x][y+2].equals("- ")) || (dir == 2 && plateau[x][y-2].equals("- ")) || (dir == 3 && plateau[x+2][y].equals("- ")) || (dir == 4 && plateau[x-2][y].equals("- "))) {
                    System.out.println("tout est bien place pour cette bateaux");

                    return dispo;
                }
                else {
                    dispo = false;
                    System.out.println("la direction de bateaux cause problemes");
                }
            }
            else {
                dispo = false;
                System.out.println("la x ou y  de bateaux cause problemes");
            }
        }



        return dispo;


    }


    public static ArrayList<Integer>  saisirBat(int longueur) {
        int saisie;
        boolean saisieCorrecte = false;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> tab = new ArrayList<Integer>();
        System.out.println("votre bateaux a  du taille du " + longueur );
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

        public static void ajouterSurPlateau(String[][] plateau) {

        int[] directionsX = {-1, 1, 0, 0};
        int[] directionsY = {0, 0, 1, -1};

        for (int i = 1; i <= 3; i++) {
            ArrayList<Integer> bateau = saisirBat(i);
            boolean peutPlacer = peutEtrePlacé(bateau, plateau, i);

            if (peutPlacer) {
                int x = bateau.get(0);
                int y = bateau.get(1);

                plateau[x][y] = "X";

                if (i > 1) {
                    int dir = bateau.get(2);
                    for (int j = 1; j < i; j++) {
                        int newX = x + (j * directionsX[dir - 1]);
                        int newY = y + (j * directionsY[dir - 1]);
                        if (newX >= 0 && newX < plateau.length && newY >= 0 && newY < plateau[0].length) {
                            plateau[newX][newY] = "X";
                        }
                    }



                }
            } else {
                System.out.println("mal saise le bateaux." + i);
            }
        }
    }


    public static void setupJeux(String[][] plateau,String[][]plateauOrdi){
        remplirPlateauVide(plateau);
        remplirPlateauVide(plateauOrdi);
        numéroterPlateau(plateau);
        numéroterPlateau(plateauOrdi);

        afficherPlateau(plateau);
        ajouterSurPlateau(plateau);
        afficherPlateau(plateau);

    }



    public static void saisirBateauxPlateauOrdi(String[][] plateauOrdi) {
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int[] directionsX = {-1, 1, 0, 0};
        int[] directionsY = {0, 0, 1, -1};
        String[][] plateau = plateauOrdi;

        for (int i = 1; i < 4; i++) {
            int longBateaux = (int)(Math.random()*3)+1;
            int randX = (int) (Math.random() * range) + min;
            int randY = (int) (Math.random() * range) + min;
            plateau[randX][randY] = "X";
            if (longBateaux > 1){
                int randDir = (int)(Math.random()*4) +1;
                for (int j = 1; j < longBateaux; j++) {
                    int newX = randX + (j * directionsX[randDir - 1]);
                    int newY =  randY+ (j * directionsY[randDir - 1]);
                    if (newX >= 0 && newX < plateau.length && newY >= 0 && newY < plateau[0].length) {
                        plateau[newX][newY] = "X";
                    }
                }
            }

        }





    }



































    }







    //public static void mettreBateuxSurPlateaux(int[]b1, int[]b2, int[]b3,String[][] plateau) {


