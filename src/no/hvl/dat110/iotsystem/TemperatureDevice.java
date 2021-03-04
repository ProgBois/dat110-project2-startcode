package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();
		
		String topic = Common.TEMPTOPIC;
		int port = Common.BROKERPORT;
		String server = Common.BROKERHOST;
		
		// create a client object and use it to
		Client client = new Client("TemperaturDevice", server, port);
		
		// - connect to the broker
		client.connect();
		System.out.println("Temperature device starting ... ");
		
		// - publish the temperature(s)
		for(int i = 0; i < COUNT; i++) {
			int temp = sn.read();
			client.publish(topic, "Temperature : " + temp);
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// - disconnect from the broker
		client.disconnect();

		System.out.println("Temperature device stopping ... ");
	}
}
