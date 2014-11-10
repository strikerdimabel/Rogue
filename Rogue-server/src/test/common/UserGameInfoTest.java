package common;

import org.junit.Test;

import junit.framework.TestCase;

public class UserGameInfoTest extends TestCase {

	@Test
	public void testFromJson() {
		UserGameInfo userGameInfo = UserGameInfo.fromJson("{\"userName\":\"test\",\"finished\":false,\"level\":234}");
		assertEquals("test", userGameInfo.getUserName());
		assertEquals(false, userGameInfo.isFinished());
		assertEquals(234, userGameInfo.getLevel());
	}

}
