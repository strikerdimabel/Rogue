package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server {
	
	public static final int PORT = 7777;

	private final ExecutorService pool= Executors.newCachedThreadPool();
    private ServerSocket server;
    private static final Logger logger = LogManager.getLogger(Server.class);
	
    public static void main(String[] args) {
    	Server server = new Server();
    	server.start();
    }
    
    public void start() {
    	if (!connect(PORT)) {
    		logger.error("server is not connected");
    		return;
    	}
    	new Thread(new ServerThread()).start();
	}

	private boolean connect(int port) {
        try {
            server = new ServerSocket(port);
        }
        catch(IOException e) {
    		logger.error("port " + port + " is already used");
            return false;
        }
        return true;
    }
	
	private class ServerThread implements Runnable {

	    @Override
		public void run() {
	        while (true) {
	            try {
					logger.info("accept");
					pool.execute(new Dispatcher(server.accept()));
				} catch (IOException e) {
					if (!server.isClosed()) {
						logger.error("error while processing request", e);
					}
				}
	        }
		}
	    		
	}

	public void stop() {
		try {
			server.close();
		} catch (Exception e) {
		}
	}

}
