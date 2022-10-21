package Pkg;

public class Seller extends Person {

    ProductMenu menu;
    UserInfoItem userInfoItem;

    Seller(UserInfoItem userInfoItem) {
        this.userInfoItem = userInfoItem;
        menu = new ProductMenuFactory(userInfoItem);
    }

    public void showMenu() {
        System.out.println("---- Seller Show Menu ----");
        menu.showMenu();
    }

    @Override
    public void showAddButton() {

    }

    @Override
    public void showViewButton() {

    }

    @Override
    public void showRadioButton() {

    }

    @Override
    public void showLabels() {

    }

    @Override
    public ProductMenu createProductMenu() {
        return null;
    }

    public ProductMenu CreateProductMenu() {
        return null;
    }

}
