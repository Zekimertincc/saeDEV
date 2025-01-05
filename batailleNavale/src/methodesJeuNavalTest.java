import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class methodesJeuNavalTest {

    

        @Test
        public void testPeutEtrePlaceTrue() {
            String[][] plateau = new String[11][11];
            methodesJeuNaval.remplirPlateauVide(plateau);

            ArrayList<Integer> bateau = new ArrayList<>();
            bateau.add(1); // y
            bateau.add(1); // x

            boolean resultat = methodesJeuNaval.peutEtrePlacé(bateau, plateau, 1);
            assertTrue(resultat, "Le bateau devrait pouvoir être placé à ces coordonnées.");
        }

        @Test
        public void testPeutEtrePlaceFalse() {
            String[][] plateau = new String[11][11];
            methodesJeuNaval.remplirPlateauVide(plateau);

            plateau[1][1] = "X"; // Une position occupée

            ArrayList<Integer> bateau = new ArrayList<>();
            bateau.add(1); // y
            bateau.add(1); // x

            boolean resultat = methodesJeuNaval.peutEtrePlacé(bateau, plateau, 1);
            assertFalse(resultat, "Le bateau ne devrait pas pouvoir être placé sur une position occupée.");
        }

        @Test
        public void testSaisirBatTaille1() {
            String input = "5\n6\n"; // Entrées utilisateur : y = 5, x = 6
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

            ArrayList<Integer> resultat = methodesJeuNaval.saisirBat(1);
            ArrayList<Integer> attendu = new ArrayList<>();
            attendu.add(5); // y
            attendu.add(6); // x

            assertEquals(attendu, resultat, "Les coordonnées (5, 6) sont attendues pour un bateau de taille 1.");
        }

        @Test
        public void testSaisirBatTaille2() {
            String input = "3\n4\n2\n"; // Entrées utilisateur : y = 3, x = 4, direction = 2 (Sud)
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

            ArrayList<Integer> resultat = methodesJeuNaval.saisirBat(2);
            ArrayList<Integer> attendu = new ArrayList<>();
            attendu.add(3); // y
            attendu.add(4); // x
            attendu.add(2); // direction

            assertEquals(attendu, resultat, "Les coordonnées (3, 4) avec direction 2 sont attendues pour un bateau de taille 2.");
        }

        @Test
        public void testAttackOrdiBateauTrouve() {
            String[][] plateauOrdi = new String[11][11];
            methodesJeuNaval.remplirPlateauVide(plateauOrdi);

            plateauOrdi[5][6] = "X"; // Placer un bateau manuellement

            String input = "6\n5\n"; // Entrées utilisateur : x = 6, y = 5
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

            methodesJeuNaval.attackOrdi(plateauOrdi);

            assertEquals("X", plateauOrdi[5][6], "Le bateau a été trouvé et détruit.");
        }

        @Test
        public void testAttackOrdiPasDeBateau() {
            String[][] plateauOrdi = new String[11][11];
            methodesJeuNaval.remplirPlateauVide(plateauOrdi);

            String input = "4\n3\n"; // Entrées utilisateur : x = 4, y = 3
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

            methodesJeuNaval.attackOrdi(plateauOrdi);

            assertEquals("- ", plateauOrdi[3][4], "Aucun bateau n'était présent à ces coordonnées.");
        }
    }


