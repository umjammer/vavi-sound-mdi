package musicDriverInterface;

import java.util.Arrays;
import java.util.stream.Collectors;


public class ChipDatum {

    public int port;
    public int address;
    public int data;
    private int time;
    public Object additionalData;

    public ChipDatum(int port, int address, int data) {
        this(port, address, data, 0, null);
    }

    public ChipDatum(int port, int address, int data, int time, Object additionalData) {
        this.port = port;
        assert address >= 0 || address == -1 : debug("address", address);
        this.address = address;
        assert data >= 0 || address == -1 : debug("data", data);
        this.data = data;
        this.time = time;
        this.additionalData = additionalData;
    }

    private static String debug(Object... args) {
new Exception("*** DUMMY *** : " + args[0]).printStackTrace(System.err);
        return Arrays.stream(args).map(Object::toString).collect(Collectors.joining(", "));
    }
}
