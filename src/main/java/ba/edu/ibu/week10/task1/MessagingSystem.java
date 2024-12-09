package ba.edu.ibu.week10.task1;

import ba.edu.ibu.week10.task1.Annotations.CanSendMessage;
import ba.edu.ibu.week10.task1.Annotations.RequiresPermission;
import ba.edu.ibu.week10.task1.Annotations.UserPermission;
import ba.edu.ibu.week10.task1.classes.AdminUser;
import ba.edu.ibu.week10.task1.classes.RegularUser;
import ba.edu.ibu.week10.task1.classes.User;

import java.lang.reflect.Method;

public class MessagingSystem {

    public static void main(String[] args) throws NoSuchMethodException {
        // Create instances of users
        RegularUser regularUser = new RegularUser("osman1982");
        AdminUser adminUser = new AdminUser("mustafa77");

        // Messaging system instance
        MessagingSystem messagingSystem = new MessagingSystem();

        // Demonstrate sending messages
        messagingSystem.sendMessage(regularUser); // Restricted
        messagingSystem.sendMessage(adminUser);  // Allowed
    }

    @CanSendMessage
    @RequiresPermission(level = "admin")
    public void sendMessage(User user) throws NoSuchMethodException {

        // getMethod reflection function requires the name of the searched method and
        // parameters that method has (because of the method overloading concept)
        Method method = this.getClass().getMethod("sendMessage", User.class);
        if(!method.isAnnotationPresent(CanSendMessage.class)){
            System.out.println("This method is not allowed to send messages.");
            return;
        }

        UserPermission userPermission = user.getClass().getAnnotation(UserPermission.class);
        if(!userPermission.level().equals("admin")){
            System.out.println("User " + user.getUsername() + " is not allowed to send messages");
        }
        else{
            System.out.println("Admin user " + user.getUsername() + " sent a message");
        }
    }
}
