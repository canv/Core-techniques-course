package lesson12.introspection.reflection;

public class City {
    private String name;
    private int since;
    private double area;
    private String timeZone;
    private long population;

    public City() {
        this.name = "none";
        this.since = 0;
        this.area = 0.0d;
        this.timeZone = "none";
        this.population = 0L;
    }
    private City(String name, int since, double area, String timeZone, long population) {
        this.name = name;
        this.since = since;
        this.area = area;
        this.timeZone = timeZone;
        this.population = population;
    }

    double populationPerSquare(){
        return population / area;
    }
    double populationPerSquare(int specialPopulation, double specialArea){
        return specialPopulation / specialArea;
    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public void setSince(int since) {
//        this.since = since;
//    }
//    public void setArea(double area) {
//        this.area = area;
//    }
//    public void setTimeZone(String timeZone) {
//        this.timeZone = timeZone;
//    }
//    public void setPopulation(int population) {
//        this.population = population;
//    }
    String getName() {
        return name;
    }
    int getSince() {
        return since;
    }
    double getArea() {
        return area;
    }
    String getTimeZone() {
        return timeZone;
    }
    long getPopulation() {
        return population;
    }

    static class CityBuilder{
        private String name;
        private int since;
        private double area;
        private String timeZone;
        private long population;

        City build(){
            City city = new City(name,since,area,timeZone,population);
            name = null;
            since = 0;
            area = 0.0d;
            timeZone = null;
            population = 0L;
            return city;
        }
        CityBuilder withName(String name) {
            this.name = name;
            return this;
        }
        CityBuilder withSince(int since) {
            this.since = since;
            return this;
        }
        CityBuilder withArea(double area) {
            this.area = area;
            return this;
        }
        CityBuilder withTimeZone(String timeZone) {
            this.timeZone = timeZone;
            return this;
        }
        CityBuilder withPopulation(long population) {
            this.population = population;
            return this;
        }
    }
}