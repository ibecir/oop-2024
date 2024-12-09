package ba.edu.ibu.week10.task1.classes;

import ba.edu.ibu.week10.task1.Annotations.UserPermission;

@UserPermission
public class RegularUser extends User{

    public RegularUser(String username) {
        super(username);
    }
}
