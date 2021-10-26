public class ChildrenBook extends Book{
    private final String GENRE = "Children";
    public ChildrenBook(String title, String ISBN, String publisher, double price, int year) {
        super(title, ISBN, publisher, price, year);
    }

    @Override
    public void setPrice(double price) {
        this.price=price;

    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getGenre() {
        return GENRE;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", genre='" + GENRE;
    }
}
