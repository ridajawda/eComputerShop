package com.onlineclasses.demo.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jt on 7/3/17.
 */
public interface ImageService {

    void saveImageFile(Long productId, MultipartFile file);
}
