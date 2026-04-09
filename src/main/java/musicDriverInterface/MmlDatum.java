package musicDriverInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MmlDatum implements Serializable {

    public enum MMLType {
        Unknown,
        /** ! */
        CompileSkip,
        /** T */
        Tempo,
        /** @ */
        Instrument,
        /** v */
        Volume,
        /** V */
        TotalVolume,
        /** o */
        Octave,
        /** > */
        OctaveUp,
        /** < */
        OctaveDown,
        /** ) */
        VolumeUp,
        /** ( */
        VolumeDown,
        /** l */
        Length,
        /** # */
        LengthClock,
        /** p */
        Pan,
        /** D */
        Detune,
        /** DON DOF */
        DirectMode,
        /** m */
        PcmMode,
        /** mon mof */
        PcmMap,
        /** q */
        Gatetime,
        /** Q */
        GatetimeDiv,
        /** E */
        Envelope,
        /** EX */
        ExtendChannel,
        /** EH */
        HardEnvelope,
        /** L */
        LoopPoint,
        /** [ */
        Repeat,
        /** ] */
        RepeatEnd,
        /** { */
        Renpu,
        /** } */
        RenpuEnd,
        /** / */
        RepertExit,
        /** M */
        Lfo,
        /** S */
        LfoSwitch,
        /** y */
        Y,
        /** w */
        Noise,
        /** P */
        NoiseToneMixer,
        /** K */
        KeyShift,
        /** A */
        AddressShift,
        /** CH */
        MIDICh,
        /** CC */
        MIDIControlChange,
        /** c d e f g a b */
        Note,
        /** r */
        Rest,
        /** R */
        RestNoWork,
        /** _ */
        Bend,
        /** & */
        Tie,
        /** ^ */
        TiePC,
        /** ~ */
        TieMC,
        /** , 0 */
        ToneDoubler,
        /** " */
        Lyric,
        /** so sf */
        SusOnOff,
        /** J */
        JumpPoint,
        /** U */
        Velocity,
        /** Special commands for playing from the caret position */
        SkipPlay,
        /** wf */
        DCSGCh3Freq,
        /** Locator for trace function */
        TraceLocate,
        /** C */
        ClockCounter,
        /** \@v */
        RelativeVolumeSetting,
        /** X */
        Effect,
        /** */
        Synchronous,
        /** APON APOF AP */
        Arpeggio,
        /** PRON PROF */
        PhaseReset,
        /** F */
        ForcedFnum,
        /** Updated information stack for trace function */
        TraceUpdateStack,
//    /** Pop to the trace function information stack */
//    TracePop,
        /** IDE-specific features Commands for identification */
        IDE,
        /** PDON PDOF */
        PageDirectSend,
        /** KD Key-on Delay */
        KeyOnDelay,
        /** HS.. Hardware envelope Sync */
        HardEnvelopeSync,
        /** PRV opposite phase */
        ReversePhase,
        /** Modulation */
        Modulation,
        /** Part Color */
        PartColor,
        /** Portamento */
        Portament,
        /** Part-by-part replace command start */
        ReplaceByParts_Start,
        /** Part-by-part replace commands */
        ReplaceByParts,
        /** Part-by-part replace command completed */
        ReplaceByParts_End,
        /** Part Arpeggio Start */
        PartArpeggio_Start,
        /** Part Arpeggio End */
        PartArpeggio_End,
        /** Synchronized parameter reset signal during playback */
        ResetPlaySync,
        /** TTON, TTOF */
        RR15,
        /** For SoftLFO and other command drivers */
        HardLFO,
        /** Actual LFO change value */
        LFODelta,
        /** For VOP commands */
        VOperator,
        /** For TLOFSset command */
        TLOFS,
        /** VGON.VGOF */
        VGuard,
        /** PP */
        PartPriority,
    }

    public MMLType type = MMLType.Unknown;
    public List<Object> args = null;
    public int dat = 0;
    public LinePos linePos = null;

    /** for deserialize */
    public MmlDatum() {
    }

    public MmlDatum(int dat) {
        assert dat >= 0 : String.valueOf(dat); // TODO should be unsigned byte, add `&& dat < 255`
        this.dat = dat;
    }

    public MmlDatum(MMLType type, List<Object> args, LinePos linePos, int dat) {
        assert dat >= 0 : String.valueOf(dat); // TODO should be unsigned byte, add `&& dat < 255`
        this.type = type;
        this.args = args;
        this.linePos = linePos;
        this.dat = dat;
    }

    public MmlDatum(int dat, MMLType type, LinePos linePos, Object... args) {
        assert dat >= 0 : String.valueOf(dat); // TODO should be unsigned byte, add `&& dat < 255`
        this.type = type;
        this.args = args != null ? new ArrayList<>(Arrays.asList(args)) : null;
        this.linePos = linePos;
        this.dat = dat;
    }

    @Override
    public String toString() {
        return "type:%s args:%s linePos:[ %s ]".formatted(type, args, linePos);
    }
}
