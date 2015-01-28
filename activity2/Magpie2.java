package activity2;

import activity2.WordProcessing;
import java.util.ArrayList;

public class Magpie2 extends WordProcessing {
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    public String getResponse(String statement)
    {
        String response = "";
        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> pets   = new ArrayList<>();
        
        family.add("mother");
        family.add("father");
        family.add("brother");
        family.add("brothers");
        family.add("sister");
        family.add("sisters");
        
        pets.add("dog");
        pets.add("dogs");
        pets.add("cat");
        pets.add("cats");
        pets.add("fish");
        pets.add("fishes");
        
        if(statement.trim().length() == 0) {
            response = "Cat got your tongue?";
        }
        else if (containsWord(statement, "no")) {
            response = "Why so negative?";
        }
        else if (containsWordList(statement, family).size() > 0) {
            response = "Tell me more about your " +
                       appendWords(containsWordList(statement, family));
        }
        else if (!containsWordList(statement, pets).isEmpty()) {
            response = "Tell me more about your " +
                       appendWords(containsWordList(statement, pets));
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
