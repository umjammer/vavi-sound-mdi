package musicDriverInterface;

import java.util.function.Function;

import dotnet4j.io.Stream;


public interface iCompiler extends iInterface {
    void Init();

    MmlDatum[] Compile(
            Stream sourceMML,
            Function<String, Stream> appendFileReaderCallback
    );

    CompilerInfo GetCompilerInfo();

    void SetCompileSwitch(Object... param);
}
