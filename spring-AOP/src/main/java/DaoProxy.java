import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
    注：
        1、使用动态代理也可以做。但这里我们使用更简单一点的
            动态代理：implements InvocationHandler
        2、我们实现有二种方法。
 */
public class DaoProxy implements MethodInterceptor {

    //动态创建对象(创建user对象)
    public Object createProxy(Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //创建切面对象
        DaoAspect daoAspect = new DaoAspect();

        //前增强
        daoAspect.check_Permission();

        //执行目标方法（dao方法）
        Object obj = methodProxy.invokeSuper(o, objects);

        //后增加
        daoAspect.log();
        return obj;
    }
}
