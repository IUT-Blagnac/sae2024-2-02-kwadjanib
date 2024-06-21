package iut.sae.algo.efficacite;
import iut.sae.algo.AlgoException;

//algo11 efficacité
public class Efficacite11{
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

package iut.sae.algo.efficacite;

public class Efficacite12 {

    public static String RLE(String chaine) {
        if (chaine == null || chaine.isEmpty()) {
            return "";
        }

        StringBuilder resultat = new StringBuilder();
        int compteur = 1;
        char premierCaractere = chaine.charAt(0);

        for (int i = 1; i < chaine.length(); i++) {
            if (chaine.charAt(i) == premierCaractere) {
                compteur++;
                if (compteur == 9) {
                    resultat.append(9).append(premierCaractere);
                    compteur = 0;
                }
            } else {
                if (compteur > 0) {
                    resultat.append(compteur).append(premierCaractere);
                }
                premierCaractere = chaine.charAt(i);
                compteur = 1;
            }
        }

        if (compteur > 0) {
            resultat.append(compteur).append(premierCaractere);
        }

        return resultat.toString();
    }

    public static String unRLE(String chaine) {
        if (chaine == null || chaine.isEmpty()) {
            return "";
        }

        StringBuilder resultat = new StringBuilder();
        int i = 0;

        while (i < chaine.length()) {
            char caractere = chaine.charAt(i);
            if (Character.isDigit(caractere)) {
                int nombre = Character.getNumericValue(caractere);
                char caractereSuivant = chaine.charAt(i + 1);
                for (int j = 0; j < nombre; j++) {
                    resultat.append(caractereSuivant);
                }
                i += 2;
            } else {
                resultat.append(caractere);
                i++;
            }
        }

        return resultat.toString();
    }

    public static String RLE_Recursif(String chaine, int iteration) {
        String resultat = chaine;
        for (int i = 0; i < iteration; i++) {
            resultat = RLE(resultat);
        }
        return resultat;
    }

    public static String unRLE_Recursif(String chaine, int iteration) {
        String resultat = chaine;
        for (int i = 0; i < iteration; i++) {
            resultat = unRLE(resultat);
        }
        return resultat;
    }

    public static void main(String[] args) {
        String compressed = RLE("wwwwwwwwwwww");
        System.out.println("Compressed: " + compressed);  // Output: "9w3w"

        String decompressed = unRLE(compressed);
        System.out.println("Decompressed: " + decompressed);  // Output: "wwwwwwwwwwww"
    }
}
package iut.sae.algo.efficacite;
import iut.sae.algo.AlgoException;

/**
 * La classe Efficacite fournit des méthodes pour compresser et décompresser des chaînes de caractères 
 * en utilisant l'algorithme de Run-Length Encoding (RLE).
 */
public class Efficacite14 {

    /**
     * Compresse une chaîne de caractères en utilisant l'algorithme RLE.
     * 
     * @param in La chaîne de caractères à compresser.
     * @return La chaîne de caractères compressée.
     */
    public static String RLE(String in) {
        StringBuilder result = new StringBuilder();
        for (int i = 0, count = 1; i < in.length(); i++) {
            if (i + 1 < in.length() && in.charAt(i) == in.charAt(i + 1) && count < 9) {
                count++;
            } else {
                result.append(count).append(in.charAt(i));
                count = 1;
            }
        }
        return result.toString();
    }

    /**
     * Compresse une chaîne de caractères en utilisant l'algorithme RLE de manière récursive.
     * 
     * @param in La chaîne de caractères à compresser.
     * @param iteration Le nombre d'itérations de compression.
     * @return La chaîne de caractères compressée après le nombre d'itérations spécifié.
     * @throws AlgoException Si une erreur survient pendant la compression.
     */
    public static String RLE(String in, int iteration) throws AlgoException {
        if (iteration == 1)
            return RLE(in);
        else
            return RLE(RLE(in), iteration - 1);
    }

    /**
     * Décompresse une chaîne de caractères en utilisant l'algorithme RLE.
     * 
     * @param in La chaîne de caractères à décompresser.
     * @return La chaîne de caractères décompressée.
     * @throws AlgoException Si une erreur survient pendant la décompression.
     */
    public static String unRLE(String in) throws AlgoException {
        StringBuilder motRetour = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            int nombreDeLettre = Integer.parseInt("" + in.charAt(i));
            i++;
            for (int z = 0; z < nombreDeLettre; z++)
                motRetour.append(in.charAt(i));
        }
        return motRetour.toString();
    }

