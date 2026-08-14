public class ConsoleNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("[SYSTEM NOTIFICATION]: " + message);
    }
}