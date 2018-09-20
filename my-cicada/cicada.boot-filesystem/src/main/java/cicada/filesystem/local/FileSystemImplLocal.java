package cicada.filesystem.local;


import cicada.core.FileUtil;
import cicada.core.Guard;
import cicada.filesystem.FileSystem;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import org.csource.common.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSystemImplLocal implements FileSystem {
    private static final Logger log = LoggerFactory.getLogger(FileSystemImplLocal.class);
    private final String rootConfigName = "Cicada.FileSystem.Local.Root";
    private String _root;

    public FileSystemImplLocal(Map<String, String> configurationDataRespository) throws Exception {
        this._root = (String)configurationDataRespository.get("Cicada.FileSystem.Local.Root");
        if (this._root != null && !this._root.isEmpty()) {
            String projectRoot = FileUtil.rootPath();
            StringBuffer sb = new StringBuffer();
            this._root = sb.append(projectRoot).append(this._root).toString();
        } else {
            throw new Exception(String.format("请为本地文件系统设置根目录，请配置%s节点", "Cicada.FileSystem.Local.Root"));
        }
    }

    public String upload(byte[] data, String fileExt) throws Exception {
        String result = this.upload(data, fileExt, 0);
        return result;
    }

    public String upload1(byte[] data, String fileName) throws IOException, MyException, Exception {
        String result = this.upload(data, fileName, 0);
        return result;
    }

    public String upload(byte[] data, String fileExt, int resultPathType) throws Exception {
        Guard.ThrowIfArgumentIsNull(data, "data");
        Guard.ThrowIfArgumentIsNullOrEmpty(fileExt, "fileExt");
        SimpleDateFormat sdf = new SimpleDateFormat(String.format("yyyy%sMM%sdd", File.separator, File.separator));
        String path = sdf.format(new Date());
        path = this._root + File.separator + path;
        File filePath = new File(path);
        if (!filePath.exists() && !filePath.mkdirs()) {
            return null;
        } else {
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String fileName = uuid + "." + fileExt;
            fileName = path + File.separator + fileName;
            File temp = new File(fileName);
            if (temp.exists()) {
                temp.delete();
            }

            boolean result = temp.createNewFile();
            if (!result) {
                return null;
            } else {
                BufferedOutputStream stream = null;

                try {
                    stream = new BufferedOutputStream(new FileOutputStream(temp));
                    stream.write(data);
                } catch (Exception var16) {
                    log.error("文件上传错误", var16);
                } finally {
                    stream.close();
                }

                return resultPathType == 0 ? fileName.replace(this._root, "") : fileName;
            }
        }
    }

    public String upload1(byte[] data, String fileName, int resultPathType) throws IOException, MyException, Exception {
        Guard.ThrowIfArgumentIsNull(data, "data");
        Guard.ThrowIfArgumentIsNullOrEmpty(fileName, "fileName");
        SimpleDateFormat sdf = new SimpleDateFormat(String.format("yyyy%sMM%sdd", File.separator, File.separator));
        String path = sdf.format(new Date());
        path = this._root + File.separator + path;
        File filePath = new File(path);
        if (!filePath.exists() && !filePath.mkdirs()) {
            return null;
        } else {
            fileName = path + File.separator + fileName;
            File temp = new File(fileName);
            if (temp.exists()) {
                temp.delete();
            }

            boolean result = temp.createNewFile();
            if (!result) {
                return null;
            } else {
                BufferedOutputStream stream = null;

                try {
                    stream = new BufferedOutputStream(new FileOutputStream(temp));
                    stream.write(data);
                } catch (Exception var14) {
                    log.error("文件上传错误", var14);
                    var14.printStackTrace();
                } finally {
                    stream.close();
                }

                return resultPathType == 0 ? fileName.replace(this._root, "") : fileName;
            }
        }
    }

    public byte[] download(String fileName) throws Exception {
        Guard.ThrowIfArgumentIsNull(fileName, "fileName");
        String physicsPath = this._root + File.separator + fileName;
        File file = new File(physicsPath);
        if (file.exists()) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int)file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                int buf_size = 1024;
                byte[] buffer = new byte[buf_size];
                boolean var8 = false;

                int len;
                while(-1 != (len = in.read(buffer, 0, buf_size))) {
                    bos.write(buffer, 0, len);
                }

                byte[] var9 = bos.toByteArray();
                return var9;
            } catch (IOException var13) {
                var13.printStackTrace();
                return null;
            } finally {
                if (in != null) {
                    in.close();
                }

                if (bos != null) {
                    bos.close();
                }

            }
        } else {
            return null;
        }
    }

    public boolean remove(String fileName) throws Exception {
        Guard.ThrowIfArgumentIsNull(fileName, "fileName");
        String physicsPath = this._root + File.separator + fileName;
        File file = new File(physicsPath);
        return !file.exists() ? true : file.delete();
    }
}
