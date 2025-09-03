package Bean;

public class Criminal extends Person {
    private int criminalId;
    private String identifyingMark;
    private String areaOfArrest;
    private String crimeId;

    

    public Criminal(int criminalId, String name, int age, String gender, String address, String identifyingMark,
            String areaOfArrest, String crimeId) {
        super(name, age, gender, address);
        this.criminalId = criminalId;
        this.identifyingMark = identifyingMark;
        this.areaOfArrest = areaOfArrest;
        this.crimeId = crimeId;
    }

    public int getCriminalId() {
        return criminalId;
    }

    public void setCriminalId(int criminalId) {
        this.criminalId = criminalId;
    }

    public String getIdentifyingMark() {
        return identifyingMark;
    }

    public void setIdentifyingMark(String identifyingMark) {
        this.identifyingMark = identifyingMark;
    }

    public String getAreaOfArrest() {
        return areaOfArrest;
    }

    public void setAreaOfArrest(String areaOfArrest) {
        this.areaOfArrest = areaOfArrest;
    }

    public String getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(String crimeId) {
        this.crimeId = crimeId;
    }

    @Override
    public String toString() {
        return "Criminal [criminalId=" + criminalId + ", name=" + getName() + ", age=" + getAge() + ", gender=" + getGender()
                + ", address=" + getAddress() + ", identifyingMark=" + identifyingMark + ", areaOfArrest=" + areaOfArrest
                + ", crimeId=" + crimeId + "]";
    }
}