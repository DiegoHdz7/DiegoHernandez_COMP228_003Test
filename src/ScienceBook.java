public class ScienceBook extends Book{

    private final String GENRE = "Science";
    private final double DISCOUNT=0.1;
    private double discountedPrice;
    public ScienceBook(String title, String ISBN, String publisher, double price, int year) {
        super(title, ISBN, publisher, price, year);
        this.discountedPrice=(price-(price*DISCOUNT));
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
        this.discountedPrice=(price-(price*DISCOUNT));
    }

    @Override
    public double getPrice() {
        return this.discountedPrice;
    }

    @Override
    public String getGenre() {
        return this.GENRE;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", genre='" + GENRE + '\'' +
                ", DISCOUNT=" + DISCOUNT*100+"%" +
                ", Discounted price="  + discountedPrice;
    }


}
