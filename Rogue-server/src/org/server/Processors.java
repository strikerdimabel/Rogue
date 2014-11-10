package server;

import java.util.EnumMap;

public class Processors {
	
	private static EnumMap<RequestType, Processor> processors = new EnumMap<>(RequestType.class);
	
	static {
		processors.put(RequestType.PUSH_USER_GAME_INFO, new PushUserGameInfoProcessor());
	}
	
	public static Processor getProcessor(RequestType rt) {
		return processors.get(rt);
	}
	
	static void setProcessor(RequestType rt, Processor processor) {
		processors.put(rt, processor);
	}
	
}