    /**
     * Décompresse une chaîne de caractères en utilisant l'algorithme RLE de manière récursive.
     * 
     * @param in La chaîne de caractères à décompresser.
     * @param iteration Le nombre d'itérations de décompression.
     * @return La chaîne de caractères décompressée après le nombre d'itérations spécifié.
     * @throws AlgoException Si une erreur survient pendant la décompression.
     */
    public static String unRLE(String in, int iteration) throws AlgoException {
        if (iteration == 1)
            return unRLE(in);
        else
            return unRLE(unRLE(in), iteration - 1);
    }
}
package iut.sae.algo.efficacite;


public class Efficacite27{
    public static String RLE(String in){
        String newChaine= "";
        int cpt = 1 ;  // On initialise le compteur à 1 
        for(int i=0;i<in.length(); i++){ // On parcourt la chaine 
            if(i < in.length()-1 && in.charAt(i)==in.charAt(i+1) && cpt<9){ //Si ce n'est pas le dernier caractere de la chaine et que le caractere suivant est pareil et que le compteur est inferieur à 9  
                cpt ++;                       // Alors on incrémente le compteur
            }
            else{ // Sinon on ajoute le compteur + le caractere dans la chaine a retourner 
                newChaine = newChaine + cpt + in.charAt(i);
                cpt = 1; // Et on remet le compteur à 1
            }

        }
        return newChaine;
    }

    public static String RLE(String in, int iteration) {
        if(iteration !=1){   // Tant que l'iteration n'est pas 1 on continue a faire tourner le programme 
            String nouvelchaine = RLE(in);
            return RLE(nouvelchaine,iteration-1); //On decremente a chaque fois l'iteration jusqua arriver à 1 
        }
        return RLE(in); // Ducoup si iteration == 1 c'est un RLE simple et c'est le résultat final 
    }

    public static String unRLE(String in) {
        String newChaine= "";
        for(int i=0;i<in.length(); i=i+2){ // Boucle avec un pas de 2 car on n'a pas besoin de parcourir les "caractères" 
            for(int y=0;y<Character.getNumericValue(in.charAt(i)) ;y++){ //Boucle pour construire le nombre de caractere dans la nouvelle chaine
                newChaine = newChaine + in.charAt(i+1);
            }
            
        }
        return newChaine;
    }

    public static String unRLE(String in, int iteration){
        if(iteration !=1){                      //J'ai repris mon algo RLE recursif en changeant la methode en unRLE 
            String nouvelchaine = unRLE(in);
            return unRLE(nouvelchaine,iteration-1); 
        }
        return unRLE(in); 
    }
}
package iut.sae.algo.efficacite;
//algo30 efficacité
import iut.sae.algo.AlgoException;

public class Efficacite30{
    public static String RLE(String chaine){
        // Utilisation d'un StringBuilder (pour améliorer le temps d'execution) car l'object String ne concatène pas simplement plusieurs chaine.
        // Initialisation d'un compteur et d'un indice
        StringBuilder dBuilder = new StringBuilder();
        int cptChar = 1;
        char charC;
        int i = 0;

        while(i < chaine.length()){
            charC = chaine.charAt(i);

            while (i+1 < chaine.length() && charC == chaine.charAt(i+1)){
                cptChar++;
                i++;
                if (cptChar == 9) {
                    dBuilder.append(9).append(charC);
                    cptChar = 0;
                }
                
            } 
            if (cptChar > 0) {
                dBuilder.append(cptChar).append(charC);
            }
            cptChar = 1;
            i++;
        }
        // On retourne la méthode toString() du builder qui renvoie la chaîne compressée
        return dBuilder.toString();
    }

    public static String RLE(String chaine, int iteration) throws AlgoException{
        if (iteration == 0){
            return chaine;
        }
        else{
            return RLE(RLE(chaine), iteration-1);
        }
        
    }

