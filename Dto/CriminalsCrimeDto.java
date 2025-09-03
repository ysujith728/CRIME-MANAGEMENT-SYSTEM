package Dto;

public class CriminalsCrimeDto {
    private int crimeId;
    private String crimeType;
    private int criminalId;
    private String criminalName;
    
    
    
    public CriminalsCrimeDto(int crimeId, String crimeType, int criminalId, String criminalName) {
        super();
        this.crimeId = crimeId;
        this.crimeType = crimeType;
        this.criminalId = criminalId;
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
    
    @Override
    public String toString() {
        return "CriminalsCrime [CrimeId=" + crimeId + ", CrimeType=" + crimeType + ", CriminalId=" + criminalId
                + ", CriminalName=" + criminalName + "]";
    }
}

