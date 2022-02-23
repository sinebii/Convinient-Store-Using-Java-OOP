package models;
import common.User;
import enums.Gender;
import enums.Qualification;
import enums.Role;


public class Applicant extends User{
    private int age;
    private Qualification qualification;
    private Role role;

    public Applicant(String personName, String personLastName, String personAddress, Gender gender, int age, Qualification qualification, Role role) {
        super(personName, personLastName, personAddress, gender);
        this.age = age;
        this.qualification = qualification;
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
