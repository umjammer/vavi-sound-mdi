package musicDriverInterface;

public class InstanceMarker {

    public void LoadCompilerDll(String compilerDllFullPath) {
    }

    public iCompiler GetCompiler(String compilerFullNameSpaceInstance) {
        return null;
    }

    public void LoadDriverDll(String driverDllFullPath) {
    }

    public iDriver GetDriver(String driverFullNameSpaceInstance) {
        return null;
    }

    public void LoadPreprocessorDll(String preprocessorDllFullPath) {
    }

    public iPreprocessor GetPreprocessor(String preprocessorFullNameSpaceInstance) {
        return null;
    }
}
