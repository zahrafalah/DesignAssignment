package Pkg;

public abstract class Person {

    ProductMenu theProductMenu = null;

    public abstract void showMenu();

    public abstract void showAddButton();

    public abstract void showViewButton();

    public abstract void showRadioButton();

    public abstract void showLabels();

    public abstract ProductMenu createProductMenu();

}
