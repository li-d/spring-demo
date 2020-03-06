import com.mycode.config.SpringAopConfig;
import com.mycode.entity.xml.User;
import com.mycode.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationAopDemoTest {
    public  static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAopConfig.class);

    public static void main(String[] args) {
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.addUser();
    }

}
