public class Book extends Item implements IBorrowable
{
    // Private variables to be accessed within Book.java for constructor
    private String author;
    private String ISBN;
    private String borrower;

    // Constructor for Book
    public Book(String title, int publicationYear, String author, String ISBN)
    {
        super(title, publicationYear);
        this.author = author;
        this.ISBN = ISBN;
        this.borrower = null;
    }

    // Getter for author
    public String getAuthor()
    {
        return author;
    }

    // Getter for ISBN
    public String getISBN()
    {
        return ISBN;
    }

    // Compile time checking
    @Override
    public void borrowItem(String borrower) throws Exception
    {
        if (this.borrower != null)
        {
            throw new Exception("Book is already borrowed.");
        }
        this.borrower = borrower;
    }

    // Compile time checking
    @Override
    public void returnItem()
    {
        this.borrower = null;
    }

    @Override
    public boolean isBorrowed()
    {
        return borrower != null;
    }
}