import org.junit.Test;

public class TestAop {

    @Test
    public void testAop(){
        //1 创建代理对象
        DaoProxy daoProxy = new DaoProxy();

        //2 创建目标对象
        UserDao userDao = new UserDao();

        //3 获取增强后的对象
        UserDao userDao1 = (UserDao) daoProxy.createProxy(userDao);

        //4 执行
        userDao1.addUser();
    }
}
