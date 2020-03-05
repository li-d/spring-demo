import com.mycode.entity.annotation.House;
import com.mycode.entity.annotation.HouseInject;
import com.mycode.entity.annotation.HouseNew;
import com.mycode.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDemoTest {

    //创建Spring上下文对象
    public static ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext-aop.xml");



    public static void main(String[] args) {
        ApplicationContext applicationContext = AopDemoTest.applicationContext;
        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        //bookService.add(null,62.0);
        bookService.show();

    }
}
