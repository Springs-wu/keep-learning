package demo.proxy.staticproxy;

public class UserProxy implements UserService
{
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public String getUser(int id) {
        preHandler();
        String user = userService.getUser(id);
        afterHandler();
        return user;
    }


    private void preHandler() {
        System.out.println("调用前");
    }

    private void afterHandler() {
        System.out.println("调用后");
    }
}