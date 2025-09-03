package Bean;

public abstract class Record {
    public abstract int getIdentifier();

    @Override
    public String toString() {
        return "Record [identifier=" + getIdentifier() + "]";
    }
}