package musicDriverInterface;


public interface ChipAction {

    /**
     * for chip determination
     */
    String getChipName();

    /**
     * for chip data transfer
     * @param cd
     */
    void writeRegister(ChipDatum cd);

    /**
     * for PCM data transfer
     */
    void writePCMData(byte[] data, int startAddress, int endAddress);

    /**
     * for wait
     */
    void waitSend(long t1, int t2);
}
