import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    private final List<Teacher> teachers;

    public TeacherService(){
        this.teachers = new ArrayList<>(); 
    }

    public void createTeacher(String firstName, String lastName, String patronymic) {
        Long id = 0L;
        for (Teacher user : this.teachers){
            if (id < user.getTeacherID()){
                id = user.getTeacherID();
            }
        }
        this.teachers.add(new Teacher(firstName, lastName, patronymic, ++id));
        
    }

    public void deteteTeacher(Long id) {
        for (Teacher user : this.teachers){
            if (id.equals(((Teacher)user).getTeacherID())){
                this.teachers.remove(user);
            }
        }
    }
    
    public List<Teacher> getAllTeachers() {
        List<Teacher> users = new ArrayList<>(); 
            for (Teacher user : this.teachers){
                users.add(user);
            }
        return users;
    }

    public Teacher getTeacherByID (Long id) throws Exception{
        List<Teacher> teachs = getAllTeachers();
        for (Teacher teach: teachs){
            if (id == teach.getTeacherID()){
                return teach;
            }
        }
        throw new Exception("Wrong id");
    }
}
