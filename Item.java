public abstract class Item
{
    protected String title;
    protected int publicationYear;

    // Constructor for Item
    public Item(String title, int publicationYear)
    {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Getter for Title
    public String getTitle()
    {
        return title;
    }

    // Getter for publication year
    public int getPublicationYear() {
        return publicationYear;
    }
}