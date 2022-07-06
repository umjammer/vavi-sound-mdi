package musicDriverInterface;

public class InstanceMarker {

    public void loadCompilerDll(String compilerDllFullPath) {
    }

    public ICompiler getCompiler(String compilerFullNameSpaceInstance) {
        return null;
    }

    public void loadDriverDll(String driverDllFullPath) {
    }

    public IDriver getDriver(String driverFullNameSpaceInstance) {
        return null;
    }

    public void loadPreprocessorDll(String preprocessorDllFullPath) {
    }

    public IPreprocessor getPreprocessor(String preprocessorFullNameSpaceInstance) {
        return null;
    }
}
