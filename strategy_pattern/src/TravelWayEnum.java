/**
 * @author AYL    2018/4/13 23:00
 */
public enum TravelWayEnum {
    ByPlane(new ByPlane()),
    ByTrain(new ByTrain()),
    BySelfDriving(new BySelfDriving());

    private TravelWay travelWay;

    public TravelWay getTravelWay() {
        return travelWay;
    }

    TravelWayEnum(TravelWay travelWay) {
        this.travelWay = travelWay;
    }
}
