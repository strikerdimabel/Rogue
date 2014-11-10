package server;

import common.UserGameInfo;

import dao.DAOFactory;

public class PushUserGameInfoProcessor implements Processor {
		
	@Override
	public void process(String mess) {
		UserGameInfo userGameInfo = UserGameInfo.fromJson(mess);
		DAOFactory.getDAO().saveGameInfo(userGameInfo);
	}

}
