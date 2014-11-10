package server;

import java.io.OutputStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Responser {

	private static final Logger logger = LogManager.getLogger(Responser.class);
	
	public static void sendOk(Socket socket) {
		try {
			OutputStream os = socket.getOutputStream();
			os.write(Responce.OK.toByte());
		} catch (Exception e) {
			logger.error("", e);
		}
	}
	
	public static void sendFail(Socket socket) {
		try {
			OutputStream os = socket.getOutputStream();
			os.write(Responce.FAIL.toByte());
		} catch (Exception e) {
			logger.error("", e);
		}
	}
	
}
