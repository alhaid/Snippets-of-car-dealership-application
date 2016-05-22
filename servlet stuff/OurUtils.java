package testpack;

public class OurUtils {
	public static boolean validateTextInput(String val) {
		boolean isValid = true;
		if(val == null || val.trim().equals("")) isValid = false;
		return isValid;
	}
	
	public static String validateMessage(String val) {
		if(val == null) return "";
		else return val;
	}
	public static boolean validTextInput(String text) {
		boolean valid = true;
		if(text.trim().equals("")) valid = false;
		if(text.indexOf("'")!=-1) valid = false;
		// keep on building the validation rules
		return valid;
	}
	public static boolean letters(String characters){
		boolean success = true;
		if(!characters.isEmpty()){
			for (int i = 0; i < characters.length(); i++){
				if(!Character.isLetter(characters.charAt(i))){
					success = false;
				}
			}
		}else{
			success = false;
		}
		return success;
	}
	public static boolean numbers(String number){
		boolean success = true;
		if(!number.isEmpty()){
			for (int i = 0; i < number.length(); i++){
				if(!Character.isDigit(number.charAt(i))){
					success = false;
				}
			}
		}else{
			success = false;
		}
		return success;
	}
}
