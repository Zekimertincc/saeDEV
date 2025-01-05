public class gameLoop {

    public static void main(String[] args){
        boolean gameOver = false;
        String[][] plateau = new String[11][11];
        String[][]plateauOrdi = new String[11][11];

        int counter  = 0;
        int counter2  = 0;
        methodesJeuNaval.setupJeux(plateau, plateauOrdi);

        methodesJeuNaval.afficherPlateau(plateauOrdi);
        do {

            methodesJeuNaval.attackPlayer(plateau);
            if (tousLesBatCoules(plateauOrdi)) {
                System.out.println("Vous avez gagne!");
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
