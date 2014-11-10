package server;

import junit.framework.TestCase;

import org.junit.Test;

import common.UserGameInfo;

public class ServerTest extends TestCase {

	private final Server server = new Server();
	
	@Test
	public void testConnect() {
		server.start();
		Client client = Client.getInstance();
		WrongClient wClient = WrongClient.getInstance();
		UserGameInfo userGameInfo = new UserGameInfo();
		userGameInfo.setUserName("test");
		userGameInfo.setAttack(12);
		assertEquals(Responce.OK, client.sendUserGameInfo(userGameInfo));
		assertEquals(Responce.FAIL, wClient.sendUserGameInfo(userGameInfo));
	}

}
