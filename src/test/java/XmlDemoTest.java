import com.mycode.entity.xml.Hello;
import com.mycode.entity.xml.House;
import com.mycode.entity.xml.Person;
import com.mycode.entity.xml.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlDemoTest {

    //创建Spring上下文对象
    public static ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext-xml.xml");

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

    /*
     * autowire byName (按名称自动装配)
     */
    public static void autowireByName(){

        // 当一个bean节点带有 autowire byName的属性时。
        //将查找其类中所有的set方法名，例如setCat，获得将set去掉并且首字母小写的字符串，即cat。
        //去spring容器中寻找是否有此字符串名称id的对象。
        //如果有，就取出注入；如果没有，就报空指针异常。
        House  houseByName = applicationContext.getBean("houseByName", House.class);
        System.out.println(houseByName.toString());
    }

    /*
     * autowire byType (按类型自动装配)
     */
    public static void autowireByType(){
        //使用autowire byType首先需要保证：同一类型的对象，在spring容器中唯一。如果不唯一，会报不唯一的异常。
        House  houseByType = applicationContext.getBean("houseByType", House.class);
        System.out.println(houseByType.toString());
    }

    public static void main(String[] args) {

        //MyTest.initBean();
        //MyTest.initBeanByConstructor();
        XmlDemoTest.autowireByType();
    }
}
