package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
		String server = Common.BROKERHOST;
		int port = Common.BROKERPORT;
		String topic = Common.TEMPTOPIC;
		
		// create a client object and use it to
		Client client = new Client("DisplayDevice", server, port);
		
		// - connect to the broker
		client.connect();
		
		// - create the temperature topic on the broker
		client.createTopic(topic);
		
		// - subscribe to the topic
		client.subscribe(topic);
		
		// - receive messages on the topic
		for(int i = 0; i < COUNT; i++) {
			PublishMsg msg = (PublishMsg) client.receive();
			System.out.println("Temperature recieved : " + msg.getMessage());
		}
		
		// - unsubscribe from the topic
		client.unsubscribe(topic);
		
		// - disconnect from the broker
		client.disconnect();
		
		System.out.println("Display stopping ... ");
		
	}
}
