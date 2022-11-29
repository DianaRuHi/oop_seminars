import java.util.List;
//import java.util.logging.Logger;

public class StudentView {
    public void SendOnConsole(List<User> users){
        //Logger logger = Logger.getAnonymousLogger();
        for (User user: users){
            //logger.info(user.toString());
            System.out.println(user.toString());
        }
    }

    public void SendOnConsoleStusents(List<Student> users){
        //Logger logger = Logger.getAnonymousLogger();
        for (Student user: users){
            //logger.info(user.toString());
            System.out.println(user.toString());
        }
    }
    public void SendOnConsoleTeachers(List<Teacher> users){
        //Logger logger = Logger.getAnonymousLogger();
        for (Teacher user: users){
            //logger.info(user.toString());
            System.out.println(user.toString());
        }
    }
}
