import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.nio.file.Path;

public class ModuleCompiler {

    public static boolean compile(Path source, Path outputDir) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null,
                "-d", outputDir.toString(), source.toString());
        return result == 0;
    }
}