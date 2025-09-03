package Dto;

public class VictimsDto {
    private int victimId;
    private String victimName;
    private String crimeType;
    private String crimeDate;
    
   
    
    public VictimsDto(int victimId, String victimName, String crimeType, String crimeDate) {
        super();
        this.victimId = victimId;
        this.victimName = victimName;
        this.crimeType = crimeType;
        this.crimeDate = crimeDate;
    }
    
    public int getVictimId() {
        return victimId;
    }
    
    public void setVictimId(int victimId) {
        this.victimId = victimId;
    }
    
    public String getVictimName() {
        return victimName;
    }
    
    public void setVictimName(String victimName) {
        this.victimName = victimName;
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
        return "VictimsDto [VictimId=" + victimId + ", VictimName=" + victimName + ", CrimeType=" + crimeType
                + ", CrimeDate=" + crimeDate + "]";
    }
}

