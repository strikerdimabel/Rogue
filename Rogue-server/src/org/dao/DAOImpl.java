package dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.Responser;

import common.UserGameInfo;

public class DAOImpl implements DAO {

	private static final Logger logger = LogManager.getLogger(Responser.class);
	
	public DAOImpl() {
		// TODO Initialization
		logger.warn("dao.DAOImpl() is not implemented");
	}
	
	@Override
	public void saveGameInfo(UserGameInfo userGameInfo) {
		// TODO Auto-generated method stub
		logger.warn("dao.DAOImpl.saveGameInfo(UserGameInfo userGameInfo) is not implemented");
	}

	@Override
	public List<UserGameInfo> getUserGameInfo(String userName) {
		// TODO Auto-generated method stub
		logger.warn("dao.DAOImpl.getUserGameInfo(String userName) is not implemented");
		return null;
	}

}
