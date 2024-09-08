package musicDriverInterface;

import java.io.Serializable;


public class LinePos implements Serializable {
    public Object document;
    public String srcMMLID;
    public int row;
    public int col;
    public int length;
    public String part;
    public String chip;
    public int chipIndex;
    public int chipNumber;
    public int ch;

    public String aliesName;
    public String aliesNextName;
    public int aliesDepth;

    public LinePos() {
        this.document = null;
        this.srcMMLID = "";
        this.row = -1;
        this.col = -1;
        this.length = 1;
        this.part = "";
        this.chip = "";
        this.chipIndex = 0;
        this.chipNumber = 0;
        this.ch = -1;

        this.aliesName = "";
        this.aliesNextName = "";
        this.aliesDepth = 0;
    }

    public LinePos(Object document, String srcMMLID, int row/* =-1*/, int col/* =-1*/, int length/* =-1*/, String part/* =""*/, String chip/* =""*/, int chipIndex/* =0*/, int chipNumber/* =0*/, int ch/* =-1*/) {
        this(document, srcMMLID, row, col, length, part, chip, chipIndex, chipNumber, ch, "", "", 0);
    }

    public LinePos(Object document, String srcMMLID, int row/* =-1*/, int col/* =-1*/, int length/* =-1*/, String part/* =""*/, String chip/* =""*/, int chipIndex/* =0*/, int chipNumber/* =0*/, int ch/* =-1*/, String aliesName, String aliesNextName, int aliesDepth) {
        this.document = document;
        this.srcMMLID = srcMMLID;
        this.row = row;
        this.col = col;
        this.length = length;
        this.part = part;
        this.chip = chip;
        this.chipIndex = chipIndex;
        this.chipNumber = chipNumber;
        this.ch = ch;

        this.aliesName = aliesName;
        this.aliesNextName = aliesNextName;
        this.aliesDepth = aliesDepth;
    }

    public static void clear(LinePos src) {
        if (src == null) return;

        src.document = null;
        src.srcMMLID = "";
        src.row = -1;
        src.col = -1;
        src.length = 1;
        src.part = "";
        src.chip = "";
        src.chipIndex = 0;
        src.chipNumber = 0;
        src.ch = -1;

        src.aliesName = "";
        src.aliesNextName = "";
        src.aliesDepth = 0;
    }

    public static void move(LinePos src, LinePos des) {
        if (src == null || des == null) return;

        des.document = src.document;
        des.srcMMLID = src.srcMMLID;
        des.row = src.row;
        des.col = src.col;
        des.length = src.length;
        des.part = src.part;
        des.chip = src.chip;
        des.chipIndex = src.chipIndex;
        des.chipNumber = src.chipNumber;
        des.ch = src.ch;

        des.aliesName = src.aliesName;
        des.aliesNextName = src.aliesNextName;
        des.aliesDepth = src.aliesDepth;
    }

    public static LinePos Copy(LinePos src) {
        if (src == null) return null;

        LinePos ret = new LinePos(src.document, src.srcMMLID, src.row,
                src.col, src.length, src.part, src.chip, src.chipIndex, src.chipNumber, src.ch,
                src.aliesName, src.aliesNextName, src.aliesDepth);

        return ret;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof LinePos pos && document == pos.document &&
                srcMMLID.equals(pos.srcMMLID) && row == pos.row &&
                col == pos.col && length == pos.length && part.equals(pos.part) &&
                chip.equals(pos.chip) && chipIndex == pos.chipIndex && chipNumber == pos.chipNumber &&
                ch == pos.ch && aliesName.equals(pos.aliesName) && aliesNextName.equals(pos.aliesNextName) &&
                aliesDepth == pos.aliesDepth;
    }

    @Override
    public int hashCode() {
        int hashCode = -113896206;
        hashCode = hashCode * -1521134295 + (document != null ? document.hashCode() : 0);
        hashCode = hashCode * -1521134295 + srcMMLID.hashCode();
        hashCode = hashCode * -1521134295 + Integer.hashCode(row);
        hashCode = hashCode * -1521134295 + Integer.hashCode(col);
        hashCode = hashCode * -1521134295 + Integer.hashCode(length);
        hashCode = hashCode * -1521134295 + part.hashCode();
        hashCode = hashCode * -1521134295 + chip.hashCode();
        hashCode = hashCode * -1521134295 + Integer.hashCode(chipIndex);
        hashCode = hashCode * -1521134295 + Integer.hashCode(chipNumber);
        hashCode = hashCode * -1521134295 + Integer.hashCode(ch);

        hashCode = hashCode * -1521134295 + aliesName.hashCode();
        hashCode = hashCode * -1521134295 + aliesNextName.hashCode();
        hashCode = hashCode * -1521134295 + Integer.hashCode(aliesDepth);
        return hashCode;
    }

    @Override
    public String toString() {
        return String.format("document:%s srcMMLID:%s row:%s col:%s length:%s part:%s" +
                " chip:%s chipIndex:%s chipNumber:%s ch:%s aliesName:%s aliesNextName:%s aliesDepth:%s",
                document, srcMMLID, row, col, length, part, chip, chipIndex, chipNumber, ch,
                aliesName, aliesNextName, aliesDepth);
    }
}
