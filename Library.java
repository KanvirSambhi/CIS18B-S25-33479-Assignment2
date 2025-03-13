import java.util.ArrayList;
import java.util.List;

public class Library
{
    private static Library instance;
    private List<Item> items;

    private Library()
    {
        items = new ArrayList<>();
    }

    public static Library getInstance()
    {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void listAvailableItems()
    {
        for (Item item : items)
        {
            if (item instanceof Book && ((Book) item).isBorrowed())
            {
                continue;
            }
            System.out.println(item.getTitle() + " (" + item.getPublicationYear() + ")");
        }
    }

    public Item findItemByTitle(String title)
    {
        for (Item item : items)
        {
            if (item.getTitle().equalsIgnoreCase(title))
            {
                return item;
            }
        }
        return null;
    }
}
