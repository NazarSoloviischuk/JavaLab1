import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws Exception {
        Path source = Path.of("module", "TestModule.java");
        Path outputDir = Path.of("compiled");
        Files.createDirectories(outputDir);

        long lastModified = -1;

        while (true) {
            long current = Files.getLastModifiedTime(source).toMillis();

            if (current != lastModified) {
                lastModified = current;

                if (ModuleCompiler.compile(source, outputDir)) {
                    ModuleClassLoader loader = new ModuleClassLoader(outputDir);
                    Class<?> clazz = loader.loadClass("TestModule");
                    Object t = clazz.getDeclaredConstructor().newInstance();
                    System.out.println(t);
                } else {
                    System.out.println("Помилка компіляції");
                }
            }

            Thread.sleep(1000);
        }
    }
}