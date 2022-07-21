public class Joueur {
    
    private final int NBR_JETONS_DEBUT = 11;
    private String nom;
    private int nbrJetons = NBR_JETONS_DEBUT;
    private De d1, d2, d3;
    private Lancer dernierLancer;
    

    public Joueur(String nom){
        this.d1 = new De();
        this.d2 = new De();
        this.d3 = new De();
        this.dernierLancer = new Lancer();
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public void jouer(){
        this.d1.rouler();
        this.d2.rouler();
        this.d3.rouler();
        this.dernierLancer.enregistrer(d1, d2, d3);
    }

    public void modifierScore(int nbr){
        this.nbrJetons += nbr;
        if(this.nbrJetons < 0){
            this.nbrJetons = 0;
        }
        else if(this.nbrJetons > NBR_JETONS_DEBUT * 2){
            this.nbrJetons = NBR_JETONS_DEBUT * 2;
        }
    }

    public int getJetons(){
        return this.nbrJetons;
    }

    public Lancer getLancer(){
        return this.dernierLancer;
    }

    public void afficheLancer(){
        System.out.println("Resultat : " + this.dernierLancer.getLancer());
    }

    public void afficheScore(){
        System.out.println(this.nom + " a " + this.nbrJetons + " jeton(s)");
    }

}