    public static String unRLE(String chaine) throws AlgoException{
        if (chaine.length() == 0 || !Character.isDigit(chaine.charAt(0))) {
            return chaine;
        }
        StringBuilder dBuilder = new StringBuilder();

        // On parcourt la chaine de 2 en 2 (pour chaque couple compteur/caractère)
        for (int i = 0; i < chaine.length(); i+=2) {
            // On récupère le compteur devant le caractère...
            int cptChar = Character.getNumericValue(chaine.charAt(i));
            char carac = chaine.charAt(i+1);

            // ... et on ajoute le caractère le nombre de fois nécessaire (=compteur)
            for(int j = 0; j < cptChar; j++){
                dBuilder.append(carac);
            }
        }
    return dBuilder.toString();

    }

    public static String unRLE(String chaine, int iteration) throws AlgoException{
        if (iteration == 0){
            return chaine;
        }
        else {
            return unRLE(unRLE(chaine), iteration-1);
        }

    }
}

package iut.sae.algo.efficacite;
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
package iut.sae.algo.efficacite;


//simplicite 27


public class Simplicite27{
    public static String RLE(String in){
        String newChaine= "";
        int cpt = 1 ;  // On initialise le compteur à 1 
        for(int i=0;i<in.length(); i++){ // On parcourt la chaine 
            if(i < in.length()-1 && in.charAt(i)==in.charAt(i+1) && cpt<9){ //Si ce n'est pas le dernier caractere de la chaine et que le caractere suivant est pareil et que le compteur est inferieur à 9  
                cpt ++;                       // Alors on incrémente le compteur
            }
            else{ // Sinon on ajoute le compteur + le caractere dans la chaine a retourner 
                newChaine = newChaine + cpt + in.charAt(i);
                cpt = 1; // Et on remet le compteur à 1
            }

        }
        return newChaine;
    }

    public static String RLE(String in, int iteration) {
        if(iteration !=1){   // Tant que l'iteration n'est pas 1 on continue a faire tourner le programme 
            String nouvelchaine = RLE(in);
            return RLE(nouvelchaine,iteration-1); //On decremente a chaque fois l'iteration jusqua arriver à 1 
        }
        return RLE(in); // Ducoup si iteration == 1 c'est un RLE simple et c'est le résultat final 
    }

    public static String unRLE(String in) {
        String newChaine= "";
        for(int i=0;i<in.length(); i=i+2){ // Boucle avec un pas de 2 car on n'a pas besoin de parcourir les "caractères" 
            for(int y=0;y<Character.getNumericValue(in.charAt(i)) ;y++){ //Boucle pour construire le nombre de caractere dans la nouvelle chaine
                newChaine = newChaine + in.charAt(i+1);
            }
            
        }
        return newChaine;
    }

    public static String unRLE(String in, int iteration){
        if(iteration !=1){                      //J'ai repris mon algo RLE recursif en changeant la methode en unRLE 
            String nouvelchaine = unRLE(in);
            return unRLE(nouvelchaine,iteration-1); 
        }
        return unRLE(in); 
    }
}
package iut.sae.algo.simplicite;
import iut.sae.algo.AlgoException;

public class Simplicite34{
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
package iut.sae.algo.simplicite;

public class Simplicite47{

    // Méthode pour compresser une chaîne en utilisant l'algorithme RLE
    public static String RLE(String entree) {

        if (entree == null || entree.equals("")) {
            return "";  // Retourne une chaîne vide si l'entrée est nulle ou vide
        }

        String messageCompresse = "";  // Chaîne pour stocker le message compressé
        int cpt = 0;  // Compteur pour les occurrences d'un caractère
        String caractere = entree.substring(0, 1);  // Premier caractère de la chaîne

        // Parcourir chaque caractère de la chaîne d'entrée
        for (int i = 0; i < entree.length(); i++) {
            String currentChar = entree.substring(i, i + 1);

            if (currentChar.equals(caractere)) {
                // Si le caractère courant est le même que le précédent
                if (cpt == 9) {  // Limite à 9 pour éviter de dépasser un seul chiffre
                    messageCompresse += cpt + caractere;  // Ajoute le caractère et son compte
                    cpt = 0;  // Réinitialise le compteur
                }
                cpt++;  // Incrémente le compteur
            } else {
                // Si le caractère courant est différent du précédent
                messageCompresse += cpt + caractere;  // Ajoute le caractère et son compte
                caractere = currentChar;  // Met à jour le caractère
                cpt = 1;  // Réinitialise le compteur pour le nouveau caractère
            }
        }

        // Ajoute la dernière séquence de caractère et son compte
        messageCompresse += cpt + caractere;

        return messageCompresse;  // Retourne la chaîne compressée
    }

