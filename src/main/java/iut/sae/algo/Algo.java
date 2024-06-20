package iut.sae.algo;

public class Algo {
    public static String RLE(String in) {
        String out = "";
        int cpt = 0;
        int nb = 0;
        if (in.equals("")) {

        } else {

            boolean fin = true;
            while (fin) {
                cpt++;
                nb++;
                if (nb < in.length()) {
                    if (in.charAt(nb) != in.charAt(nb - 1)) {
                        out += cpt +""+ in.charAt(nb - 1);
                        cpt = 0;
                    }
                } else {
                    out += cpt +""+ in.charAt(nb - 1);
                    fin = false;
                }
                if (cpt==9) {
                    out += cpt +""+ in.charAt(nb - 1);
                    cpt=0;
                }

            }

        }
        return out;
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        // Provide your algo here
        return "NotYetImplemented";
    }

    public static String unRLE(String in) throws AlgoException {
        String out = "";
        boolean fin = false;
        int nb = 0;
        int cpt = 0;
        while (fin) {
            if (Character.isDigit(in.charAt(nb))&&Character.isLetter(in.charAt(nb+1))) {
                if (cpt == 0) {
                    cpt = Character.getNumericValue(in.charAt(nb));
                    
                }
                for (int i = 0; i < cpt; i++) {
                    out += in.charAt(nb + 1);
                }
                nb = nb + 2;
                
                
                if (nb == in.length()) {
                    fin = true;
                }
                
                
            }
            if (Character.isDigit(in.charAt(nb))&&Character.isDigit(in.charAt(nb+1))) {
                cpt = Character.getNumericValue(in.charAt(nb))*Character.getNumericValue(in.charAt(nb+1));
            }

            
            
        }
           
        
        return out;

    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        // Provide your algo here
        return "NotYetImplemented";

    }
}
