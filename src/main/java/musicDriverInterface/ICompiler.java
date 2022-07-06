package musicDriverInterface;

import java.util.function.Function;

import dotnet4j.io.Stream;


public interface ICompiler extends IInterface {
    void init();

    MmlDatum[] compile(
            Stream sourceMML,
            Function<String, Stream> appendFileReaderCallback
    );

    CompilerInfo getCompilerInfo();

    void setCompileSwitch(Object... param);
}
