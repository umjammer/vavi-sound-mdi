package musicDriverInterface;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class MmlDatum implements Serializable {

    public MMLType type = MMLType.unknown;
    public List<Object> args = null;
    public int dat = 0;
    public LinePos linePos = null;

    /** for deserialize */
    public MmlDatum() {
    }

    public MmlDatum(int dat) {
        assert dat >= 0 : String.valueOf(dat); // TODO should be unsigned byte, add `&& dat < 255`
        this.dat = dat;
    }

    public MmlDatum(MMLType type, List<Object> args, LinePos linePos, int dat) {
        assert dat >= 0 : String.valueOf(dat); // TODO should be unsigned byte, add `&& dat < 255`
        this.type = type;
        this.args = args;
        this.linePos = linePos;
        this.dat = dat;
    }

    public MmlDatum(int dat, MMLType type, LinePos linePos, Object... args) {
        assert dat >= 0 : String.valueOf(dat); // TODO should be unsigned byte, add `&& dat < 255`
        this.type = type;
        this.args = args != null ? Arrays.asList(args) : null;
        this.linePos = linePos;
        this.dat = dat;
    }

    @Override
    public String toString() {
        return String.format("type:%s args:%s linePos:[ %s ]", type, args, linePos);
    }
}
