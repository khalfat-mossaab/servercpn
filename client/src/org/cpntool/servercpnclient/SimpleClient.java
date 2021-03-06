package org.cpntool.servercpnclient;

public class SimpleClient {

	public static void main(String[] args) {
		Server server = new Server(Integer.parseInt(args[0]),"localhost");
		
		if (server.connect()) {
			server.startSimulation();
			
			int i = 0;
			boolean stopped = false;
			
			while ((!stopped) && (i<5)) {
			
				int pressure = server.getPressure();
				int torque = server.getTorque();
				
				System.out.println("Pressure : " + pressure);
				System.out.println("Torque : " + pressure);
				
				if (pressure < 0 || torque <0) {
					stopped = true;
				}
				
				// consider using Thread.sleep here in order not to poll too often
				i++;
			}
			
			if (!stopped) {
				server.stopSimulation();
			}
		}
	}
}