package org.example.spzx.manager.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Romic
 * @date 2024/12/22
 * @description
 */
public interface FileUploadService {
    String fileUpload(MultipartFile multipartFile);
}
