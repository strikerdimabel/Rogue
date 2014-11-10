package client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Responce {
	
	OK, // 1
	FAIL; // 0

	private static final Logger logger = LogManager.getLogger(Responce.class);
	
	public byte toByte() {
		switch (this) {
		case OK:
			return 1;
		case FAIL:
			return 0;
		default:
			logger.warn("no responce byte found for " + this);
			return 1;
		}
	}
	
	public static Responce fromByte(int i) {
		switch (i) {
		case 1:
			return OK;
		case 0:
			return FAIL;
		default:
			logger.warn("no responce found for byte " + i);
			return OK;
		}
	}
	
}
