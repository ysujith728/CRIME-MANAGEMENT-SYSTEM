package Bean;

public class Victim extends Person {
    private int victimId;

   

    public Victim(int victimId, String name, int age, String gender, String address) {
        super(name, age, gender, address);
        this.victimId = victimId;
    }

    public int getVictimId() {
        return victimId;
    }

    public void setVictimId(int victimId) {
        this.victimId = victimId;
    }

    @Override
    public String toString() {
        return "Victim [victimId=" + victimId + ", name=" + getName() + ", age=" + getAge() + ", gender=" + getGender()
                + ", address=" + getAddress() + "]";
    }
}