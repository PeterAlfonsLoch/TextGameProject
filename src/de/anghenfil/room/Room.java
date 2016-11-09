package de.anghenfil.room;

public class Room {
	private int roomID;
	private int nextRoomN;
	private int nextRoomS;
	private int nextRoomE;
	private String roomDescription;
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public int getNextRoomN() {
		return nextRoomN;
	}
	public void setNextRoomN(int nextRoomN) {
		this.nextRoomN = nextRoomN;
	}
	public int getNextRoomS() {
		return nextRoomS;
	}
	public void setNextRoomS(int nextRoomS) {
		this.nextRoomS = nextRoomS;
	}
	public int getNextRoomE() {
		return nextRoomE;
	}
	public void setNextRoomE(int nextRoomE) {
		this.nextRoomE = nextRoomE;
	}
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
}
