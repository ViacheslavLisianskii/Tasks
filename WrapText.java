/*
QUESTION #3:

Write a Java method with the following method signature that takes a String and
returns a String formatted so that it satisfies the requirements below.  It may
need to insert newlines and/or delete spaces.

Method Signature:
public static String wrapText(String text, int maxCharsPerLine)

Definitions and Assumptions:
A word is a nonempty sequence of characters that contains no spaces and no newlines.
Lines in the return String are separated by the newline character, '\n'.
Words on each line are separated by spaces. Assume that the String argument does
not contain any whitespace characters other than spaces and newlines.

Requirements:
1. Newlines in the String argument are preserved.
2. Words in the return String are separated by either a single space or by one or
more newlines.
3. Lines in the return String do not start or end with any spaces.
4. When constructing the return String from the String argument, each word in the 
String argument with at most maxCharsPerLine characters should not be broken up. 
Each word in the String argument with more than maxCharsPerLine characters should 
be broken up so that all of the other requirements are satisfied.
5. The String argument may contain lines longer than maxCharsPerLine. Newlines
should be added so that each line in the return String has at most maxCharsPerLine
characters. To determine where newlines should be added, try to fit as many words
as possible on a line (while keeping line length at most maxCharsPerLine and
satisfying the other requirements) before starting a new line.
*/

package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(wrapText("It’s a huge world with fast flows, dangerous creatures and hidden caves.\n But for us it is native home and habitat. Let’s look why.", 1));
    }

    public static String wrapText(String text, int maxCharsPerLine) {
        if (text == null)
            throw new IllegalArgumentException("Parameter 'text' cannot be null");

        if (maxCharsPerLine < 1)
            throw new IllegalArgumentException("Parameter 'maxCharsPerLine' cannot be less then 1");


        StringBuilder textBuilder = new StringBuilder();
        StringBuilder wordBuilder = new StringBuilder();
        int i = 0;
        int index = 0;

        while (i < text.length() || wordBuilder.length() > 0) {
            char c = WHITESPACE;
            if (i < text.length()) {
                c = text.charAt(i);
                if (c != WHITESPACE && c != NEW_LINE) {
                    wordBuilder.append(c);
                    i++;
                    continue;
                }
            }

            if (index != 0 && wordBuilder.length() > 0 && index + 1 <= maxCharsPerLine) {
                textBuilder.append(c);
                index++;
            }

            if (wordBuilder.length() <= maxCharsPerLine) {
                if (index + wordBuilder.length() <= maxCharsPerLine) {
                    textBuilder.append(wordBuilder);
                    index += wordBuilder.length();
                    if (c == NEW_LINE)
                        textBuilder.append(c);
                    wordBuilder = new StringBuilder();
                    i++;
                } else {
                    textBuilder.setCharAt(textBuilder.length() - 1, NEW_LINE);
                }
            } else {
                textBuilder.append(wordBuilder.substring(0, maxCharsPerLine - index));
                textBuilder.append(NEW_LINE);
                String remain = wordBuilder.substring(maxCharsPerLine - index);
                wordBuilder = new StringBuilder();
                wordBuilder.append(remain);
            }

            if (textBuilder.length() > 0 && textBuilder.charAt(textBuilder.length() - 1) == NEW_LINE)
                index = 0;
        }

        textBuilder.append(wordBuilder);

        return textBuilder.toString();
    }

    private static final char NEW_LINE = '\n';
    private static final char WHITESPACE = ' ';
}