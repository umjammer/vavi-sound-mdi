package musicDriverInterface;

import java.util.List;


public class CompilerInfo extends Information {
    /** partタイプ(PMDDotNETの場合は"YM2608","FM3chex","PPZ8" */
    public List<String> partType;
    /** part基準の絶対位置 (ドライバによっては全パートのリストができるわけではないので必要) */
    public List<Integer> partNumber;
    /** part名 */
    public List<String> partName;
    public List<Integer> totalCount;
    public List<Integer> loopCount;
    public List<Integer> bufferCount;
    /** ジャンプポイントまでのクロック数 */
    public int jumpClock;
    /** ジャンプしたチャンネル */
    public List<Integer> jumpChannel;
    /** ジャンプポイントの行数 */
    public int jumpRow;
    /** ジャンプポイントの桁数 */
    public int jumpCol;
    public Object addtionalInfo;
    /** 出力データのフォーマット形式(複数のフォーマットを出力できるコンパイラ向けの識別情報となります) */
    public String formatType;
}
