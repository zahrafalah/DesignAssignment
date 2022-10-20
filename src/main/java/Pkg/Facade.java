package Pkg;

public class Facade {
	Facade() {
	}

	private int userType = -1;

	private UserInfoItem userInfoItem;

	private Product theSelectedProduct;

	private int nProductCategory;

	private ClassProductList theProductList;

	private Person person;

	public Person getPerson() {
		return this.person;
	}

	public int login() {
		// create the login form
		LoginForm form = new LoginForm(this);
		form.setSize(400, 200);
		form.setVisible(true);

		System.out.println("form created");

		// wait for the user to submit the form so we can get the user info
		waiter();

		// return 0 if login failed
		if (userType < 0) {
			System.out.println("login failed");
			return 0;
		}

		System.out.println("login successful");

		// create the person based on the user type
		if (this.userInfoItem.getUserType() == 0) {
			this.person = new Buyer();
		} else {
			this.person = new Seller();
		}

		// return 1 if login was ok
		return 1;
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {

	}

	public void createProductList() {

	}

	public void attachProductToUser() {

	}

	public int selectProduct() {
		return 0;
	}

	public void productOperation() {

	}

	public void createUser(String userName, int userType) {
		userInfoItem = new UserInfoItem(userName, userType);
	}

	public synchronized void waiter() {
		while (userType == -1) {
			try {
				wait();
			} catch(InterruptedException e ) {
				e.printStackTrace();
			}
		}
		System.out.println("facade user type has been set - " + userType);
	}

	public synchronized void setUserType(int userType, String userName) {
		this.userType = userType;
		createUser(userName, userType);
		notify();
	}
}
