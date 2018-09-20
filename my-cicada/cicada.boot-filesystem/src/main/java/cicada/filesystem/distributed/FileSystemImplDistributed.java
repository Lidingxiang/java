package cicada.filesystem.distributed;

import cicada.core.Guard;
import cicada.filesystem.FileSystem;
import java.io.IOException;
import java.util.Map;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSystemImplDistributed implements FileSystem {
    private static final Logger log = LoggerFactory.getLogger(FileSystemImplDistributed.class);
    private final String serverConfigName = "Cicada.FileSystem.Distributed.Server";
    private final String groupNameConfigName = "Cicada.FileSystem.Distributed.GroupName";
    private final String pathUrlPrefix = "Cicada.FileSystem.UrlPrefix";
    private Map<String, String> _configurationDataRespository;
    private String _groupName;

    public FileSystemImplDistributed(Map<String, String> configurationDataRespository) throws Exception {
        this._configurationDataRespository = configurationDataRespository;
        this.initFastDfs();
        this._groupName = (String)configurationDataRespository.get("Cicada.FileSystem.Distributed.GroupName");
        if (this._groupName == null || this._groupName.isEmpty()) {
            throw new Exception(String.format("请为分布式文件系统设置组名称，请配置%s节点", "Cicada.FileSystem.Distributed.GroupName"));
        }
    }

    public String upload(byte[] data, String fileExt) throws Exception {
        String result = this.upload(data, fileExt, 0);
        return result;
    }

    public String upload(byte[] data, String fileExt, int resultPathType) throws Exception {
        Guard.ThrowIfArgumentIsNull(data, "data");
        Guard.ThrowIfArgumentIsNull(fileExt, "fileExt");
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient client = new StorageClient(trackerServer, (StorageServer)storageServer);
        String[] fileInfo = client.upload_file(this._groupName, data, fileExt, (NameValuePair[])null);
        if (fileInfo == null) {
            return null;
        } else {
            String result = String.format("%s/%s", fileInfo[0], fileInfo[1]);
            if (resultPathType != 0) {
                String temp = (String)this._configurationDataRespository.get("Cicada.FileSystem.UrlPrefix");
                if (temp != null && !temp.isEmpty()) {
                    result = String.format("%s/%s", temp, result);
                } else {
                    log.error(String.format("将文件路径转换为绝对路径时出现错误，错误原因是没有配置Url前缀，请通过配置文件配置%s节点", "Cicada.FileSystem.UrlPrefix"));
                }
            }

            return result;
        }
    }

    public byte[] download(String fileName) throws Exception {
        Guard.ThrowIfArgumentIsNullOrEmpty(fileName, "fileName");
        FileSystemImplDistributed.FilePath filePath = new FileSystemImplDistributed.FilePath(fileName);
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, (StorageServer)storageServer);
        String groupName = filePath.getGroupName();
        String storageFileName = filePath.getStorageFileName();
        byte[] result = storageClient.download_file(groupName, storageFileName);
        return result;
    }

    public boolean remove(String fileName) throws Exception {
        Guard.ThrowIfArgumentIsNullOrEmpty(fileName, "fileName");
        FileSystemImplDistributed.FilePath filePath = new FileSystemImplDistributed.FilePath(fileName);
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        String groupName = filePath.getGroupName();
        String storageFileName = filePath.getStorageFileName();
        StorageClient storageClient = new StorageClient(trackerServer, (StorageServer)storageServer);
        int result = storageClient.delete_file(groupName, storageFileName);
        if (result == 0) {
            return true;
        } else {
            log.info(String.format("删除失败:状态码为%s", result));
            return false;
        }
    }

    private void initFastDfs() throws Exception {
        String text = (String)this._configurationDataRespository.get("Cicada.FileSystem.Distributed.Server");
        if (text != null && !text.isEmpty()) {
            try {
                ClientGlobal.initByTrackers(text);
            } catch (Exception var3) {
                throw new Exception(String.format("您配置的分布式文件系统服务器路径无效，请配置%s节点", "Cicada.FileSystem.Distributed.Server"));
            }
        } else {
            throw new Exception(String.format("请为分布式文件系统设置服务器路径，请配置%s节点", "Cicada.FileSystem.Distributed.Server"));
        }
    }

    public String upload1(byte[] data, String fileName) throws IOException, MyException, Exception {
        return null;
    }

    public String upload1(byte[] data, String fileName, int resultPathType) throws IOException, MyException, Exception {
        return null;
    }

    private class FilePath {
        private String groupName;
        private String storageFileName;

        public String getGroupName() {
            return this.groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public String getStorageFileName() {
            return this.storageFileName;
        }

        public void setStorageFileName(String storageFileName) {
            this.storageFileName = storageFileName;
        }

        public FilePath(String fileName) {
            int num = fileName.indexOf(47);
            this.groupName = fileName.substring(0, num);
            this.storageFileName = fileName.substring(num + 1);
        }

        public String toString() {
            return this.groupName + '/' + this.storageFileName;
        }
    }
}