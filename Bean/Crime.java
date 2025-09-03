package Bean;

public class Crime extends Record {
    private int crimeId;
    private String crimeType;
    private String description;
    private String psArea;
    private String date;
    private String victimId;

    public Crime(int crimeId, String crimeType, String description, String psArea, String date, String victimId) {
        super();
        this.crimeId = crimeId;
        this.crimeType = crimeType;
        this.description = description;
        this.psArea = psArea;
        this.date = date;
        this.victimId = victimId;
    }

    @Override
    public int getIdentifier() {
        return crimeId;
    }

    public int getCrimeId() {
        return this.getIdentifier();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPsArea() {
        return psArea;
    }

    public void setPsArea(String psArea) {
        this.psArea = psArea;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVictimId() {
        return victimId;
    }

    public void setVictimId(String victimId) {
        this.victimId = victimId;
    }

    @Override
    public String toString() {
        return "Crime [crimeId=" + crimeId + ", crimeType=" + crimeType + ", description=" + description + ", psArea="
                + psArea + ", date=" + date + ", victimId=" + victimId + "]";
    }
}