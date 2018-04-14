/**
 * @author AYL    2018/4/15 1:21
 */
public class StaffEncrypt implements IStaff {
    @Override
    public void work(String command) {
        System.out.println("A is start to finish command:" + command);
        System.out.println("finished.");
    }
}
