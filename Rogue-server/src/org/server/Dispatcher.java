package server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dispatcher implements Runnable {

	private final Socket socket;
	private static final Logger logger = LogManager.getLogger(Dispatcher.class);
	
	public Dispatcher(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try (Scanner scn = new Scanner(new InputStreamReader(socket.getInputStream()));){
			while (scn.hasNextLine()) {
				logger.info("message");
				try {
					int type = Integer.parseInt(scn.nextLine());
					String messString = scn.nextLine();
					Processor processor = Processors.getProcessor(RequestType.fromInt(type));
					if (processor == null) {
						logger.error("no processor found for " + type + " request type");
						Responser.sendFail(socket);
						return;
					}
					processor.process(messString);
					logger.info("message processed: " + messString);
					Responser.sendOk(socket);
				} catch (Exception e) {
					logger.error("", e);
					Responser.sendFail(socket);
				}
			}
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
			}
		}
	}

}
