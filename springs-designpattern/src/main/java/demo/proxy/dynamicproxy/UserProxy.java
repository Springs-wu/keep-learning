package Impl.designPattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy implements InvocationHandler
{
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Object getProxy()
    {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), userService.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前");
        Object result = method.invoke(userService, args);
        System.out.println("调用后");
        return result;
    }
}