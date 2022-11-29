import java.util.ArrayList;
import java.util.List;

public class UserService implements DataService{

    private final List<User> users;

    public UserService(){
        this.users = new ArrayList<>(); 
    }

    @Override
    public void createUser(String firstName, String lastName, String patronymic, Boolean isTeacher) {
        Long id = 0L;
        if (isTeacher == false){
            for (User user : this.users){
                if (user instanceof Student){
                    if (id < ((Student)user).getStudentID()){
                        id = ((Student)user).getStudentID();
                    }
                }
            }
            this.users.add(new Student(firstName, lastName, patronymic, ++id));
        } else {
            for (User user : this.users){
                if (user instanceof Teacher){
                    if (id < ((Teacher)user).getTeacherID()){
                        id = ((Teacher)user).getTeacherID();
                    }
                }
            }
            this.users.add(new Teacher(firstName, lastName, patronymic, ++id));
        }
    }

    @Override
    public List<User> getAll(Boolean isTeacher) {
        List<User> uses = new ArrayList<>(); 
        if (isTeacher){
            for (User user : this.users){
                //System.out.println("+++" + user.toString());
                if (user instanceof Teacher){
                    //System.out.println(user.toString());
                    uses.add(new Teacher(((Teacher)user).getFirstName(),((Teacher)user).getLastName(),((Teacher)user).getPatronymic(),((Teacher)user).getTeacherID()));
                }
            }
        } else if (!isTeacher){
            for (User user : this.users){
                if (user instanceof Student){
                    //System.out.println(user.toString());
                    uses.add((Student)user);
                }
            }
        }
        return uses;
    }

    @Override
    public void deteteUser(Long id, Boolean isTeacher) {
        if (isTeacher == false){
            for (User user : this.users){
                if (id.equals(((Student)user).getStudentID())){
                    this.users.remove(user);
                }
            }
        } else {
            for (User user : this.users){
                if (id.equals(((Teacher)user).getTeacherID())){
                    this.users.remove(user);
                }
            }
        }
    }


    public Teacher getTeacherByID (Long id) throws Exception{
        List<User> teachers = getAll(true);
        for (User teach: teachers){
            if (teach instanceof Teacher){
                if (id == ((Teacher)teach).getTeacherID()){
                    return (Teacher)teach;
                }
            }
        }
        throw new Exception("Wrong id");
    }

    public Student getStudentByID (Long id) throws Exception{
        List<User> students = getAll(false);
        for (User stud: students){
            if (stud instanceof Student){
                if (id == ((Student)stud).getStudentID()){
                    return (Student)stud;
                }
            }
        }
        throw new Exception("Wrong id");
    }

    public List<Student> getAllStudents() {
        List<Student> uses = new ArrayList<>(); 
            // for (User user : this.users){
            //     if (user instanceof Teacher){
            //         //System.out.println(user.toString());
            //         uses.add(user);
            //     }
            // }
            for (User user : users){
                if (user instanceof Student){
                    //System.out.println(user.toString());
                    uses.add((Student) user);
                }
            }
        return uses;
    }

}
