package nl.rob.rest;

public class Message {

    public final int id;
    public String text;

    public Message(int id, String text) {
        this.id = id;
        this.text = text;
    }
    
    public void setText(String text) {
    	this.text = text;
    }
}
