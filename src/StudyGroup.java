import java.util.List;

public class StudyGroup {
    Teacher teacher;
    List<Student> listStusents;
    Long id;

    public StudyGroup(Teacher teacher, List<Student> listStusents, Long id){
        this.teacher = teacher;
        this.listStusents = listStusents;
        this.id =id;
    }
    
    public void setListStusents(List<Student> listStusents) {
        this.listStusents = listStusents;
    }
    public List<Student> getListStusents() {
        return listStusents;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        String str = "Group id: " + this.id + "\nTeacher: \n" + this.teacher.toString() + ", \nStudents:";
        for (Student student: this.listStusents){
            str += "\n" + student.toString();
        }
        return str;
    }
    
}
