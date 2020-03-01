import com.mycode.entity.Hello;
import com.mycode.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    //创建Spring上下文对象
    public static ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void initBean() {
        //获取bean对象 一旦配置文件被加载,此时可以获取所有的bean

        Hello hello1 = (Hello) applicationContext.getBean("hello1");
        System.out.println(hello1.toString());

        Hello hello = (Hello) applicationContext.getBean("hello");
        System.out.println(hello.toString());
    }

   /*
    *IOC容器创建Bean的方式
    */
    public static void initBeanByConstructor(){
        //1 通过无参构造函数获取对象
        User userByNone = (User) applicationContext.getBean("userByNone");
        System.out.println(userByNone.toString());

        // 2 通过有参构造函数获取对象 有三种方式
        // 2.1 通过下标
        User userByIndex = (User) applicationContext.getBean("userByIndex");
        System.out.println(userByIndex.toString());
        // 2.2 根据参数名称
        User userByName = (User) applicationContext.getBean("userByName");
        System.out.println(userByName.toString());
        // 2.3 根据参数类型 当构造器存在相同类型的参数时候则无法使用
        User userByType = (User) applicationContext.getBean("userByType");
        System.out.println(userByType.toString());
    }


    public static void main(String[] args) {

        //MyTest.initBean();
        MyTest.initBeanByConstructor();
    }
}
