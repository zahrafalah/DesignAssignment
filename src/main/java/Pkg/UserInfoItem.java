package Pkg;

public class UserInfoItem {
    private final String name;
    private final int userType;

    UserInfoItem(String name, int userType) {
        this.name = name;
        this.userType = userType;
    }

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
}
