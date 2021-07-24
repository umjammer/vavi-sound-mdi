﻿namespace musicDriverInterface
{
    public enum enmMMLType
    {
        unknown,
        CompileSkip,      // !
        Tempo,            // T
        Instrument,       // @
        Volume,           // v
        TotalVolume,      // V
        Octave,           // o
        OctaveUp,         // >
        OctaveDown,       // <
        VolumeUp,         // )
        VolumeDown,       // (
        Length,           // l
        LengthClock,      // #
        Pan,              // p
        Detune,           // D
        DirectMode,       // DON DOF
        PcmMode,          // m
        PcmMap,           // mon mof
        Gatetime,         // q
        GatetimeDiv,      // Q
        Envelope,         // E
        ExtendChannel,    // EX
        HardEnvelope,     // EH
        LoopPoint,        // L
        Repeat,           // [
        RepeatEnd,        // ]
        Renpu,            // {
        RenpuEnd,         // }
        RepertExit,       // /
        Lfo,              // M
        LfoSwitch,        // S
        Y,                // y
        Noise,            // w
        NoiseToneMixer,   // P
        KeyShift,         // K
        AddressShift,     // A
        MIDICh,           // CH
        MIDIControlChange, // CC
        Note,             // c d e f g a b
        Rest,             // r
        RestNoWork,       // R
        Bend,             // _
        Tie,              // &
        TiePC,            // ^
        TieMC,            // ~
        ToneDoubler,      // , 0
        Lyric,            // "
        SusOnOff,         // so sf
        JumpPoint,        // J
        Velocity,         // U
        SkipPlay,         // caret位置からの演奏のための特殊コマンド
        DCSGCh3Freq,      // wf
        TraceLocate,      // トレース機能向けロケータ
        ClockCounter,     // C
        RelativeVolumeSetting, //@v
        Effect,           // X
        Synchronous,      // *
        Arpeggio,         // APON APOF AP
        PhaseReset,       // PRON PROF
        ForcedFnum,       // F
        TraceUpdateStack, // トレース機能向け 情報スタック更新
        //TracePop,       // トレース機能向け 情報スタックへpop
        IDE,              // IDE 独自機能 識別のためのコマンド
        PageDirectSend,   // PDON PDOF
        KeyOnDelay,       // KD キーオンディレイ
        HardEnvelopeSync, // HS.. Hardware envelope Sync
        ReversePhase,     // PRV 逆位相
        Modulation,       // モジュレーション
        PartColor,        // パートの色
        Portament,        // ポルタメント
    }
}
