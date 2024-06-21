package iut.sae.algo.sobriété;

//sobriété 45
public class Sobriete45 {
    public static String RLE(String in) {
        if (in.isEmpty()) {
            return "";
        }
    
        StringBuilder out = new StringBuilder();
        int i = 0;
    
        while (i < in.length()) {
            char c = in.charAt(i);
            int count = 1;
            i++;
    
            while (i < in.length() && in.charAt(i) == c && count < 9) {
                count++;
                i++;
            }
    
            if (count >= 9) {
                out.append("9").append(c);
            } else {
                out.append(count).append(c);
            }
        }
    
        return out.toString();
    }
    

    public static String RLE(String in, int iterations) {
        String result = in;
        
        for (int iter = 0; iter < iterations; iter++) {
            StringBuilder out = new StringBuilder();
            int i = 0;
            
            while (i < result.length()) {
                char c = result.charAt(i);
                int count = 1;
                i++;
                
                while (i < result.length() && result.charAt(i) == c && count < 9) {
                    count++;
                    i++;
                }
                
                if (count >= 9) {
                    out.append("9").append(c);
                } else {
                    out.append(count).append(c);
                }
            }
            
            result = out.toString();
        }
        
        return result;
    }
    

    public static String unRLE(String in) {
        if (in.isEmpty()) {
            return "";
        }
    
        StringBuilder out = new StringBuilder();
        int i = 0;
    
        while (i < in.length()) {
            int count = Character.getNumericValue(in.charAt(i));
            char c = in.charAt(i + 1);
            i += 2;
    
            for (int j = 0; j < count; j++) {
                out.append(c);
            }
        }
    
        return out.toString();
    }
    

    public static String unRLE(String in, int iterations) {
        String result = in;
        
        for (int iter = 0; iter < iterations; iter++) {
            StringBuilder out = new StringBuilder();
            int i = 0;
            
            while (i < result.length()) {
                int count = Character.getNumericValue(result.charAt(i));
                char c = result.charAt(i + 1);
                i += 2;
                
                for (int j = 0; j < count; j++) {
                    out.append(c);
                }
            }
            
            result = out.toString();
        }
        
        return result;
    }
}
