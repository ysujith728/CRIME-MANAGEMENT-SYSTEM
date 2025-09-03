package Dto;

public class CrimesDoneByCriminalDto {
    private int criminalId;
    private String criminalName;
    private int crimeId;
    private String crimeType;
    private String crimeDate;
    
   
    
    public CrimesDoneByCriminalDto(int criminalId, String criminalName, int crimeId, String crimeType, String crimeDate) {
        super();
        this.criminalId = criminalId;
        this.criminalName = criminalName;
        this.crimeId = crimeId;
        this.crimeType = crimeType;
        this.crimeDate = crimeDate;
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
    
    public int getCrimeId() {
        return crimeId;
    }
    
    public void setCrimeId(int crimeId) {
        this.crimeId = crimeId;
    }
    
    public String getCrimeType() {
        return crimeType;
    }
    
    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }
    
    public String getCrimeDate() {
        return crimeDate;
    }
    
    public void setCrimeDate(String crimeDate) {
        this.crimeDate = crimeDate;
    }
    
    @Override
    public String toString() {
        return "CrimesDoneByCriminal [CriminalId=" + criminalId + ", CriminalName=" + criminalName + ", CrimeId="
                + crimeId + ", CrimeType=" + crimeType + ", CrimeDate=" + crimeDate + "]";
    }
}

