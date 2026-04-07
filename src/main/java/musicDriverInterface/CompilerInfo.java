package musicDriverInterface;

import java.util.ArrayList;
import java.util.List;


public class CompilerInfo extends Information {
    /** Part type (For PMDDotNET, use "YM2608", "FM3chex", and "PPZ8"). */
    public List<String> partType = new ArrayList<>();
    /** Absolute position based on part (necessary because some drivers cannot list all parts) */
    public List<Integer> partNumber = new ArrayList<>();
    /** part name */
    public List<String> partName = new ArrayList<>();
    public List<Integer> totalCount = new ArrayList<>();
    public List<Integer> loopCount = new ArrayList<>();
    public List<Integer> bufferCount;
    /** Clock count until jump point */
    public int jumpClock;
    /** After jumped channel */
    public List<Integer> jumpChannel;
    /** Jump-point's row number */
    public int jumpRow;
    /** Jump-point's column number */
    public int jumpCol;
    public Object additionalInfo;
    /** The format of the output data (this serves as identification information for compilers that can output multiple formats) */
    public String formatType;
}
