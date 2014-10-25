package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	
	public static final int PORT = 7777;

	private ExecutorService pool= Executors.newCachedThreadPool();
    private ServerSocket server;
    private boolean connected = false;
	
    public static void main(String[] args) {
    	Server server = new Server();
    	server.connect(PORT);
    	server.start();
    }
    
    private void start() {
    	if (!connected) {
    		System.err.println("Server is not connected.");
    		return;
    	}
    	new Thread(new ServerThread()).start();
	}

	public void connect(int port) {
        try {
            server = new ServerSocket(7777);
        }
        catch(IOException e) {
            System.err.println("Port 7777 is in use already.");
            return;
        }
        connected = true;
    }
	
	private class ServerThread implements Runnable {

	    @Override
		public void run() {
	        while (true) {
	            pool.execute(new Dispatcher(server));
	        }
		}
	    		
	}

}
