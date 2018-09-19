package com.ly.bll.unity;

import cicada.core.BeanFactory;
import cicada.filesystem.FileSystem;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

    public String upload(MultipartFile file) throws Exception {
        FileSystem fileSystem = BeanFactory.getBeanByType(FileSystem.class);
        String ext_Name = file.getOriginalFilename().split("\\.")[1];
        return upload(file, ext_Name, fileSystem);
    }

    private String upload(MultipartFile file, String extName, FileSystem fileSystem) throws Exception {
        byte[] bytes = file.getBytes();

        if (fileSystem != null) {
            String result = fileSystem.upload(bytes, extName, 1);
            return result;
        }
        return null;
    }
}
