import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
    //1 初始spring容器（容器的本质就是一个类，可以存放其他对象）
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


/*
    IOC功能，及通过容器创建和管理对象
    需要在配置文件中去申明这个bean。
 */
    @Test
    public void testBean(){

        //使用spring创建bean
        HelloDao helloDao = (HelloDao) applicationContext.getBean("helloDao");
        helloDao.say();
    }

/*
    DI功能：使用Spring管理依赖
    1、配置bean，以及依赖。
    2、依赖的类，要写上set方法，且必须为public。
 */
    @Test
    public void testSay(){
        HelloService helloService = (HelloService) applicationContext.getBean("helloService");
        helloService.say();

    }

}
