import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModuleClassLoader extends ClassLoader {

    private final Path classesDir;

    public ModuleClassLoader(Path classesDir) {
        this.classesDir = classesDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Path file = classesDir.resolve(name.replace('.', '/') + ".class");
        try {
            byte[] bytes = Files.readAllBytes(file);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        }
    }
}