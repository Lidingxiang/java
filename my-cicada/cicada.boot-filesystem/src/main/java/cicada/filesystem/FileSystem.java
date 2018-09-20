package cicada.filesystem;


import java.io.IOException;
import org.csource.common.MyException;

public interface FileSystem {
    String upload(byte[] var1, String var2) throws IOException, MyException, Exception;

    String upload1(byte[] var1, String var2) throws IOException, MyException, Exception;

    String upload(byte[] var1, String var2, int var3) throws IOException, MyException, Exception;

    String upload1(byte[] var1, String var2, int var3) throws IOException, MyException, Exception;

    byte[] download(String var1) throws IOException, MyException, Exception;

    boolean remove(String var1) throws Exception;
}
