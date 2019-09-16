package lesson12.introspection.reflection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CityReader {
    private String realName = "";
    private int realSince = 0;
    private double realArea = 0d;
    private String realTimeZone = "";
    private long realPopulation = 0L;

    public String getRealName() {
        return realName;
    }
    public int getRealSince() {
        return realSince;
    }
    public double getRealArea() {
        return realArea;
    }
    public String getRealTimeZone() {
        return realTimeZone;
    }
    public long getRealPopulation() {
        return realPopulation;
    }

    private String cityFileAddress;

    CityReader(String cityFileAddress) {
        this.cityFileAddress = cityFileAddress;
    }

    private int readCondition;

    private String foundSector = "";
    private String foundVal = "";

    void loader() {
        try (BufferedReader bfCityReader = new BufferedReader
                (new FileReader(cityFileAddress))) {

            do {
                findField(bfCityReader);
            } while (readCondition != -1);

        } catch (IOException exc) {
            System.out.println("File access error!");
        }
    }

    private void findField(BufferedReader bf) throws IOException {
        do {
            readCondition = bf.read();
            foundSector += (char) readCondition;
        } while (readCondition != ':');
        readVal(foundSector, bf);
    }

    private void readVal(String sector, BufferedReader bf) throws IOException {
        switch (sector) {
            case "Name:":
                valReader(bf);
                realName = foundVal;
                resetFounders();
                break;
            case "Since:":
                valReader(bf);
                realSince = Integer.parseInt(foundVal);
                resetFounders();
                break;
            case "Area:":
                valReader(bf);
                realArea = Double.parseDouble(foundVal);
                resetFounders();
                break;
            case "TimeZone:":
                valReader(bf);
                realTimeZone = foundVal;
                resetFounders();
                break;
            case "Population:":
                valReader(bf);
                realPopulation = Long.parseLong(foundVal);
                resetFounders();
                readCondition = bf.read(); //to next line
                break;
            default:
                System.out.println("Sector not found!");
        }
    }

    private void valReader(BufferedReader bf) throws IOException {
        readCondition = bf.read();//skip ':'
        while (readCondition != ',') {
            foundVal += (char) readCondition;
            readCondition = bf.read();
        }
    }

    private void resetFounders(){
        foundVal = "";
        foundSector = "";
    }
}