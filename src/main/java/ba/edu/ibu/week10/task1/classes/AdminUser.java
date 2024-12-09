package ba.edu.ibu.week10.task1.classes;

import ba.edu.ibu.week10.task1.Annotations.UserPermission;

@UserPermission(level = "admin")
public class AdminUser extends User{
    public AdminUser(String username){
        super(username);
    }
}
