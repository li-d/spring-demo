import com.mycode.entity.annotation.House;
import com.mycode.entity.annotation.HouseInject;
import com.mycode.entity.annotation.HouseNew;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoTest {

    //创建Spring上下文对象
    public static ApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("applicationContext-annotation.xml");

    /*
     * @Autowired是按类型自动转配的 可以替代Java代码里面的getter/setter
     * @Autowired(required=false) 说明： false，对象可以为null；true，对象必须存对象，不能为null。
     * @Autowired是根据类型自动装配的，加上@Qualifier则可以根据byName的方式自动装配
     * @Qualifier不能单独使用。
     * 在使用@Autowired时，首先在容器中查询对应类型的bean
　　　　如果查询结果刚好为一个，就将该bean装配给@Autowired指定的数据
　　　　如果查询的结果不止一个，那么@Autowired会根据名称来查找。
　　　　如果查询的结果为空，那么会抛出异常。解决方法时，使用required=false
     */
    public static void autowiredAnnotation() {
        House houseByAutoWired = applicationContext.getBean("houseByAutoWired", House.class);
        System.out.println(houseByAutoWired.toString());
    }

    /*
     * @Resource如有指定的name属性，先按该属性进行byName方式查找装配；
     * 其次再进行默认的byName方式进行装配；
     *如果以上都不成功，则按byType的方式自动装配。
     *都不成功，则报异常。
     */
    public static void resourceAnnotation() {
        HouseNew houseByResource = applicationContext.getBean("houseByResource", HouseNew.class);
        System.out.println(houseByResource.toString());
    }

    /*
     * @Inject 用法基本和autowired一致
     */
    public static void injectAnnotation() {
        HouseInject houseByInject = applicationContext.getBean("houseByInject", HouseInject.class);
        System.out.println(houseByInject.toString());
    }

    public static void main(String[] args) {

        AnnotationDemoTest.injectAnnotation();
    }
}
