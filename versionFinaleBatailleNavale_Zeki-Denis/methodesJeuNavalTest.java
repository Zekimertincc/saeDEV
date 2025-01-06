import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class methodesJeuNavalTest {

    

        @Test
        public void testPeutEtrePlaceTrue() {
            String[][] plateau = new String[11][11];
            methodesJeuNaval.remplirPlateauVide(plateau);

            ArrayList<Integer> bateau = new ArrayList<>();
            bateau.add(1); 
            bateau.add(1); 

            boolean resultat = methodesJeuNaval.peutEtrePlacé(bateau, plateau, 1);
            assertTrue(resultat, "Le bateau devrait pouvoir être placé à ces coordonnées.");
        }

        @Test
        public void testPeutEtrePlaceFalse() {
            String[][] plateau = new String[11][11];
            methodesJeuNaval.remplirPlateauVide(plateau);

            plateau[1][1] = "X"; 

            ArrayList<Integer> bateau = new ArrayList<>();
            bateau.add(1); 
            bateau.add(1); 

            boolean resultat = methodesJeuNaval.peutEtrePlacé(bateau, plateau, 1);
            assertFalse(resultat, "Le bateau ne devrait pas pouvoir être placé sur une position occupée.");
        }

        @Test
        public void testSaisirBatTaille1() {
            String input = "5\n6\n"; 
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

            ArrayList<Integer> resultat = methodesJeuNaval.saisirBat(1);
            ArrayList<Integer> attendu = new ArrayList<>();
            attendu.add(5); 

            assertEquals(attendu, resultat, "Les coordonnées (5, 6) sont attendues pour un bateau de taille 1.");
        }

        @Test
        public void testSaisirBatTaille2() {
            String input = "3\n4\n2\n"; 
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

            ArrayList<Integer> resultat = methodesJeuNaval.saisirBat(2);
            ArrayList<Integer> attendu = new ArrayList<>();
            attendu.add(3); 
            attendu.add(4); 
            attendu.add(2); 

            assertEquals(attendu, resultat, "Les coordonnées (3, 4) avec direction 2 sont attendues pour un bateau de taille 2.");
        }

        @Test
        public void testAttaquerOrdiBateauTrouve() {
            String[][] plateauOrdi = new String[11][11];
            methodesJeuNaval.remplirPlateauVide(plateauOrdi);

            plateauOrdi[5][6] = "X"; 

            String input = "6\n5\n"; 
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

            methodesJeuNaval.attaquerOrdi(plateauOrdi);

            assertEquals("X", plateauOrdi[5][6], "Le bateau a été trouvé et détruit.");
        }

        @Test
        public void testAttaquerOrdiPasDeBateau() {
            String[][] plateauOrdi = new String[11][11];
            methodesJeuNaval.remplirPlateauVide(plateauOrdi);

            String input = "4\n3\n"; 
            System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

            methodesJeuNaval.attaquerOrdi(plateauOrdi);

            assertEquals("- ", plateauOrdi[3][4], "Aucun bateau n'était présent à ces coordonnées.");
        }
    }


