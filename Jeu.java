import java.util.Scanner;

public class Jeu {

    private Joueur j1, j2;
    private Arbitre arbitre;
    private Scanner scanner = new Scanner(System.in);

    public Jeu() {
        System.out.println("Entrer le nom du joueur 1 : ");
        String nomJ1 = scanner.nextLine();
        this.j1 = new Joueur(nomJ1);
        System.out.println("Entrer le nom du joueur 2 : ");
        String nomJ2 = scanner.nextLine();
        this.j2 = new Joueur(nomJ2);
        this.arbitre = new Arbitre();
    }

    public void joueur1Gagne(int points) {
        System.out.println(this.j1.getNom() + " remporte la manche !");
        j1.modifierScore(-points);
        j2.modifierScore(points);
    }

    public void joueur2Gagne(int points) {
        System.out.println(this.j2.getNom() + " remporte la manche !");
        j1.modifierScore(points);
        j2.modifierScore(-points);
    }

    public void resultatDepartage(int resultat, int points) {
        if (resultat == 1) {
            this.joueur1Gagne(points);
        } else if (resultat == 2) {
            this.joueur2Gagne(points);
        } else {
            System.out.println("Impossible de vous départager...");
        }
    }

    public boolean estTermine() {
        if (this.j1.getJetons() == 0 || this.j2.getJetons() == 0) {
            return true;
        }
        return false;
    }

    public void afficheGagnant(){
        if(this.j1.getJetons() == 0){
            System.out.println(this.j1.getNom() + " remporte la partie !");
        }
        else{
            System.out.println(this.j2.getNom() + " remporte la partie !");
        }
    }

    public void go() {
        System.out.println(this.j1.getNom() + " lance les dés...");
        this.j1.jouer();
        this.j1.afficheLancer();

        System.out.println(this.j2.getNom() + " lance les dés...");
        this.j2.jouer();
        this.j2.afficheLancer();

        int r1 = arbitre.calculer(this.j1.getLancer());
        int r2 = arbitre.calculer(this.j2.getLancer());
        if (r1 > r2) {
            this.joueur1Gagne(r1);
        } else if (r1 < r2) {
            this.joueur2Gagne(r2);
        } else {
            System.out.println("Egalité ! Nous allons devoir vous départager !");
            int r = arbitre.departage(this.j1.getLancer(), this.j2.getLancer());
            switch (r1) {
                case 1:
                    this.resultatDepartage(r, 1);
                    break;
                case 2:
                    this.resultatDepartage(r, 2);
                    break;
                case 3:
                    this.resultatDepartage(r, 3);
                    break;
                default:
                    break;
            }
        }
        j1.afficheScore();
        j2.afficheScore();
        System.out.println();
    }

    public static void main(String[] args) {
        Jeu j = new Jeu();
        System.out.println("Le jeu va commencer !");

        do {
            j.go();
        } while (!j.estTermine());

        j.afficheGagnant();

    }
}
