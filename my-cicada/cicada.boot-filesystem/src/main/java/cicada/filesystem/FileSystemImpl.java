package cicada.filesystem;

import cicada.core.PropertyResolverCustom;
import cicada.core.config.ConfigManager;
import cicada.filesystem.distributed.FileSystemImplDistributed;
import cicada.filesystem.local.FileSystemImplLocal;
import java.io.IOException;
import java.util.Map;
import org.csource.common.MyException;
import org.springframework.stereotype.Component;

@Component
public class FileSystemImpl implements FileSystem {
    private final String typeConfigName = "Cicada.FileSystem.Type";
    private FileSystem _fileSystem = null;

    public FileSystemImpl() throws Exception {
        String cicadaPath = ConfigManager.getCicadaConfigPath();
        Map<String, String> configurationDataRespository = PropertyResolverCustom.getConfigProperties(cicadaPath);
        String text = (String)configurationDataRespository.get("Cicada.FileSystem.Type");
        if (text == null || text.isEmpty()) {
            text = "local";
        }

        text = text.toLowerCase();
        if (text.equals("local")) {
            this._fileSystem = new FileSystemImplLocal(configurationDataRespository);
        } else if (text.equals("distributed")) {
            this._fileSystem = new FileSystemImplDistributed(configurationDataRespository);
        } else {
            throw new Exception(String.format("您配置的文件系统类型无效，请配置%s节点", "Cicada.FileSystem.Type"));
        }
    }

    public String upload(byte[] data, String fileExt) throws Exception {
        return this._fileSystem.upload(data, fileExt, 0);
    }

    public String upload1(byte[] data, String fileName) throws IOException, MyException, Exception {
        return this._fileSystem.upload1(data, fileName, 0);
    }

    public String upload(byte[] data, String fileExt, int resultPathType) throws Exception {
        return this._fileSystem.upload(data, fileExt, resultPathType);
    }

    public String upload1(byte[] data, String fileName, int resultPathType) throws IOException, MyException, Exception {
        return this._fileSystem.upload1(data, fileName, resultPathType);
    }

    public byte[] download(String fileName) throws IOException, MyException, Exception {
        return this._fileSystem.download(fileName);
    }

    public boolean remove(String fileName) throws Exception {
        return this._fileSystem.remove(fileName);
    }
}
