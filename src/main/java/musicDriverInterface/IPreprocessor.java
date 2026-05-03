package musicDriverInterface;

import java.io.InputStream;
import java.util.function.Function;


public interface IPreprocessor extends IInterface {

    void Preprocess(
            InputStream sourceMML,
            InputStream destMML,
            Function<String, InputStream> appendFileReaderCallback
    );

    void init();

    PreprocessorInfo getPreprocessorInfo();
}
