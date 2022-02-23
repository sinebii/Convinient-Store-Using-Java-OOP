package models;

import common.User;
import enums.Gender;
import enums.Role;

public class Staff extends User {
    private Role role;

    public Staff (){


    }

    public Staff(String personName, String personLastName, String personAddress, Gender gender,Role role) {
        super(personName, personLastName, personAddress, gender);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Staff{");
        sb.append("role=").append(role);
        sb.append('}');
        return sb.toString();
    }

}
