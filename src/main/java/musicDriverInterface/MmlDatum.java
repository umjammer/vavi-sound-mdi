package musicDriverInterface;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class MmlDatum implements Serializable {

    public enmMMLType type = enmMMLType.unknown;
    public List<Object> args = null;
    public int dat = 0;
    public LinePos linePos = null;

    public MmlDatum() {
    }

    public MmlDatum(int dat) {
        this.dat = dat;
    }

    public MmlDatum(enmMMLType type, List<Object> args, LinePos linePos, int dat) {
        this.type = type;
        this.args = args;
        this.linePos = linePos;
        this.dat = dat;
    }

    public MmlDatum(int dat, enmMMLType type, LinePos linePos, Object... args) {
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
