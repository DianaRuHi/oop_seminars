import java.util.List;

public class Controller {
    private final UserService userService = new UserService();
    private final StudentView studentView = new StudentView();
    private final StudyGroupService studyGroupService = new StudyGroupService();
    private final GroupView groupView = new GroupView();
    private final StudentService studentService = new StudentService();
    private final TeacherService teacherService = new TeacherService();

    public void createUser (String firstName, String lastName, String patronymic, Boolean isTeacher){
        userService.createUser(firstName, lastName, patronymic, isTeacher);
        List<User> users = userService.getAll(isTeacher);
        System.out.println(users.size());
        studentView.SendOnConsole(users);
    }

    public void createStudent (String firstName, String lastName, String patronymic){
        studentService.createStudent(firstName, lastName, patronymic);
        List<Student> users = studentService.getAllStudents();
        studentView.SendOnConsoleStusents(users);
    }

    public void createTeacher (String firstName, String lastName, String patronymic){
        teacherService.createTeacher(firstName, lastName, patronymic);
        List<Teacher> users = teacherService.getAllTeachers();
        studentView.SendOnConsoleTeachers(users);
    }


    public void createStudyGroup (Long teacherID, List<Long> studentsID) throws Exception{
        //System.out.println("________________");
        Teacher teacher = teacherService.getTeacherByID(teacherID);
        List<Student> listStudents = studentService.createListOfStudentsByTheirID(studentsID);
        studyGroupService.createGroup(teacher, listStudents);
        List<StudyGroup> groups = studyGroupService.getAllGroups();
        groupView.SendOnConsole(groups);
    }

    
    public void sortStudentsInGroups(List<StudyGroup> listGroups){
        List<Student> listStudents = studyGroupService.getAllStudentsInGroupsList(listGroups);
        studentService.sortStudents(listStudents);
        groupView.SendOnConsoleStudentsWithTheirGroupID(listStudents, listGroups);
    }

    public StudyGroup getGroupByID(Long id) throws Exception{
        return studyGroupService.getGroupByID(id);
    }

}
