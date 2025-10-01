package ge.tbc.testautomation.utils;

public class LocationCase {
    private Integer id;
    private String area;
    private Integer expectedMinResults;

    public LocationCase(Integer id, String area, Integer expectedMinResults) {
        this.id = id;
        this.area = area;
        this.expectedMinResults = expectedMinResults;
    }

    public Integer getId() {
        return id;
    }

    public String getArea() {
        return area;
    }

    public Integer getExpectedMinResults() {
        return expectedMinResults;
    }

    @Override
    public String toString() {
        return "LocationCase{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", expectedMinResults=" + expectedMinResults +
                '}';
    }
}
