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
        else if (statement.indexOf(" mother" ) >= 0
              || statement.indexOf(" father" ) >= 0
              || statement.indexOf(" sister" ) >= 0
              || statement.indexOf(" brother") >= 0) {
            response = "Tell me more about your family.";
        }
        else if (containsWord(response, "dog")) {
            response = "Tell me more about your pets.";
        }
        else if (statement.indexOf("Mr. ") >= 0) {
            int spaceAfterMr = statement.lastIndexOf("Mr. ") + 4;
            String firstName = statement.substring(spaceAfterMr, statement.indexOf(" ", spaceAfterMr));
            if(firstName.toLowerCase().contains("maine")){
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
        return firstInstanceOfWord > 0;
    }
    
    public int firstInstance(String sentence, String word) {
        int firstChar = (sentence.indexOf(word) - 1);
        int finalChar = (sentence.indexOf(word) + 1 + word.length());
        if(((sentence.substring(firstChar, firstChar + 1).equals(" ")) || (sentence.substring(firstChar, firstChar + 1) == null)) && 
           ((sentence.substring(finalChar, finalChar + 1).equals(" ")) || (sentence.substring(finalChar, finalChar + 1) == null))) {
               return sentence.indexOf(word);
        }
        return -1;
    }
    
    //public int lastChar(String sentence, String word) {
    //    //TODO
    //}
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
