package musicDriverInterface;

public class ChipDatum {

    public int port;
    public int address;
    public int data;
    public long time;
    public Object addtionalData;

    public ChipDatum(int port, int address, int data) {
        this(port, address, data, 0, null);
    }

    public ChipDatum(int port, int address, int data, long time, Object addtionalData) {
        this.port = port;
        this.address = address;
        this.data = data;
        this.time = time;
        this.addtionalData = addtionalData;
    }
}
