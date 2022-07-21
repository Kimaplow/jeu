public class Arbitre {
    
    public Arbitre(){}

    public int calculer(Lancer lancer){
        if(lancer.est421()){
            return 8;
        }
        else if(lancer.estBrelan()){
            return 7;
        }
        else if(lancer.estBrelanDe()){
            return 3;
        }
        else if(lancer.estDeuxAsPlus()){
            return lancer.getValeurDeuxAs();
        }
        else if(lancer.estSuite()){
            return 2;
        }
        else{
            return 1;
        }
    }

    public int departage(Lancer l1, Lancer l2){
        if(l1.estDeuxAsPlus() || l2.estDeuxAsPlus()){
            if(l1.estDeuxAsPlus() && !l2.estDeuxAsPlus()){
                return 1;
            }
            else if(!l1.estDeuxAsPlus() && l2.estDeuxAsPlus()){
                return 2;
            }
        }
        else{
            if(l1.getValeurDeuxAs() > l2.getValeurDeuxAs()){
                return 1;
            }
            else if(l1.getValeurDeuxAs() < l2.getValeurDeuxAs()){
                return 2;
            }
        }
        return 0;
    }

}
