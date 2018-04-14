/**
 * @author AYL    2018/4/15 1:22
 */
public class StaffRegist implements IStaff {
    @Override
    public void work(String command) {
        System.out.println("B start to finish command:" + command);
        System.out.println("finished.");
    }
}
