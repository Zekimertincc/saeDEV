public class gameLoop {

    public static void main(String[] args){
        boolean gameOver = false;
        String[][] plateau = new String[11][11];
        String[][]plateauOrdi = new String[11][11];

        int counter  = 0;
        int counter2  = 0;
        int choix=0;

        choix=methodesJeuNaval.setupMenus();
        methodesJeuNaval.setupJeux(plateau, plateauOrdi);
        System.out.println("\n");
        System.out.println("La bataille navale oppose deux joueurs. Chaque joueur dispose de deux grilles carrées de côté 10, dont les lignes sont numérotées de 1 à 10 et les colonnes de A à J, ainsi que d'une flotte composée de quelques bateaux d'une à cinq cases de long.\n" +
                "\n" +
                "L'une des grilles représente la zone contenant sa propre flotte. Au début du jeu, chaque joueur place ses bateaux sur sa grille, en s'assurant que deux bateaux ne sont pas adjacents. L'autre représente la zone adverse, où il cherchera à couler les bateaux de son adversaire.\n" +
                "\n" +
                "Chaque joueur, à son tour, annonce une case (par exemple « B6 »), et son adversaire lui répond si le tir tombe à l'eau ou au contraire s'il touche un bateau. Dans ce dernier cas, il annonce « touché » s'il reste des cases intactes au bateau ciblé, et « touché-coulé » si non6.\n" +
                "\n" +
                "Diverses variantes existent, par exemple le fait de tirer les coups par salves et de ne donner que le résultat global de la salve. ");
        methodesJeuNaval.afficherPlateau(plateau);

        methodesJeuNaval.afficherPlateau(plateauOrdi);

        do {

            if(choix==1){
                methodesJeuNaval.attackPlayer(plateau);
                System.out.println("Difficulté:"+ choix);
            }
            else{
                methodesJeuNaval.attackPlayer2(plateau);
                System.out.println("Difficulté:"+ choix);
            }


            if (tousLesBatCoules(plateauOrdi)) {
                System.out.println("Vous avez gagné!");
                gameOver = true;
                break;
            }
            methodesJeuNaval.attackOrdi(plateauOrdi);
            if (tousLesBatCoules(plateau)) {
                System.out.println("Vous avez perdu!");
                gameOver = true;
                break;
            }
            methodesJeuNaval.afficherPlateau(plateauOrdi);
        }while (!gameOver);
    }

    private static boolean tousLesBatCoules(String[][] plateau) {
        for (int i = 1; i < plateau.length; i++) {
            for (int j = 1; j < plateau[i].length; j++) {
                if (plateau[i][j].equals("X")) {
                    return false;
                }
            }
        }
        return true;
    }

}