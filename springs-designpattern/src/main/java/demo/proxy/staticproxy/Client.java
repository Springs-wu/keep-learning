package Impl.designPattern.proxy.staticproxy;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserProxy userProxy = new UserProxy();
        userProxy.setUserService(userService);
        userProxy.getUser(1);
    }
}
