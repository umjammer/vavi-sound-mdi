package musicDriverInterface;


public interface ChipAction {
    /**
     * チップ判断向け
     */
    String getChipName();

    /**
     * チップデータ送信向け
     * @param cd
     */
    void writeRegister(ChipDatum cd);

    /**
     * PCMデータ送信向け
     */
    void writePCMData(byte[] data, int startAddress, int endAddress);

    /**
     * ウェイト向け
     */
    void waitSend(long t1, int t2);
}
