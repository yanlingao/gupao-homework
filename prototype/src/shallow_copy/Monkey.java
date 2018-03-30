package shallow_copy;

import java.util.Date;

/**
 * @author AYL    2018/3/31 0:06
 */
public class Monkey {
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
