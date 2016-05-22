package testpack;

public class Item {
	private int itemId;
	private String itemName;
	private int QTY;
	private int userId;
	public Item() {
		super();
	}
	public Item(int itemId, String itemName, int qTY, int userId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		QTY = qTY;
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQTY() {
		return QTY;
	}
	public void setQTY(int qTY) {
		QTY = qTY;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
