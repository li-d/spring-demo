import com.mycode.config.SpringConfig;
import com.mycode.dao.AccountDao;
import com.mycode.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class JavaConfigDemoTest {
    public static void main(String[] args) {

        //通过Java配置来实例化Spring容器
        AnnotationConfigApplicationContext  applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.getUser();

        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        accountDao.getAccountInfo();
    }
}
