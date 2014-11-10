package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.UserGameInfo;

public class WrongClient {
	
	private static final WrongClient INSTANCE = new WrongClient();
	public static final int PORT = 7777;
    private static final Logger logger = LogManager.getLogger(Client.class);

	private Socket client;
	private PrintStream ps;
	private InputStream is;
	
	private WrongClient() {
		init();
	}
	
	public static WrongClient getInstance() {
		return INSTANCE;
	}
	
	private void init() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            client = new Socket(localhost, PORT);
            ps = new PrintStream(new BufferedOutputStream(client.getOutputStream()),true);
            is=new BufferedInputStream(client.getInputStream());
        } catch (UnknownHostException e) {
        	logger.error("Connection error: unknown host.\n");
        } catch (IOException e) {
        	logger.error("Connection error: can't connect to server.\n");
        }
	}

	public Responce sendUserGameInfo(UserGameInfo userGameInfo) {
		if (client.isClosed()) {
			return Responce.FAIL;
		}
    	ps.println(1234);
    	ps.println(userGameInfo.toJson());
    	try {
			return Responce.fromByte(is.read());
		} catch (IOException e) {
			logger.error(e);
			return Responce.FAIL;
		}
	}
	
	public void close() {
		try {
			ps.close();
			is.close();
		} catch (Exception e) {
		}
	}

}
