import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args)
    {
        try {
            String root = "D:\\Data\\";
            searchPath(root);
        }
        catch(Exception ex){

        }
    }

    public static void searchPath(String root) throws Exception{
        Files.list(Paths.get(root)).forEach(path -> {
            try {
                if(path.toFile().isDirectory()) {
                    log(String.valueOf(path));
                    searchPath(String.valueOf(path));
                }
                else{
                    log("found file:" + path.toFile().getName());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
    public static void log(String msg){
        System.out.println(msg);
    }
}
