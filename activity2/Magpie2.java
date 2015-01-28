package activity2;

import activity2.WordProcessing;

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
public class Magpie2 extends WordProcessing {
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
        if(statement.trim().length() == 0) {
            response = "Cat got your tongue?";
        }
        else if (statement.indexOf("no ") >= 0) {
            response = "Why so negative?";
        }
        else if ((containsWord(statement, "mother")  ||
                 (containsWord(statement, "father")) ||
                 (containsWord(statement, "sister")) ||
                 (containsWord(statement, "brother")))) {
            response = "Tell me more about your family.";
        }
        else if ((containsWord(statement, "dog" )) ||
                 (containsWord(statement, "dogs")) ||
                 (containsWord(statement, "cat" )) ||
                 (containsWord(statement, "cats")) ||
                 (containsWord(statement, "fish"))) {
            response = "Tell me more about your pets.";
        }
        else if (containsWord(statement, "dakota")) {
            response = "You're right. Dakota is an idiot!";
        }
        else if (containsWord(statement, "Mr.")) {
            String firstName = getNextWord(statement, "Mr.");
            if(firstName.toLowerCase().equals("maine") ||
               firstName.toLowerCase().equals("simonson")){
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
