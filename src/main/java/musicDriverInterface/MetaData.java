package musicDriverInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;


public class MetaData {

    public enum Tag {
        NumberOfSongs,

        Title,
        TitleJ,
        SubTitle,
        SubTitleJ,

        Composer,
        ComposerJ,
        Arranger,
        ArrangerJ,
        Lyricist,
        LyricistJ,
        Singer,
        SingerJ,
        Mixer,
        MixerJ,
        Artist,
        ArtistJ,
        Converter,
        ConverterJ,
        MimiCopy,
        MimiCopyJ,
        Member,
        MemberJ,

        GameTitle,
        GameTitleJ,
        GameSystem,
        GameSystemJ,
        Maker,
        MakerJ,
        Developer,
        DeveloperJ,

        DevelopeDate,
        ReleaseDate,
        Duration,

        Memo,
        Note,
        Remark,
        Lyric,
        LyricJ,

        Chip,
        Module,
        InstrumentMap,

        MailAdr,
        SNSAdr,
        WebPageURL,

        SongSrcFilename,
        SongSrcFileType,
        SongObjFilename,
        SongObjFileType,
        PcmFilename,
        BulkDataFilename,
        FlierFilename,
        MovieFilename,
        WrdFilename,

        CompilerName,
        BuildCompilerVersion,
        RequestCompilerVersion,
        DriverName,
        BuildDriverVersion,
        RequestDriverVersion,
        PreprocessorName,
        BuildPreprocessorVersion,
        RequestPreprocessorVersion,
        PlayerName,
        BuildPlayerVersion,
        RequestPlayerVersion,

        SongSrcVersion,
        SongObjVersion,

        // Embedded systems
        Artwork,
    }

    private final Map<Tag, List<String>> items = new HashMap<>();

    /** @return empty when not found value of the key */
    public String getFirst(Tag tag) {
        return items.containsKey(tag) ? items.get(tag).getFirst() : "";
    }

    public List<String> getAll(Tag tag) {
        return items.getOrDefault(tag, Collections.emptyList());
    }

    public void add(Tag tag, String string) {
        items.putIfAbsent(tag, new ArrayList<>());
        items.get(tag).add(string);
    }

    public void set(Tag tag, String string) {
        if (items.containsKey(tag)) items.get(tag).clear();
        add(tag, string);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MetaData.class.getSimpleName() + "[", "]")
                .add("TrackName='" + items.get(Tag.Title) + "'")
                .add("TrackNameJ='" + items.get(Tag.TitleJ) + "'")
                .add("GameName='" + items.get(Tag.GameTitle) + "'")
                .add("GameNameJ='" + items.get(Tag.GameTitleJ) + "'")
                .add("SystemName='" + items.get(Tag.GameSystem) + "'")
                .add("SystemNameJ='" + items.get(Tag.GameSystemJ) + "'")
                .add("Composer='" + items.get(Tag.Composer) + "'")
                .add("ComposerJ='" + items.get(Tag.ComposerJ) + "'")
                .add("Converted='" + items.get(Tag.Maker) + "'")
                .add("Notes='" + items.get(Tag.Note) + "'")
                .add("VGMBy='" + items.get(Tag.Developer) + "'")
                .add("Version='" + items.get(Tag.SongSrcVersion) + "'")
                .add("UsedChips='" + items.get(Tag.Chip) + "'")
                .toString();
    }
}
