import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean isEntered = false;

    public static void main(String[] args) {

        //Dependency inversion principle

        Sender emailSender = new EmailSender();
        Shop shop = Shop.getInstance();
        shop.addItem("Яблоко", 10);
        shop.addItem("Арбуз", 20);
        shop.addItem("Банан", 15);

        User userAlex = new User("Alex@gas.com", "Alex", "123123");
        User userJohn = new User("John@gmail.com", "John", "love");
        UserList.addUser(userAlex);
        UserList.addUser(userJohn);

        authorization();

        System.out.println("1. Всего пользователей" +
                "\n2. Отправить мой список покупок на e-mail");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                //принцип magics
                System.out.println(UserList.getUserListSize());
                break;
            case 2:
                System.out.println("Чтобы отправить список покупок введите логин и пароль: ");
                isEntered = false;
                //принцип DRY
                //Single-responsibility principle
                //Interface segregation principle
                emailSender.send(authorization());
        }
    }

    public static User authorization() {
        String login = null;
        boolean isExist = false;
        while (!isEntered) {
            String password;
            while (!isExist) {
                System.out.println("Введите имя пользователя: ");
                login = scanner.nextLine();
                if (UserList.getUserByLogin(login) != null) {
                    System.out.println("Пользователь " + login + " найден!");
                    isExist = true;
                } else {
                    System.out.println("Пользователь " + login + " не найден!");
                }
            }
            System.out.println("Введите пароль: ");
            password = scanner.nextLine();
            if (UserList.isRightPas(login, password)) {
                System.out.println("Пароль введён верно!");
                isEntered = true;
            } else {
                System.out.println("Пароль введён неверно!");
            }
        }
        return UserList.getUserByLogin(login);
    }
    //Liskov substitution principle заключается в том, что я не наследую ничего зря :)
}
