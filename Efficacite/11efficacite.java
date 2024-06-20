package iut.sae.algo;

public class Algo{
    public static String RLE(String in) {
        if (in.length() == 0) return "";

        StringBuilder stringReturn = new StringBuilder();
        int length = in.length();
    
        char charSelect = in.charAt(0);
        int nbChar = 1;
    
        for (int i = 1; i < length; i++) {
            if (in.charAt(i) != charSelect) {
                stringReturn.append(nbChar).append(charSelect);
                charSelect = in.charAt(i);
                nbChar = 1;
            } else {
                nbChar++;
                if (nbChar == 10) { 
                    stringReturn.append(9).append(charSelect);
                    nbChar = 1;
                }
            }
        }
    
        stringReturn.append(nbChar).append(charSelect);
    
        return stringReturn.toString();
    }

    public static String RLE(String in, int iteration) throws AlgoException{
        if (iteration < 1 ) throw new AlgoException("Impossible d'avoir une iteration < 1");
        if (iteration == 1) return RLE(in);

        return RLE(RLE(in, iteration-1));
    }

    public static String unRLE(String in) throws AlgoException {
        StringBuilder stringReturn = new StringBuilder();
        int length = in.length();

        for (int i=0; i<length; i += 2) {
            for (int j=0; j< in.charAt(i) - '0'; j++) {
                stringReturn.append(in.charAt(i+1));
            }
        }

        return stringReturn.toString();
    }

    public static String unRLE(String in, int iteration) throws AlgoException{
        if (iteration < 1 ) throw new AlgoException("Impossible d'avoir une iteration < 1");
        if (iteration == 1) return unRLE(in);

        return unRLE(unRLE(in, iteration-1));
    }
}

