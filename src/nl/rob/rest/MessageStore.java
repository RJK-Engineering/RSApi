package nl.rob.rest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MessageStore {

    private String filePath = "messages.txt";
    private File file;
    private HashMap<Integer, Message> messages;
	private int nextId;

    public MessageStore() {
        this.file = new File(this.filePath);
        this.nextId = 1;
        this.loadMessages();
    }

    public void deleteMessage(int id) {
    	this.messages.remove(id);
    	this.storeMessages();
    }

    public void updateMessage(int id, String text) {
    	Message m = this.getMessage(id);
    	m.text = text;
    	this.messages.put(id, m);
    	this.storeMessages();
    }

    public Message createMessage(String text) {
    	Message m = new Message(this.nextId, text);
        this.messages.put(this.nextId, m);
        this.nextId++;
    	this.storeMessages();
    	return m;
    }

    public Message getMessage(int id) {
        return this.messages.get(id);
    }

    public Collection<Message> getMessages() {
        return this.messages.values();
    }

    private void loadMessages() {
        this.messages = new HashMap<Integer, Message>();
        try {
	        if (this.file.exists()) {
                List<String> lines = Files.readAllLines(this.file.toPath());
                this.nextId = Integer.parseInt(lines.remove(0));
                for (String line : lines) {
                	String[] fields = line.split(";", 2);
                	int id = Integer.parseInt(fields[0]);
                    this.messages.put(id, new Message(id, fields[1]));
                }
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void storeMessages() {
		try {
			if (! this.file.exists()) {
				this.file.createNewFile();
				this.nextId = 1;
			}
			PrintWriter writer = new PrintWriter(new FileWriter(this.file));
            writer.println(this.nextId);
            for (Message m : this.messages.values()) {
                writer.println(m.id + ";" + m.text);
            }
            writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
