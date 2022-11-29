import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService {
    private final List<Student> students;

    public StudentService(){
        this.students = new ArrayList<>(); 
    }

    public void createStudent(String firstName, String lastName, String patronymic) {
        Long id = 0L;
        for (Student user : this.students){
            if (id < ((Student)user).getStudentID()){
                id = ((Student)user).getStudentID();
            }
        }
        this.students.add(new Student(firstName, lastName, patronymic, ++id));
        
    }

    public void deteteStudent(Long id) {
        for (Student user : this.students){
            if (id.equals(((Student)user).getStudentID())){
                this.students.remove(user);
            }
        }
    }
    
    public List<Student> getAllStudents() {
        List<Student> users = new ArrayList<>(); 
            for (Student user : this.students){
                users.add((Student) user);
            }
        return users;
    }

    public Student getStudentByID (Long id) throws Exception{
        List<Student> studs = getAllStudents();
        
        for (Student stud: studs){
            if (id == stud.getStudentID()){
                return stud;
            }
        }
        throw new Exception("Wrong id");
    }

    public List<Student> createListOfStudentsByTheirID(List<Long> list) throws Exception{
        List<Student> listStudents = new ArrayList<>();
        for (Long id: list){
            listStudents.add(getStudentByID(id));
        }
        return listStudents;
   }

    public void sortStudents(List<Student> listStudents){
        Collections.sort(listStudents, new StudyGroupComparator());
   }

}
