/*
QUESTION #2:

//
// The following Java code is responsible for creating an HTML "SELECT"
// list of U.S. states, allowing a user to specify his or her state. This might
// be used, for instance, on a credit card transaction screen. 
//
// Please rewrite this code to be "better". Submit your replacement code, and
// please also submit a few brief comments explaining why you think your code
// is better than the sample.
//
// (For brevity, this sample works for only 5 states. The real version would
// need to work for all 50 states. But it is fine if your rewrite shows only
// the 5 states here.)
//

public class StateUtils {

  //
  // Generates an HTML select list that can be used to select a specific
  // U.S. state.
  //
  public static String createStateSelectList()
  {
    return
      "<select name=\"state\">\n"
    + "<option value=\"Alabama\">Alabama</option>\n"
    + "<option value=\"Alaska\">Alaska</option>\n"
    + "<option value=\"Arizona\">Arizona</option>\n"
    + "<option value=\"Arkansas\">Arkansas</option>\n"
    + "<option value=\"California\">California</option>\n"
    // more states here
    + "</select>\n"
    ;
  }

  //
  // Parses the state from an HTML form submission, converting it to
  // the two-letter abbreviation.
  //
  public static String parseSelectedState(String s)
  {
    if (s.equals("Alabama"))     { return "AL"; }
    if (s.equals("Alaska"))      { return "AK"; }
    if (s.equals("Arizona"))     { return "AZ"; }
    if (s.equals("Arkansas"))    { return "AR"; }
    if (s.equals("California"))  { return "CA"; }
    // more states here
  }

  //
  // Displays the full name of the state specified by the two-letter code.
  //
  public static String displayStateFullName(String abbr) {
  {
    if (abbr.equals("AL")) { return "Alabama";    }
    if (abbr.equals("AK")) { return "Alaska";     }
    if (abbr.equals("AZ")) { return "Arizona";    }
    if (abbr.equals("AR")) { return "Arkansas";   }
    if (abbr.equals("CA")) { return "California"; }
    // more states here
  }

}
*/

package com.company;

import java.util.*;

public class Main {

    // The best way for this solution:
    // Put the contents of the objects 'ABBREVIATIONS' and 'STATES' in a dictionary file.
    //
    // Like that:
    // State - Abbreviation
    //
    // And parse from this file.

    public static void main(String[] args) {
        fillDictionary();
    }

    private static void fillDictionary() {
        for (int i = 0; i < ABBREVIATIONS.length; i++) {
            DictionaryStates.put(ABBREVIATIONS[i], STATES[i]);
        }
    }

    public static String createStateSelectList() {
        StringBuilder stringBuilder = new StringBuilder("<select name=\"state\">\n");
        for (String ALL_STATE : STATES)
            stringBuilder.append("<option value=\"").append(ALL_STATE).append("\">").append(ALL_STATE).append("</option>\n");
        stringBuilder.append("</select>\n");
        return stringBuilder.toString();
    }

    public static String parseSelectedState(String s) {
        for (String str : DictionaryStates.keySet()) {
            if (DictionaryStates.get(str).equals(s)) {
                return str;
            }
        }
        return UnknownParameter;
    }

    public static String displayedStateFullName(String abbr) {
        String fullName = DictionaryStates.get(abbr);
        if (fullName == null)
            return UnknownParameter;
        return fullName;
    }

    private static final String[] ABBREVIATIONS = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    private static final String[] STATES = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
    private static final String UnknownParameter = "Unknown";
    private static HashMap<String, String> DictionaryStates = new HashMap<>();
}