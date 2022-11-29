public class User {
    private String firstName;
    private String lastName;
    private String patronymic;

    public User(String firstName, String lastName, String patronymic){
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public String getPatronymic() {
        return patronymic;
    }
    @Override
    public String toString() {
        return "Firstname: " + this.firstName + ", lastname: " + this.lastName + ", pstronymic: " + this.patronymic;
    }

}
