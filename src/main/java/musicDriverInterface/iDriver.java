package musicDriverInterface;

import java.util.List;
import java.util.function.Function;

import dotnet4j.Tuple;
import dotnet4j.io.Stream;


public interface iDriver extends iInterface {

    void Init(
            List<ChipAction> chipsAction,
            MmlDatum[] srcBuf,
            Function<String, Stream> appendFileReaderCallback,
            Object addtionalOption
    );

    //
    // data Information
    //

    /**
     * 演奏データ取得
     * @return %s
     */
    MmlDatum[] GetDATA();

    byte[] GetPCMFromSrcBuf();

    Tuple<String, short[]>[] GetPCMTable();

    ChipDatum[] GetPCMSendData();

    List<Tuple<String, String>> GetTags();

    //
    // rendering
    //

    /**
     * レンダリング開始
     * @param renderingFreq frame/sec
     * @param chipsMasterClock 音源毎の周波数(音源名,周波数)
     */
    void StartRendering(int renderingFreq, Tuple<String, Integer>[] chipsMasterClock);

    /**
     * レンダリング終了
     */
    void StopRendering();

    /**
     * 1frame当たりのレンダリング
     */
    void Rendering();

    /**
     * 音源へ出力
     * @param reg 
     */
    void WriteRegister(ChipDatum reg);

    //
    // Command
    //

    /**
     * 曲の再生開始
     * @param musicNumber 曲番号(0～)
     */
    void MusicSTART(int musicNumber);

    /**
     * 現在再生中の曲を停止
     */
    void MusicSTOP();

    /**
     * 現在再生中の曲をフェードアウト
     */
    void FadeOut();

    /**
     * ドライバの内部情報を取得する
     */
    Object GetWork();

    /**
     * 効果音の発音
     */
    void ShotEffect();

    /**
     * 演奏中か否か
     * @return -1 : エラー終了  0 : 終了  1 : 再生中%s
     */
    int GetStatus();

    /**
     * 無限ループ系コマンドの最大回数
     * @param loopCounter -1:無限 0以上:繰り返し回数
     */
    int SetLoopCount(int loopCounter);

    /**
     * 取得時点の曲のループ回数
     * @return 回数%s
     */
    int GetNowLoopCounter();

    void SetDriverSwitch(Object... param);
}
