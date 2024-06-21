package iut.sae.algo.simplicite;
import iut.sae.algo.AlgoException;

public class Simplicite19 {
    public static String RLE(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
    
        StringBuilder code = new StringBuilder();
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                code.append(count).append(input.charAt(i - 1));
                count = 1;
            }
        }
        code.append(count).append(input.charAt(input.length() - 1));
    
        return code.toString();
    }

    public static String RLEIteration(String input, int iteration) throws AlgoException {
        if (input == null || input.isEmpty()) {
            return "";
        }

        if (iteration < 1) {
            throw new AlgoException("Itération inférieure à 1");
        }

        String result = input;
        for (int i = 0; i < iteration; i++) {
            String newResult = RLE(result);
            if (newResult.equals(result)) {
                break;
            }
            result = newResult;
        }

        return result;
    }
    
    public static void main(String[] args) throws AlgoException {
        String input = "SAE Algo";
        System.out.println(RLEIteration(input, 20));
    }
}
