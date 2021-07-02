import java.util.HashMap;
import java.util.Map;

public class UserList {
    private static Map<String, User> userList = new HashMap<>();

    public static void addUser(User user) {
        userList.put(user.getLogin(), user);
    }

    public static void delUser(User user) {
        userList.remove(user.getLogin());
    }

    public static User getUserByLogin(String login) {
        return userList.get(login);
    }

    public static boolean isRightPas(String login, String password) {
        return userList.get(login).getPassword().equals(password);
    }

    public static int getUserListSize(){
        return userList.size();
    }
}
