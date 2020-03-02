import com.mycode.entity.Hello;
import com.mycode.entity.Person;
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
    *依赖注入DI方式之构造器注入
    *IOC容器创建Bean的方式(构造器方式 还有静态工厂 和 实例工厂 两种模式)
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

    /*
     *依赖注入DI的三种方式
     * 1 构造器注入
     * 2 set注入
     * 3 P命名空间注入
     */
    public static void testDI(){
        //1 构造器注入
        initBeanByConstructor();
        //2 set注入
        setOfDI();
        //3 P命名空间注入
        pspaceOfDI();
    }

    /*
     *依赖注入DI方式之set注入
     * 1	- 需要配置bean标签的子标签property
     * 2	- 需要bean实体类中指定setter方法
     */
    public static void setOfDI(){
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person.toString());
    }

    /*
     *依赖注入DI方式之P命名空间注入
     * 本质上还是调用set方法
     * 需要先引入 p 名称空间
     * 在schema的名称空间中加入该行 xmlns:p="http://www.springframework.org/schema/p
     */
    public static void pspaceOfDI(){
        User userByP = (User) applicationContext.getBean("userByP");
        System.out.println(userByP.toString());
    }


    public static void main(String[] args) {

        //MyTest.initBean();
        //MyTest.initBeanByConstructor();
        MyTest.pspaceOfDI();
    }
}
