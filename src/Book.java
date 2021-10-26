abstract class Book {
    private String title;
    private String ISBN;
    private String publisher;
    protected double price;
    private String genre;
    private int year;

    public Book(String title, String ISBN, String publisher, double price, int year) {
        this.title = title;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.price = price;
        this.year = year;
    }

    protected String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    protected String getISBN() {
        return ISBN;
    }

    protected void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    protected String getPublisher() {
        return publisher;
    }

    protected void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    protected int getYear() {
        return year;
    }

    protected void setYear(int year) {
        this.year = year;
    }

    public abstract void setPrice(double price);
    public abstract double getPrice();
    public abstract String getGenre ();

    @Override
    public String toString() {
        return
                "title='" + title +
                ", ISBN='" + ISBN +
                ", publisher='" + publisher +
                ", price=" + price +
                ", year=" + year ;
    }
}
