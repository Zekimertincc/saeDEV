import java.util.Scanner;

public class methodesJeuNaval {
//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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] plateau = new String[11][11];
        remplirPlateauVide(plateau);
        numéroterPlateau(plateau);
        saisirBateaux(plateau);

        afficherPlateau(plateau);

    }



    public static void remplirPlateauVide(String [][] plateau ) { // Cette procédure remplit un tableau 2D vide de 11*11 avec des "-"
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                plateau[i][j] = "- ";
            }
        }
    }
    public static void afficherPlateau(String[][] plateau ) { // Cette procédure affiche le tableau 2D en forme de tableau (I J)
        System.out.println("La bataille navale oppose deux joueurs. Chaque joueur dispose de deux grilles carrées de côté 10, dont les lignes sont numérotées de 1 à 10 et les colonnes de A à J, ainsi que d'une flotte composée de quelques bateaux d'une à cinq cases de long.\n" +
                "\n" +
                "L'une des grilles représente la zone contenant sa propre flotte. Au début du jeu, chaque joueur place ses bateaux sur sa grille, en s'assurant que deux bateaux ne sont pas adjacents. L'autre représente la zone adverse, où il cherchera à couler les bateaux de son adversaire.\n" +
                "\n" +
                "Chaque joueur, à son tour, annonce une case (par exemple « B6 »), et son adversaire lui répond si le tir tombe à l'eau ou au contraire s'il touche un bateau. Dans ce dernier cas, il annonce « touché » s'il reste des cases intactes au bateau ciblé, et « touché-coulé » si non6.\n" +
                "\n" +
                "Diverses variantes existent, par exemple le fait de tirer les coups par salves et de ne donner que le résultat global de la salve. ");
        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 11; j++) {
                System.out.print(plateau[i][j] + "\t" );

            }
            System.out.println();

        }
    }


    public static void numéroterPlateau(String[][] plateau) { // Cette méthode remplace la première ligne et colonne par des chiffres afin d'avoir des coordonnées,le plateau de jeu devient donc 10*10 avec des numéros

        for (int i = 0; i < 11; i++) {

            for (int j = 0; j < 11; j++) {
                plateau[0][j] = Integer.toString(j+1);
                plateau[i][0] = Integer.toString(i+1);
            }
        }
    }


    public static void saisirBateaux(String[][] plateau) { //Cette procédure demande à l'utilisateur d'entrer plusieurs données:
                                                            // -Les coordonnées X et Y d'un bateau de longueur 1
                                                            // -Les coordonnées X et Y du début du bateau de longueur 2 ainsi que les coordonnées X et Y de la fin
                                                            // - Idem pour longueur 3
        Scanner scanner = new Scanner(System.in);
        boolean bateauxMis = false;
        System.out.println("");
        int counter = 0;
        int[] bateauxLong1 = new int[2];
        int[] bateauxLong2 = new int[4];
        int[] bateauxLong3 = new int[4];

        while (!bateauxMis) {

            System.out.println("??? regles ???");
            System.out.println("??? donner cordinates pour bat1 ??? commence avec X et après Y");
            int coordones = scanner.nextInt();
            if (coordones == bateauxLong1.length) {
                for (int i = 0; i < bateauxLong1.length; i++) {
                    bateauxLong1[i] = scanner.nextInt()  ;
                    counter++;
                }
            }

            System.out.println("??? donner cordinates pour bat2 ???");
            coordones = scanner.nextInt();
            if (coordones == bateauxLong2.length) {
                for (int i = 0; i < bateauxLong1.length; i++) {
                    bateauxLong2[i] = scanner.nextInt()  ;
                    counter++;
                }
            }

            System.out.println("??? donner cordinates pour bat3 ??? User mets coordonnées X et Y du début du bateau et X et Y de la fin du bateau");
            coordones = scanner.nextInt();
            if (coordones == bateauxLong3.length) {
                for (int i = 0; i < bateauxLong1.length; i++) {
                    bateauxLong3[i] = scanner.nextInt()  ;
                    counter++;
                }
            }


            if(counter == 10 ){
                bateauxMis = true;
            }
        }
        plateau[bateauxLong1[0]][bateauxLong1[0]] = "X";

        plateau[bateauxLong2[0]][bateauxLong2[1]]="X";
        plateau[bateauxLong2[1]][bateauxLong2[2]]="X";


        for (int i = 1; i < bateauxLong3.length;i++){
            plateau[bateauxLong3[i]][bateauxLong3[i+1]]= "X";
        }





    }


    public static void mettreBateuxSurPlateaux(int[]b1, int[]b2, int[]b3,String[][] plateau) {


    }


}