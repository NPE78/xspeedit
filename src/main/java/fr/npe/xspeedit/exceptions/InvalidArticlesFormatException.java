package fr.npe.xspeedit.exceptions;

public class InvalidArticlesFormatException extends Exception {

    public InvalidArticlesFormatException() {
        super("The description of the articles is invalid. Please check your input");
    }
}
