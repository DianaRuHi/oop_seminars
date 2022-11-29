import java.util.List;

//import java.util.logging.Logger;

public class GroupView {
    public void SendOnConsole(List<StudyGroup> groups){
        //Logger logger = Logger.getAnonymousLogger(); 
        //logger.info(group.toString());
        for (StudyGroup group: groups){
            System.out.println(group.toString());
        }
    }

    public void SendOnConsoleStudentsWithTheirGroupID(List<Student> listStudents, List<StudyGroup> listGroups){
        for (Student student: listStudents){
            for (StudyGroup group: listGroups){
                List<Student> groupStudents = group.getListStusents();
                for (Student groupStudent: groupStudents){
                    if (student.getStudentID()==groupStudent.getStudentID()){
                        System.out.println(student.toString() + ", Group: " + group.getId());
                    }
                }
            }
        }
    }
    
}