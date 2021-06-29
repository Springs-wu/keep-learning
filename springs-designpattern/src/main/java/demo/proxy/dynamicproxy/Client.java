package demo.proxy.dynamicproxy;

public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserProxy userProxy = new UserProxy();
        userProxy.setUserService(userService);

        UserService proxy = (UserService) userProxy.getProxy();
        proxy.getUser(1);
    }
}
