package musicDriverInterface;

import java.util.function.Function;

import dotnet4j.io.Stream;


public interface iPreprocessor extends iInterface {

    void Preprocess(
            Stream sourceMML,
            Stream destMML,
            Function<String, Stream> appendFileReaderCallback
    );

    void Init();

    PreprocessorInfo GetPreprocessorInfo();
}
