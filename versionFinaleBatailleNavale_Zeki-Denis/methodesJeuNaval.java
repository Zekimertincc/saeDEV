import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;



public class methodesJeuNaval {
//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 <-- (dont get it mixed this time) token zeki



    //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 TOKEN DENIS
    public static void main(String[] args) {


        String[][] plateau = new String[11][11];
        String[][]plateauOrdi = new String[11][11];

        methodesJeuNaval.remplirPlateauVide(plateau);
        methodesJeuNaval.numéroterPlateau(plateau);


        //setupJeux(plateau, plateauOrdi);

        ArrayList<Integer> tabtestFaux = new ArrayList<>();
        tabtestFaux.add(1);
        tabtestFaux.add(10);
        tabtestFaux.add(3);
        System.out.println(peutEtrePlacé(tabtestFaux,plateau,3));

        ArrayList<Integer> tabtestVrai = new ArrayList<>();
        tabtestVrai.add(5);
        tabtestVrai.add(5);
        tabtestVrai.add(1);
        System.out.println(peutEtrePlacé(tabtestVrai,plateau,1));

        //attackPlayer(plateau);
        //afficherPlateau(plateau);
        //ajouterSurPlateau(plateau);

    }


    public static void remplirPlateauVide(String[][] plateau) { // Cette procédure remplit un tableau 2D vide de 11*11 avec des "-"
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                plateau[i][j] = "- ";
            }
        }
    }
    public static void afficherPlateau(String[][] plateau) { // Cette procédure affiche le tableau 2D en forme de tableau (I J)

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
    public static void ajouterSurPlateau(String[][] plateau) {

        int[] directionsX = {-1, 1, 0, 0};
        int[] directionsY = {0, 0, 1, -1};

        for (int i = 1; i <= 6; i++) {
            while(true) {
                ArrayList<Integer> bateau = saisirBat(i);
                boolean peutPlacer = peutEtrePlacé(bateau, plateau, i);

                if (peutPlacer) {
                    int x = bateau.get(0);
                    int y = bateau.get(1);

                    plateau[x][y] = "X";

                    if (i > 1 && peutPlacer) {
                        int dir = bateau.get(2);
                        for (int j = 1; j < i; j++) {
                            int newX = x + (j * directionsX[dir - 1]);
                            int newY = y + (j * directionsY[dir - 1]);
                            if (newX >= 0 && newX < plateau.length && newY >= 0 && newY < plateau[0].length) {
                                plateau[newX][newY] = "X";
                            }
                        }


                    }
                    break;
                } else {
                    System.out.println("T'as mal saisi le bateau" + i);
                }
            }
        }
    }
    public static ArrayList<Integer>  saisirBat(int longueur) {
        int saisie;
        boolean saisieCorrecte = false;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> tab = new ArrayList<Integer>();
        System.out.println("Le batteau à mettre est de taille : " + longueur );
        if (longueur>1){

            do {
                counter=0;
                tab.clear();
                System.out.println("donner y et après x");
                for (int i = 0; i < 2; i++) {
                    saisie = scanner.nextInt();
                    tab.add(saisie);
                    if (saisie <= 10 && saisie >= 1) {
                        counter++;
                    }
                }

                System.out.println("saisir la direction de la façon suivante : 1 pour nord 2 pour sud 3 pour est et 4 pour ouest");
                saisie = scanner.nextInt();
                tab.add(saisie);
                if (saisie <= 4 && saisie >= 1) {
                    counter++;
                }
                if (counter == 3) {
                    saisieCorrecte = true;
                }


            }while (!saisieCorrecte);



        }
        else{

            do{
                System.out.println("donner y et après x");
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
    public static boolean peutEtrePlacé(ArrayList<Integer> tab, String[][] plateau, int l ) {
        boolean peutplacer = true;
        int x = tab.get(0);
        int y = tab.get(1);
        int dir = (l > 1) ? tab.get(2) : 0;

        for (int i = 0; i< l;i++){

            int nvX = x;
            int nvY = y;
            if (dir == 1) {
                nvX -= i;
            } else if (dir == 2) {
                nvX += i;
            } else if (dir == 3) {
                nvY += i;
            } else if (dir == 4) {

                nvY -= i;
            }
            // controle de bordures ( il regarde si c'est bien sur le plateaux)
            if (nvX < 0 || nvX >= plateau.length || nvY < 0 || nvY >= plateau[0].length) {
                return false;
            }

            // regarde si il y a des bateaux qui se croisent (overlap )
            if (!plateau[nvX][nvY].equals("- ")) {
                return false;
            }




        }
        return peutplacer;






    }
    public static void setupJeux(String[][] plateau,String[][]plateauOrdi){


        remplirPlateauVide(plateau);
        remplirPlateauVide(plateauOrdi);
        numéroterPlateau(plateau);
        numéroterPlateau(plateauOrdi);
        saisirBateauxPlateauOrdi(plateauOrdi);
        ajouterSurPlateau(plateau);




    }
    public static void saisirBateauxPlateauOrdi(String[][] plateauOrdi) {
        int max = 10;
        int min = 1;
        int range = (max - min) + 1;
        int[] directionsX = {-1, 1, 0, 0};
        int[] directionsY = {0, 0, 1, -1};

        for (int i = 1; i <= 6; i++) {
            boolean placed = false;

            while (!placed) {
                int randX = (int) (Math.random() * range) + min;
                int randY = (int) (Math.random() * range) + min;
                int randDir = (i > 1) ? (int) (Math.random() * 4) + 1 : 0; // ici le direction en random


                ArrayList<Integer> bateau = new ArrayList<>();
                bateau.add(randX);
                bateau.add(randY);
                if (i > 1) {
                    bateau.add(randDir);
                }

                // regarder si le bateaux peut etre place
                if (peutEtrePlacé(bateau, plateauOrdi, i)) {
                    // placer le bateaux
                    plateauOrdi[randX][randY] = "X";

                    for (int j = 1; j < i; j++) {
                        int newX = randX + (j * directionsX[randDir - 1]);
                        int newY = randY + (j * directionsY[randDir - 1]);
                        if (newX > 0 && newX < plateauOrdi.length && newY > 0 && newY < plateauOrdi[0].length) {
                            plateauOrdi[newX][newY] = "X";
                        }
                    }

                    placed = true;
                }
            }
        }
    }


    public static void attaquerOrdi(String[][] plateauOrdi) {
        Scanner scanner = new Scanner(System.in);
        int saisieX, saisieY;

        while (true) {
            System.out.println("Entrez les coordonnées pour attaquer (Y puis X) : ");
            saisieX = scanner.nextInt();
            saisieY = scanner.nextInt();

            if (saisieX >= 1 && saisieX <= 10 && saisieY >= 1 && saisieY <= 10) {
                if (plateauOrdi[saisieX][saisieY].equals("X")) {
                    System.out.println("Vous avez touché un navire !");
                    plateauOrdi[saisieX][saisieY] = "F";
                    break;
                } else if (plateauOrdi[saisieX][saisieY].equals("- ")) {
                    System.out.println("Vous avez manqué !");
                    plateauOrdi[saisieX][saisieY] = "M";
                    break;
                } else {
                    System.out.println("Cette case a déjà été attaquée. Essayez un autre endroit.");
                }
            } else {
                System.out.println("Coordonnées invalides ! Veuillez réessayer.");
            }
        }
    }

    public static void IAFacile(String[][] plateau) {
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int randX, randY;

        do {
            randX = (int) (Math.random() * range) + min;
            randY = (int) (Math.random() * range) + min;
        } while (!plateau[randX][randY].equals("X") && !plateau[randX][randY].equals("- "));

        if (plateau[randX][randY].equals("X")) {
            plateau[randX][randY] = "F";
            System.out.println("L'ordinateur a touché un de vos navires ! (" + randX + ", " + randY + ")");
        } else {
            plateau[randX][randY] = "M";
            System.out.println("L'ordinateur a manqué sa cible ! (" + randX + ", " + randY + ")");
        }
    }

    public static void IADure(String[][] plateau, boolean[][] dejaAttacked, int[] lastHit) {
        int max = 10;
        int[] directionsX = {-1, 1, 0, 0};
        int[] directionsY = {0, 0, 1, -1};
        if (lastHit == null) {
            int x, y;
            do {
                x = (int) (Math.random() * (max + 1));
                y = (int) (Math.random() * (max + 1));
            } while (dejaAttacked[y][x]);
            attaquerCase(plateau, x, y);
            dejaAttacked[y][x] = true;

            if (plateau[y][x].equals("F")) {
                lastHit[0] = x;
                lastHit[1] = y;
            }
        } else {

            boolean hitFound = false;

            for (int i = 0; i < directionsX.length; i++) {
                int newX = lastHit[0] + directionsX[i];
                int newY = lastHit[1] + directionsY[i];


                if (newX >= 0 && newX <= max && newY >= 0 && newY <= max) {
                    if (!dejaAttacked[newY][newX]) {
                        attaquerCase(plateau, newX, newY);
                        dejaAttacked[newY][newX] = true;


                        if (plateau[newY][newX].equals("F")) {
                            lastHit[0] = newX;
                            lastHit[1] = newY;
                            hitFound = true;
                            break;
                        }
                    }
                }
            }


            if (!hitFound) {
                int x, y;
                do {
                    x = (int) (Math.random() * (max + 1));
                    y = (int) (Math.random() * (max + 1));
                } while (x >= dejaAttacked.length || y >= dejaAttacked[0].length || dejaAttacked[y][x]);
                attaquerCase(plateau, x, y);
                dejaAttacked[y][x] = true;


                if (plateau[y][x].equals("F")) {
                    lastHit[0] = x;
                    lastHit[1] = y;
                }
            }
        }
    }

    public static void attaquerCase(String[][] plateau, int x, int y) {

        if (plateau[y][x].equals("X")) {
            plateau[y][x] = "F";
            System.out.println("Touché! (" + x + ", " + y + ")");
        } else if (plateau[y][x].equals("- ")) {
            plateau[y][x] = "M";
            System.out.println("Raté! (" + x + ", " + y + ")");
        }
    }
    public static void menuPrincipal(){

        System.out.println("┌────────────────────────────────────────────────┐                                 \n" +
                "│                                                │                                 \n" +
                "│   BIENVENUE SUR LE JEU DE LA BATAILLE NAVALE   │                                 \n" +
                "│      ┌──────────────────────────────────┐      │                                 \n" +
                "│      │APPUYEZ SUR ENTREE POUR COMMENCER!│      │                                 \n" +
                "│      └──────────────────────────────────┘      │                                 \n" +
                "│                                                │                                 \n" +
                "│                                                │                                 \n" +
                "│                                                │                                 \n" +
                "│                                                │                                 \n" +
                "│                                                │                                \n" +
                "│                                                │                                 \n" +
                "└────────────────────────────────────────────────┘                                 ");


    }
    public static void menuDifficultee(){
        System.out.println("┌────────────────────────────────────────────────┐                                 \n" +
                "│                                                │                                 \n" +
                "│            CHOIX DE LA DIFFICULTE              │                                 \n" +
                "│      ┌──────────────────────────────────┐      │                                 \n" +
                "│      │APPUYEZ SUR :                     │      │                                 \n" +
                "│      │                                  │      │                                 \n" +
                "│      │  1.POUR LA DIFFICULTE FACILE     │      │                                 \n" +
                "│      │  2.POUR LA DIFFICULTE DURE       │      │                                 \n" +
                "│      │                                  │      │                                 \n" +
                "│      │                                  │      │                                 \n" +
                "│      └──────────────────────────────────┘      │                                \n" +
                "│                                                │                                 \n" +
                "└────────────────────────────────────────────────┘                                 ");
    }
    public static int setupMenus(){
        Scanner sc = new Scanner(System.in);
        int choixUser=-1;
        while (true) {
            menuPrincipal();
            String aAppuyé = sc.nextLine();
            if (aAppuyé.isEmpty()) {
                break;
            }
        }
        while (true) {
            menuDifficultee();
            if (sc.hasNextInt()) {
                choixUser = sc.nextInt();
                sc.nextLine();
                if (choixUser >= 1 || choixUser <= 2) {
                    break;
                }
            } else {
                sc.nextLine();
                System.out.println("Entrée invalide. Veuillez entrer un nombre entre 1 et 2.");
            }
        }

        return choixUser;
    }

}














































