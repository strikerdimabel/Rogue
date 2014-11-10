package main;

import com.google.gson.Gson;

public class UserGameInfo {
	
	// TODO Fields and getters and setters

	private static final Gson GSON = new Gson();

	private String userName; 
	private boolean finished;
	private int level; 
	private int hp; 
	private int mana;
	private int satiety; 
	private int attack;
	private int defense; 
	private int vision;
	private double hpReg; 
	private double manaReg; 
	private int experience;
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the finished
	 */
	public boolean isFinished() {
		return finished;
	}

	/**
	 * @param finished the finished to set
	 */
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the mana
	 */
	public int getMana() {
		return mana;
	}

	/**
	 * @param mana the mana to set
	 */
	public void setMana(int mana) {
		this.mana = mana;
	}

	/**
	 * @return the satiety
	 */
	public int getSatiety() {
		return satiety;
	}

	/**
	 * @param satiety the satiety to set
	 */
	public void setSatiety(int satiety) {
		this.satiety = satiety;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return the vision
	 */
	public int getVision() {
		return vision;
	}

	/**
	 * @param vision the vision to set
	 */
	public void setVision(int vision) {
		this.vision = vision;
	}

	/**
	 * @return the hpReg
	 */
	public double getHpReg() {
		return hpReg;
	}

	/**
	 * @param hpReg the hpReg to set
	 */
	public void setHpReg(double hpReg) {
		this.hpReg = hpReg;
	}

	/**
	 * @return the manaReg
	 */
	public double getManaReg() {
		return manaReg;
	}

	/**
	 * @param manaReg the manaReg to set
	 */
	public void setManaReg(double manaReg) {
		this.manaReg = manaReg;
	}

	/**
	 * @return the experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @param experience the experience to set
	 */
	public void setExperience(int experience) {
		this.experience = experience;
	}

	public static UserGameInfo fromJson(String json) {
		return GSON.fromJson(json, UserGameInfo.class);
	}
	
	public String toJson() {
		return GSON.toJson(this);
	}
	
	@Override
	public String toString() {
		return toJson();
	}
	
}
