package nl.rob.rest;

public class MessageStoreTest {

	public static void main(String[] args) {
		System.out.println("Start");
		MessageStore ms = new MessageStore();
        for (Message m : ms.getMessages()) {
            System.out.println(m.id + " " + m.text);
        }
        ms.createMessage("Hi");
        ms.createMessage("Hi2");
        ms.deleteMessage(2);
        ms.storeMessages();
	}

}
