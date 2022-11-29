import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Реализовать в нашем проекте функцию по сортировке студентов в списке студенческих групп
// 1) + Реализовать компаратор сравнивающий студентов по Фамилии и Имени 
// 2) + в View создать метод для отображения списка студентов
// 2) в Контроллере реализовать метод принимающий List<StudentGroup> и сортирующий с помощью компаратора,
//    и вызывающий метод view для отображения
// на выходе должно быть отображение отсортированного списка студентов с указанием группы, в которой он учится
// пример:
//      Студент 1 - Группа 4
//      Студент 2 - Группа 1
//      Студент 3 - Группа 5



public class App {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();

        controller.createStudent("Aaa", "Aa","A");
        controller.createStudent("Bbb", "Bb","B");
        controller.createStudent("Ccc", "Cc","C");
        controller.createStudent("Ddd", "Dd","D");
        controller.createStudent("Eee", "Ee","E");
        controller.createTeacher("Teach1", "Tea1","T1");
        controller.createTeacher("Teach2", "Tea2","T2");
        
        System.out.println("__________");

        List<StudyGroup> listGroups = new ArrayList<>();
        List<Long> listID1 = new ArrayList<>(Arrays.asList(1L,3L));
        controller.createStudyGroup(2L, listID1);
        listGroups.add(controller.getGroupByID(1L));

        List<Long> listID2 = new ArrayList<>(Arrays.asList(2L,4L,5L));
        controller.createStudyGroup(1L, listID2);
        listGroups.add(controller.getGroupByID(2L));

        System.out.println("__________");

        controller.sortStudentsInGroups(listGroups);

    }
}
