/**
 * @author AYL    2018/4/13 22:57
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Ming plan have a travel to LiJiang。");
        TravelWayEnum.ByPlane.getTravelWay().start();
        TravelWayEnum.BySelfDriving.getTravelWay().start();
        TravelWayEnum.ByTrain.getTravelWay().start();
    }
}
