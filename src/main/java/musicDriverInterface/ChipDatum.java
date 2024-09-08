package musicDriverInterface;

import java.util.Arrays;
import java.util.stream.Collectors;


public class ChipDatum {

    public int port;
    public int address;
    public int data;
    public long time;
    public Object additionalData;

    public ChipDatum(int port, int address, int data) {
        this(port, address, data, 0, null);
    }

    public ChipDatum(int port, int address, int data, long time, Object additionalData) {
        this.port = port;
        assert address >= 0 : debug("address", address);
        this.address = address;
        assert data >= 0 : debug("data", data);
        this.data = data;
        this.time = time;
        this.additionalData = additionalData;
    }

    static String debug(Object... args) {
        new Exception("*** DUMMY ***").printStackTrace();
        return Arrays.stream(args).map(Object::toString).collect(Collectors.joining(", "));
    }
}
