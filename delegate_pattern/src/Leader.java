/**
 * @author AYL    2018/4/15 0:59
 */
public class Leader {
    private IStaff staff;

    public void doCommand(String command){
        System.out.println("start to solve this command:" + command);
        StaffEnum.Encrypt.getStaff().work("encrypt");
        StaffEnum.Regist.getStaff().work("regist");

    }
}
