import java.util.List;

public interface DataService {
    void createUser(String firstName, String lastName, String patronymic, Boolean isTeacher);
    List<User> getAll(Boolean isTeacher);
    void deteteUser(Long id, Boolean isTeacher);
}
