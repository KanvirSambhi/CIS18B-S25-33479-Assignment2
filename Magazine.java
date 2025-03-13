public class Magazine extends Item
{
    private int issueNumber;

    // Constructor for Magazine
    public Magazine(String title, int publicationYear, int issueNumber)
    {
        super(title, publicationYear);
        this.issueNumber = issueNumber;
    }

    // Getters for Issue number
    public int getIssueNumber()
    {
        return issueNumber;
    }
}
