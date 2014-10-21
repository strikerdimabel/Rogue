package client;

import main.UserGameInfo;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Client {
	
	private static final Client INSTANCE = new Client();
	
	private Client() {
		// TODO Initialization
		throw new NotImplementedException();
	}
	
	public static Client getInstance() {
		return INSTANCE;
	}
	
	public void sendUserGameInfo(UserGameInfo userGameInfo) {
		// TODO Send user game information
		throw new NotImplementedException();
	}
	
}
