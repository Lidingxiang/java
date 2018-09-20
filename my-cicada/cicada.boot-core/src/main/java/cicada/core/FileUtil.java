package cicada.core;


import java.io.*;

public class FileUtil {
    public FileUtil() {
    }

    public static String rootPath() {
        try {
            String path = FileUtil.class.getClassLoader().getResource("").getPath();
            return path;
        } catch (Exception var1) {
            return "";
        }
    }

    public static byte[] file2bytes(String filePath) throws FileNotFoundException, IOException {
        File file = new File(filePath);
        if (file != null && file.isFile()) {
            byte[] bytes = file2bytes(file);
            return bytes;
        } else {
            return null;
        }
    }

    public static byte[] file2bytes(File file) throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        Throwable var2 = null;

        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1000);
            Throwable var4 = null;

            try {
                byte[] bytes = new byte[1000];
                boolean var6 = true;

                int n;
                while((n = fileInputStream.read(bytes)) != -1) {
                    byteArrayOutputStream.write(bytes, 0, n);
                }

                byte[] buffer = byteArrayOutputStream.toByteArray();
                byte[] var8 = buffer;
                return var8;
            } catch (Throwable var31) {
                var4 = var31;
                throw var31;
            } finally {
                if (byteArrayOutputStream != null) {
                    if (var4 != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable var30) {
                            var4.addSuppressed(var30);
                        }
                    } else {
                        byteArrayOutputStream.close();
                    }
                }

            }
        } catch (Throwable var33) {
            var2 = var33;
            throw var33;
        } finally {
            if (fileInputStream != null) {
                if (var2 != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable var29) {
                        var2.addSuppressed(var29);
                    }
                } else {
                    fileInputStream.close();
                }
            }

        }
    }

    public static String file2string(String filePath) throws FileNotFoundException, IOException {
        File file = new File(filePath);
        if (file != null && file.isFile()) {
            byte[] bytes = file2bytes(file);
            return new String(bytes);
        } else {
            return null;
        }
    }

    public static String file2String(File file) throws FileNotFoundException, IOException {
        if (file != null && file.isFile()) {
            byte[] bytes = file2bytes(file);
            String result = new String(bytes);
            return result;
        } else {
            return null;
        }
    }

    public static boolean byte2file(byte[] bytes, String filePath) throws FileNotFoundException, IOException {
        File file = new File(filePath);
        boolean result = byte2file(bytes, file);
        return result;
    }

    public static boolean string2file(String content, File file) throws FileNotFoundException, IOException {
        byte[] bytes = content.getBytes();
        boolean result = byte2file(bytes, file);
        return result;
    }

    private static boolean byte2file(byte[] bytes, File file) throws FileNotFoundException, IOException {
        OutputStream outputStream = new FileOutputStream(file);
        Throwable var3 = null;

//        Throwable var6;
        boolean var6;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            Throwable var5 = null;

            try {
                bufferedOutputStream.write(bytes);
                var6 = true;
            } catch (Throwable var29) {
//                var6 = var29;
                var5 = var29;
                throw var29;
            } finally {
                if (bufferedOutputStream != null) {
                    if (var5 != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable var28) {
                            var5.addSuppressed(var28);
                        }
                    } else {
                        bufferedOutputStream.close();
                    }
                }

            }
        } catch (Throwable var31) {
            var3 = var31;
            throw var31;
        } finally {
            if (outputStream != null) {
                if (var3 != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable var27) {
                        var3.addSuppressed(var27);
                    }
                } else {
                    outputStream.close();
                }
            }

        }

        return (boolean)var6;
    }
}