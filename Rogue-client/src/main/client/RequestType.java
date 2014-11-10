package client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum RequestType {
	
	PUSH_USER_GAME_INFO; // 1
		
	private static final Logger logger = LogManager.getLogger(RequestType.class);

	public static RequestType fromInt(int type) {
		switch (type) {
		case 1:
			return PUSH_USER_GAME_INFO;
		default:
			return null;
		}
	}
	
	public int toInt() {
		switch (this) {
		case PUSH_USER_GAME_INFO:
			return 1;
		default:
			logger.warn("no request int found for " + this);
			return -1;
		}
	}
	
}
