import java.util.Random;

public class De {
    
    private final int NOMBRE_FACE = 6;
    private int valeur;
    private Random random = new Random();

    public De(){}

    public De(int valeur){
        this.valeur = valeur;
    }

    public void rouler(){   
		this.valeur = this.random.nextInt(NOMBRE_FACE) + 1;
    }

    public int getValeur(){
        return this.valeur;
    }

}
