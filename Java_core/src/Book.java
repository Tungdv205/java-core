public class Book {
    private String title;
    private String author;
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isBlank()) {
            this.title = title;
        } else {
            System.out.println("Khong hop le vui long nhap lai");
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.isBlank()) {
            this.author = author;
        } else {
            System.out.println("Khong hop le vui long nhap lai");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Gia khong hop le!");
        }
    }

    public Book(){
    }
    public Book(String title){
        this(title,"Nguyen Van A",12.500);
    }
    public Book(String title, String author ){
        this(title, author,13.500);
    }
    public Book(String title,String author, double price){
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }


}