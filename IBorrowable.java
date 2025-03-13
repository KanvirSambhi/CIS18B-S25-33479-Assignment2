interface IBorrowable
{
    // Shows whether an item is being borrowed or not
    void borrowItem(String borrower) throws Exception;
    void returnItem();
    boolean isBorrowed();
}