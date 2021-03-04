package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

	// message sent from client to create topic on the broker
	
	// Implement object variables - a topic is required
	private String topicSlettet;
	
	// Constructor, get/set-methods, and toString method
	// as described in the project text
	public DeleteTopicMsg(String user, String topicSlettet) {
		super(MessageType.DELETETOPIC, user);
		this.topicSlettet = topicSlettet;
	}

	public String getTopicSlettet() {
		return topicSlettet;
	}

	public void setTopicSlettet(String topicSlettet) {
		this.topicSlettet = topicSlettet;
	}

	@Override
	public String toString() {
		return "DeleteTopicMsg [topicSlettet=" + topicSlettet + "]";
	}
	
	
	
}
