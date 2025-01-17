package musicDriverInterface;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;
import java.util.function.Function;

import dotnet4j.io.Stream;
import dotnet4j.util.compat.Tuple;


public interface IDriver extends IInterface {

    void init(List<ChipAction> chipsAction,
              MmlDatum[] srcBuf,
              Function<String, Stream> appendFileReaderCallback,
              Object... additionalOption);

    //
    // data Information
    //

    /**
     * Acquiring performance data
     */
    MmlDatum[] getDATA();

    byte[] getPCMFromSrcBuf();

    Tuple<String, short[]>[] getPCMTable();

    ChipDatum[] getPCMSendData();

    List<Tuple<String, String>> getTags();

    //
    // rendering
    //

    /**
     * Start Rendering
     *
     * @param renderingFreq    frame/sec
     * @param chipMasterClocks Frequency of each sound source (sound source name, frequency)
     */
    void startRendering(int renderingFreq, Tuple<String, Integer>... chipMasterClocks);

    /**
     * Rendering Completed
     */
    void stopRendering();

    /**
     * Rendering per frame
     */
    void render();

    /**
     * Output to audio source
     *
     * @param reg
     */
    void writeRegister(ChipDatum reg);

    //
    // Command
    //

    /**
     * Start playing a song
     *
     * @param musicNumber Song Number (0~)
     */
    void startMusic(int musicNumber);

    /**
     * Stop the currently playing song
     */
    void stopMusic();

    /**
     * Fade out the currently playing song
     */
    void fadeOut();

    /**
     * Get internal information about the driver
     */
    Object getWork();

    /**
     * Sound effect pronunciation
     */
    void shotEffect();

    /**
     * Playing or not
     *
     * @return -1: Error, 0: Finished, 1: Playing
     */
    int getStatus();

    /**
     * Maximum number of infinite loop commands
     *
     * @param loopCounter -1: infinite, 0 or more: number of repetitions
     */
    int setLoopCount(int loopCounter);

    /**
     * Number of times the song was looped at the time of acquisition
     *
     * @return Number of times
     */
    int getNowLoopCounter();

    void setDriverSwitch(Object... param);

    static IDriver factory(String className) {
        for (IDriver driver : ServiceLoader.load(IDriver.class)) {
            if (driver.getClass().getName().equals(className)) {
                return driver;
            }
        }
        throw new NoSuchElementException(className);
    }
}
