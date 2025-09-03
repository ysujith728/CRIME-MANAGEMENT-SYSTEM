package Dto;

public class CriminalArrestedDto {
    private int criminalId;
    private String criminalName;
    private String policeStation;
    private String arrestDate;
    
    
    
    public CriminalArrestedDto(int criminalId, String criminalName, String policeStation, String arrestDate) {
        super();
        this.criminalId = criminalId;
        this.criminalName = criminalName;
        this.policeStation = policeStation;
        this.arrestDate = arrestDate;
    }
    
    public int getCriminalId() {
        return criminalId;
    }
    
    public void setCriminalId(int criminalId) {
        this.criminalId = criminalId;
    }
    
    public String getCriminalName() {
        return criminalName;
    }
    
    public void setCriminalName(String criminalName) {
        this.criminalName = criminalName;
    }
    
    public String getPoliceStation() {
        return policeStation;
    }
    
    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }
    
    public String getArrestDate() {
        return arrestDate;
    }
    
    public void setArrestDate(String arrestDate) {
        this.arrestDate = arrestDate;
    }
    
    @Override
    public String toString() {
        return "CriminalArrested [CriminalId=" + criminalId + ", CriminalName=" + criminalName + ", PoliceStation="
                + policeStation + ", ArrestDate=" + arrestDate + "]";
    }
}

