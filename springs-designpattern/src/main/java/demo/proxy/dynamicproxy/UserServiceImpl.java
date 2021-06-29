package demo.proxy.dynamicproxy;

public class UserServiceImpl implements UserService
{

    @Override
    public String getUser(int id) {
        System.out.println("springs");
        return "springs";
    }
}
