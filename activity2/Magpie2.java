package activity2;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no ") >= 0) {
            response = "Why so negative?";
        }
        else if ((containsWord(statement, "mother")  ||
                 (containsWord(statement, "father")) ||
                 (containsWord(statement, "sister")) ||
                 (containsWord(statement, "brother")))) {
            response = "Tell me more about your family.";
        }
        else if ((containsWord(statement, "dog")) ||
                 (containsWord(statement, "cat")) ||
                 (containsWord(statement, "fish"))){
            response = "Tell me more about your pets.";
        }
        else if (containsWord(statement, "Mr.")) {
            int nameIndex = statement.lastIndexOf("Mr.") + 5; // 4 is the length of Mr.
            int nameIndexEnd = nameIndex + statement.indexOf(" ", nameIndex);
            System.out.println(nameIndex);
            System.out.println(nameIndexEnd);
            String firstName = statement.substring(nameIndex, nameIndex );       
            if(containsWord(statement, "Maine") ||
               containsWord(statement, "Simonson")){
                response = "Mr. " + firstName + " sounds seriously lame";
            }
            else {
                response = "Mr. " + firstName + " sounds awesome";
            }
        }
        else  {
            response = getRandomResponse();
        }
        return response;
    }

    public boolean containsWord(String sentence, String word) {
        boolean contains = sentence.indexOf(word) >= 0;
        int firstInstanceOfWord = -1;
        if(contains) {
            firstInstanceOfWord = firstInstance(sentence, word);            
        }
        return firstInstanceOfWord >= 0;
    }
    
    public int firstInstance(String sentence, String word) {
        int firstChar = (sentence.indexOf(word));
        int finalChar = (sentence.indexOf(word) + word.length() - 1);
        if(sameCharacter(sentence, (firstChar - 1), " ") &&
           sameCharacter(sentence, (finalChar + 1), " ")) {
               return sentence.indexOf(word);
        }
        return -1;
    }
    
    public boolean sameCharacter(String sentence, int character, String compareChar){
        if(character >= 0 && !(character >= sentence.length())) {
            return (sentence.substring(character, character + 1).equals(compareChar));
        }
        return true;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }

        return response;
    }
}
