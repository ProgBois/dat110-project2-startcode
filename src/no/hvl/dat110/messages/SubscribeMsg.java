package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	// message sent from client to subscribe on a topic 

	// TODO:
	// Implement object variables - a topic is required
	private String subscribe;
	// Constructor, get/set-methods, and toString method
	// as described in the project text
	public SubscribeMsg(String user, String subscribe){
		super(MessageType.SUBSCRIBE, user);
		this.subscribe = subscribe;	
	}
	public String getSubscribeTo() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	
	@Override
	public String toString() {
		return "SubscribeMsg [subscribe=" + subscribe + "]";
	}
	
	
}
