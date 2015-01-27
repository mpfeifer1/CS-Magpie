package activity2;


/**
 * Write a description of class WordProcessing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordProcessing
{
       public static boolean containsWord(String sentence, String word) {
        boolean contains = sentence.toLowerCase().indexOf(word.toLowerCase()) >= 0;
        int firstInstanceOfWord = -1;
        if(contains) {
            firstInstanceOfWord = firstInstance(sentence.toLowerCase(), word.toLowerCase());            
        }
        return firstInstanceOfWord >= 0;
    }
    
    public static int firstInstance(String sentence, String word) {
        int firstChar = (sentence.indexOf(word));
        int finalChar = (sentence.indexOf(word) + word.length() - 1);
        if((sameCharacter(sentence, (firstChar - 1), " ")   &&
           ((sameCharacter(sentence, (finalChar + 1), " ")) ||
            (sameCharacter(sentence, (finalChar + 1), "!")) ||
            (sameCharacter(sentence, (finalChar + 1), ".")) ||
            (sameCharacter(sentence, (finalChar + 1), ",")) ||
            (sameCharacter(sentence, (finalChar + 1), "?"))))) {
               return sentence.indexOf(word);
        }
        return -1;
    }
    
    public static boolean sameCharacter(String sentence, int character, String compareChar){
        if(character >= 0 && !(character >= sentence.length())) {
            return (sentence.substring(character, character + 1).equals(compareChar));
        }
        return true;
    }

}