package Impl.designPattern.proxy.staticproxy;

public class UserServiceImpl implements UserService
{

    @Override
    public String getUser(int id) {
        System.out.println("springs");
        return "springs";
    }
}
