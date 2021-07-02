import java.util.ArrayList;
import java.util.List;

public class Shop {

    private static List<Item> itemList = new ArrayList<>();

    private Shop(){
    }
    private static Shop shop = null;

    public static Shop getInstance() {
        if (shop == null) shop = new Shop();
        return shop;
    }

    public void addItem(String name, int price){
        Item item = new Item(name, price);
        itemList.add(item);
    }

    public void delItem(Item item){
        itemList.remove(item);
    }
}
