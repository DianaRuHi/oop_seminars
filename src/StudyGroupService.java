import java.util.ArrayList;
import java.util.List;

public class StudyGroupService {

    private final List<StudyGroup> groups;

    public StudyGroupService(){
        this.groups = new ArrayList<>(); 
    }

    public void createGroup(Teacher teacher, List<Student> listStusents){
        Long id = 0L;

        for (StudyGroup group: this.groups){
            if (id <= group.getId()){
                id = group.getId();
            }
        }
        this.groups.add(new StudyGroup(teacher, listStusents, ++id));
    }


    public List<StudyGroup> getAllGroups(){
        return this.groups;
    }

    public List<Student> getAllStudentsInGroupsList(List<StudyGroup> listGroup){
        List<Student> listStudents = new ArrayList<>();
        for (StudyGroup group: listGroup){
            for (Student student: group.getListStusents()){
                listStudents.add(student);
            }
        }
        return listStudents;
    }

    public StudyGroup getGroupByID(Long id) throws Exception{
        for (StudyGroup group: this.groups){
            if (id == group.getId()){
                return group;
            }
        }
        throw new Exception("Wrong id");
    }

    public List<Long> getTeacherIdAndStudentsIDs (StudyGroup studyGroup){
        List<Long> listID = new ArrayList<>();
        listID.add(studyGroup.getTeacher().getTeacherID());
        for (Student student: studyGroup.getListStusents()){
            listID.add(student.getStudentID());
        }
        return listID;
    }
    
}
