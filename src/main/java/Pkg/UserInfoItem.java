package Pkg;

public class UserInfoItem {
	private String name;
	private int userType;

	public String getName() {
		return name;
	}

	public int getUserType() {
		return userType;
	}

	public String getUserTypeString() {
		if (userType == 0) {
			return "buyer";
		}

		return "seller";
	}

	UserInfoItem(String name, int userType) {
		this.name = name;
		this.userType = userType;
	}
}
