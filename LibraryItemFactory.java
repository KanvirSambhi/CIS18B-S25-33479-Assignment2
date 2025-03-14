public class LibraryItemFactory
{
    public static Item createItem(String type, String title, int publicationYear, String extraData)
    {
        if (type.equalsIgnoreCase("book"))
        {
            return new Book(title, publicationYear, extraData, "Unknown-ISBN");
        }

        else if (type.equalsIgnoreCase("magazine"))
        {
            return new Magazine(title, publicationYear, Integer.parseInt(extraData));
        }

        return null;
    }
}