package shallow_copy;

import java.io.Serializable;

/**
 * @author AYL    2018/3/31 0:08
 */
public class JinGuBang implements Serializable {
    private int h;
    private int d;

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void bigger(){
        this.h *= 2;
        this.d *= 2;
    }

    public void smaller(){
        this.h /= 2;
        this.d /= 2;
    }
}
