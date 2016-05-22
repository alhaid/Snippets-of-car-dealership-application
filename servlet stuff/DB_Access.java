package testpack;

import java.sql.*;
import java.util.ArrayList;

public class DB_Access {
	private String url = "jdbc:mysql://localhost:3306/test";
	private String driver = "com.mysql.jdbc.Driver";
	private String uname = "root";
	private String upass = "";
	
	Connection con;
	PreparedStatement pst;
	///public DB_Access() {}
	public DB_Access() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uname, upass);
		} catch(Exception e){e.printStackTrace();}
	}
	
	public User validateLogin(String loginName, String loginPass) {
		User u = null;
		String sql = "select uid, LoginName, Name  from TUser01 " +
				"where LoginName = ? and LoginPass = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, loginName);
			pst.setString(2, loginPass);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				// user data is valid
				u = new User(
						rs.getInt(1), 
						rs.getString(2),
						"",
						rs.getString(3)
						);
			}
		} catch (Exception e) {e.printStackTrace();}
		return u;
	}
	public boolean createAccount(String loginName, String loginPass, String fullName) {
		boolean success = true;
		String sql = "insert into TUser01 (LoginName, Name, LoginPass) values (?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, loginName);
			pst.setString(2, fullName);
			pst.setString(3, loginPass);
			pst.executeUpdate();
		} catch(Exception e) {success = false; e.printStackTrace();}
		return success;
	}
	
	public ArrayList<Item> getAllUserItems(int userId) {
		ArrayList<Item> items = new ArrayList<Item>();
		
		String sql = "select iid, ItemName, Qty, uid from TItems01 where uid = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Item i = new Item(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4));
				items.add(i);
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return items;
	}
	
	public boolean addNewItem(String itemName, int qty, int uid) {
		boolean success = true;
		String sql = "insert into TItems01 (ItemName, Qty, uid) " +
						" values (?, ?, ?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,  itemName);
			pst.setInt(2, qty);
			pst.setInt(3, uid);
			pst.executeUpdate();
		}catch(Exception e) {success = false; e.printStackTrace();}
		return success;
	}
	
	public Item getItemDetails(int iid, int uid) {
		Item i = null;
		String sql = "select iid, ItemName, Qty, uid from TItems01 where " +
						"iid = ? and uid = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, iid);
			pst.setInt(2, uid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				i = new Item(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4));
			}
		}catch(Exception e) {e.printStackTrace();}
		return i;
	}
	
	public boolean EditItemInfo (String itemName, String itemQTY, String itemid, String userId){
		boolean success = true;

		String sql = "update TItems01 set ItemName = ?, Qty = ? where iid = ? and uid = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, itemName);
			pst.setString(2, itemQTY);
			pst.setString(3, itemid);
			pst.setString(4, userId);
			pst.executeUpdate();		
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean DeleteItem (String itemID, String userID){
		boolean success = true;
			
			String sql = "delete from TItems01 where iid = ? and uid = ?";
			try{
				pst = con.prepareStatement(sql);
				pst.setString(1, itemID);
				pst.setString(2, userID);
				pst.executeUpdate();
			}catch(SQLException e){
				success = false;
			}
		
		return success;
	}
	
	public boolean UpdateUserName(String userName, String loginName, String userID){
		boolean success = true;
		
		String sql = "update tuser01 set LoginName = ?, Name = ? where uid = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, loginName);
			pst.setString(2, userName);
			pst.setString(3, userID);
			pst.executeUpdate();
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean checkLoginName (String loginName){
		boolean success = true;
		String sql = "Select * from tuser01 where LoginName = '" + loginName + "'";
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			int n = 0;
			if(rs.next()) {
				success = false;
			}
		}catch(Exception e) {e.printStackTrace();}
		return success;
	}
	
	public String password(String userID){
		String password = "";
		
		String sql = "select LoginPass from tuser01 where uid = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, userID);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				password = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return password;
	}
	
	public boolean updatePassword(String loginPass,String userID){
		boolean success = true;
		
		String sql = "update tuser01 set LoginPass = ? where uid = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, loginPass);
			pst.setString(2, userID);
			pst.executeUpdate();
		} catch (SQLException e) {
			success = false;
			e.printStackTrace();
		}
		
		return success;
	}
}






