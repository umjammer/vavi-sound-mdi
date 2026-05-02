package musicDriverInterface;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;
import java.util.function.Function;


public interface ICompiler extends IInterface {

    void init();

    MmlDatum[] compile(
            InputStream sourceMML,
            Function<String, InputStream> appendFileReaderCallback
    );

    CompilerInfo getCompilerInfo();

    void setCompileSwitch(Object... param);

    static ICompiler factory(String className) {
        for (ICompiler compiler : ServiceLoader.load(ICompiler.class)) {
            if (compiler.getClass().getName().equals(className)) {
                return compiler;
            }
        }
        throw new NoSuchElementException(className);
    }
}
