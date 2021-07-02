import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Item> purchase = new ArrayList<>();
    private String login;
    private String password;
    private String email;

    public User(String email, String login, String password) {
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void addToPurchase(Item item){
        purchase.add(item);
    }
    public void delFromPurchase(Item item){
        purchase.remove(item);
    }

    public List<Item> getPurchase(){
        return purchase;
    }
}
