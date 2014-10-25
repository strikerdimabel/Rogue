package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
	
	public static final int PORT = 7777;

	private final ExecutorService pool= Executors.newCachedThreadPool();
    private ServerSocket server;
    private boolean connected = false;
    private static final Logger logger = LogUtil.getLogger(Server.class);
	
    public static void main(String[] args) {
    	Server server = new Server();
    	server.connect(PORT);
    	server.start();
    }
    
    private void start() {
    	if (!connected) {
    		logger.log(Level.SEVERE, "server is not connected");
    		return;
    	}
    	new Thread(new ServerThread()).start();
	}

	public void connect(int port) {
        try {
            server = new ServerSocket(port);
        }
        catch(IOException e) {
    		logger.log(Level.SEVERE, "port " + port + " is already used");
            return;
        }
        connected = true;
    }
	
	private class ServerThread implements Runnable {

	    @Override
		public void run() {
	        while (true) {
	            try {
					pool.execute(new Dispatcher(server.accept()));
				} catch (IOException e) {
		    		logger.log(Level.SEVERE, "error while processing request", e);
				}
	        }
		}
	    		
	}

}
