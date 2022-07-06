package musicDriverInterface;

import java.util.List;
import java.util.function.Function;

import dotnet4j.util.compat.Tuple;
import dotnet4j.io.Stream;


public interface IDriver extends IInterface {

    void init(List<ChipAction> chipsAction,
              MmlDatum[] srcBuf,
              Function<String, Stream> appendFileReaderCallback,
              Object... additionalOption);

    //
    // data Information
    //

    /**
     * 演奏データ取得
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
     * レンダリング開始
     *
     * @param renderingFreq    frame/sec
     * @param chipMasterClocks 音源毎の周波数(音源名,周波数)
     */
    void startRendering(int renderingFreq, Tuple<String, Integer>... chipMasterClocks);

    /**
     * レンダリング終了
     */
    void stopRendering();

    /**
     * 1 frame 当たりのレンダリング
     */
    void render();

    /**
     * 音源へ出力
     *
     * @param reg
     */
    void writeRegister(ChipDatum reg);

    //
    // Command
    //

    /**
     * 曲の再生開始
     *
     * @param musicNumber 曲番号 (0~)
     */
    void startMusic(int musicNumber);

    /**
     * 現在再生中の曲を停止
     */
    void stopMusic();

    /**
     * 現在再生中の曲をフェードアウト
     */
    void fadeOut();

    /**
     * ドライバの内部情報を取得する
     */
    Object getWork();

    /**
     * 効果音の発音
     */
    void shotEffect();

    /**
     * 演奏中か否か
     *
     * @return -1: エラー終了,  0: 終了,  1: 再生中
     */
    int getStatus();

    /**
     * 無限ループ系コマンドの最大回数
     *
     * @param loopCounter -1: 無限, 0 以上: 繰り返し回数
     */
    int setLoopCount(int loopCounter);

    /**
     * 取得時点の曲のループ回数
     *
     * @return 回数
     */
    int getNowLoopCounter();

    void setDriverSwitch(Object... param);
}
