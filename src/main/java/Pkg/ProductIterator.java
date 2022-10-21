package Pkg;

/**
 * Iterator Design Pattern
 */
public class ProductIterator {
    public String name;
    public ProductIterator next;
    private ClassProductList classProductList;

    ProductIterator(String name) {
        this.name = name;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public ProductIterator Next() {
        return this.next;
    }

    public void moveToHead() {

    }

    public void Remove() {

    }
}
