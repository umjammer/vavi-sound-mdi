package musicDriverInterface;

import java.util.function.Function;

import dotnet4j.io.Stream;


public interface IPreprocessor extends IInterface {

    void Preprocess(
            Stream sourceMML,
            Stream destMML,
            Function<String, Stream> appendFileReaderCallback
    );

    void init();

    PreprocessorInfo getPreprocessorInfo();
}
