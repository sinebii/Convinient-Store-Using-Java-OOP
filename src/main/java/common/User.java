package common;

import enums.Gender;

public class User {

    private String personName;
    private String personLastName;
    private String personAddress;
    private Gender gender;

    public User(){

    }
    public User(String personName, String personLastName, String personAddress, Gender gender) {
        this.personName = personName;
        this.personLastName = personLastName;
        this.personAddress = personAddress;
        this.gender = gender;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("personName='").append(personName).append('\'');
        sb.append(", personLastName='").append(personLastName).append('\'');
        sb.append(", personAddress='").append(personAddress).append('\'');
        sb.append(", gender=").append(gender);
        sb.append('}');
        return sb.toString();
    }
}
