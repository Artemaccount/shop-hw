public class EmailSender implements Sender{

    @Override
    public void send(User user) {
        System.out.println("Отправлено сообщение на " + user.getEmail());
    }

    public void sendByEmail(String email){
        System.out.println("`Чёто там` отправлено на " + email);
    }
}
