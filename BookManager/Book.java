package BookManager;

public class Book {
    private  String title;
    private  String author;
    private  int ISBN;
    private  int publicationYear ;
    private boolean isAvailable;

    public Book(String title,String author,int ISBN,int publicationYear){
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
        this.publicationYear=publicationYear;
        this.isAvailable=true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
