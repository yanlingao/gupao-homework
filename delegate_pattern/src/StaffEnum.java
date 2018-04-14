/**
 * @author AYL    2018/4/15 1:23
 */
public enum StaffEnum {
    Encrypt(new StaffEncrypt()),
    Regist(new StaffRegist());

    private IStaff staff;

    public IStaff getStaff() {
        return staff;
    }

    StaffEnum(IStaff staff){
        this.staff = staff;
    }
}
