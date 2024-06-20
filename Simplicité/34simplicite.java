package iut.sae.algo;


public class Simplicite{
    public static String RLE(String in){
        String resultat="";
        int len = in.length();

        if (len==0){
            return "";
        }

        String tempoLettre = ""+in.charAt(0);
        int tempoNb=1;
        for (int i=0;i<len-1;i++){ 
            // in.charAt(i) sera déjà ajouté, on vérifie donc si le suivant est le même pour l'ajouter    
            if (in.charAt(i)==in.charAt(i+1) && tempoNb<9)   tempoNb+=1;
            
            else{
                //ajout à result
                resultat+=""+tempoNb+tempoLettre;

                tempoLettre=""+in.charAt(i+1);
                tempoNb=1;
            }
        }
        resultat+=""+tempoNb+tempoLettre; //On ajoute le dernier caractère

        return resultat;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        if (iteration>1){ 
            return RLE (RLE(in) , iteration-1); 
        } 
        if (iteration!=0){
            return RLE(in);
        }
        return in; //Si il n'y a aucune itérations à faire de base, on renvoie simplement la chaîne d'entrée. 
    }

    public static String unRLE(String in) throws AlgoException{
        String resultat="";
        
        for (int i=0;i<in.length();i+=2){
            // On prend les valeurs 2 par 2 car elles sont toujours organisées comme "<nbChar><char>"

            for (int j=0 ; j < Character.getNumericValue(in.charAt(i)) ; j++){ 
                resultat+=in.charAt(i+1);
            }
        }

        return resultat;
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if (iteration>1){
            return unRLE(unRLE(in),iteration-1);
        } 
        if (iteration!=0){
            return unRLE(in);
        }
        return in; //Si il n'y a aucune itérations à faire de base, on renvoie simplement la chaîne d'entrée. 

    }
}

