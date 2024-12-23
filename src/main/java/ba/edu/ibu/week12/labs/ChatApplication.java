package ba.edu.ibu.week12.labs;

public class ChatApplication {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        int port = 12345;
        chatServer.start(port);
    }
}