    // Méthode pour compresser une chaîne en utilisant RLE plusieurs fois
    public static String RLE(String entree, int iteration) {
        if (entree == null || entree.equals("")) {
            return "";  // Retourne une chaîne vide si l'entrée est nulle ou vide
        }

        for (int i = 0; i < iteration; i++) {
            entree = RLE(entree);  // Applique la compression RLE plusieurs fois
        }

        return entree;  // Retourne la chaîne compressée après les itérations
    }

    // Méthode pour décompresser une chaîne utilisant l'algorithme RLE
    public static String unRLE(String entree) {
        if (entree == null || entree.equals("")) {
            return "";  // Retourne une chaîne vide si l'entrée est nulle ou vide
        }

        String messageDecrypte = "";  // Chaîne pour stocker le message décompressé

        // Parcourir chaque caractère de la chaîne compressée
        for (int i = 0; i < entree.length(); i++) {
            if (i % 2 == 0) {  // Chaque nombre de répétition est à une position paire
                int count = Integer.parseInt(entree.substring(i, i + 1));  // Nombre de répétitions
                char currentChar = entree.charAt(i + 1);  // Caractère à répéter

                // Ajoute le caractère décompressé le nombre de fois indiqué
                for (int j = 0; j < count; j++) {
                    messageDecrypte += currentChar;
                }
            }
        }

        return messageDecrypte;  // Retourne la chaîne décompressée
    }

    // Méthode pour décompresser une chaîne utilisant RLE plusieurs fois
    public static String unRLE(String entree, int iteration) {
        if (entree == null || entree.equals("")) {
            return "";  // Retourne une chaîne vide si l'entrée est nulle ou vide
        }

        for (int i = 0; i < iteration; i++) {
            entree = unRLE(entree);  // Applique la décompression RLE plusieurs fois
        }

        return entree;  // Retourne la chaîne décompressée après les itérations
    }
}

package iut.sae.algo.simplicite;
import iut.sae.algo.AlgoException;

public class Simplicite56{
    public static String RLE(String in) {
        if (in.isEmpty() || in == null) {
            return "";
        }

        String resultat = "";
        char caracPrecedent = in.charAt(0);
        int nbChar = 1;
        char caracActuel = 'a';
        for (int i = 1; i < in.length(); i++) {
            caracActuel = in.charAt(i);
            if (caracActuel == caracPrecedent) {
                nbChar++;
                if (nbChar == 10) {
                    resultat +=  9 + caracPrecedent;
                    //resultat += "" + 9 + caracPrecedent; erreur dommage
                    nbChar = 1;
                }
            } else {
                resultat += "" + nbChar + caracPrecedent;
                nbChar = 1;
                caracPrecedent = caracActuel;
            }
        }
        return (resultat + nbChar + caracActuel);

    }

    public static String RLE(String in, int iteration) throws AlgoException {
        if (iteration < 1) {
            throw new AlgoException("Il faut que l'itération soit au moins égal à 1");
        }
        if (iteration == 1) {
            return RLE(in);
        }
        return RLE(RLE(in, iteration - 1));

    }

    public static String unRLE(String in) throws AlgoException {
        if (in == "" || in == null) {
            return "";
        }
        String resultat = "";
        for (int i = 0; i < in.length(); i += 2) {
            int valeur = Character.getNumericValue(in.charAt(i));
            if (valeur > 9) {
                throw new AlgoException("Erreur : l'argument n'est pas compressé");
            }
            for (int j = 0; j < valeur; j++) {
                resultat += "" + in.charAt(i + 1);
            }
        }
        return resultat;

    }

    public static String unRLE(String in, int iteration) throws AlgoException {
        if (iteration < 1) {
            throw new AlgoException("Il faut que l'itération soit au moins égal à 1");
        }
        if (iteration == 1) {
            return unRLE(in);
        }
        try {

            return unRLE(unRLE(in, iteration - 1));

        } catch (AlgoException a) {
            throw new AlgoException(""+a);
        }
    }
}








