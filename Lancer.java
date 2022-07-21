import java.util.Arrays;

public class Lancer {

    private int lancer[];

    public Lancer(){}

    public void enregistrer(De d1, De d2, De d3){
        this.lancer = new int[]{d1.getValeur(), d2.getValeur(), d3.getValeur()}; 
    }

    public String getLancer(){
        return this.lancer[0] + ", " + this.lancer[1] + ", " + this.lancer[2];
    }

    public void triCroissant(){
        Arrays.sort(this.lancer);
    }

    public void triDecroissant(){
        Arrays.sort(this.lancer);
        int perm = this.lancer[0];
        this.lancer[0] = this.lancer[2];
        this.lancer[2] = perm;
    }
    
    public boolean est421(){
        this.triDecroissant();
        if(this.lancer[0] == 4){
            if(this.lancer[1] == 2){
                if(this.lancer[2] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estBrelan(){
        if(this.lancer[0] == 1){
            if(this.lancer[1] == 1){
                if(this.lancer[2] == 1){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estBrelanDe(){
        if((this.lancer[0] != 1) && (this.lancer[0] == this.lancer[1])){
            if(this.lancer[1] == this.lancer[2]){
                return true;
            }
        }
        return false;
    }

    public boolean estDeuxAsPlus(){
        this.triCroissant();
        if(this.lancer[0] == 1){
            if(this.lancer[1] == 1){
                if(this.lancer[2] != 1){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estSuite(){
        this.triCroissant();
        if(this.lancer[1] == this.lancer[0]+1){
            if(this.lancer[2] == this.lancer[1]+1){
                return true;
            }
        }
        return false;
    }

    public int getValeurDeuxAs(){
        this.triCroissant();
        return this.lancer[2];
    }

}
