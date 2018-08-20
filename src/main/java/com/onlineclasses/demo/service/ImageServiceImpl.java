package com.onlineclasses.demo.service;

import com.onlineclasses.demo.dao.ProductRepository;
import com.onlineclasses.demo.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by jt on 7/3/17.
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {


    private final ProductRepository productRepository;

    public ImageServiceImpl( ProductRepository productService) {

        this.productRepository = productService;
    }

    @Override
    @Transactional
    public void saveImageFile(Long productId, MultipartFile file) {

        try {
            Product product = productRepository.findById(productId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            product.setImage(byteObjects);

            productRepository.save(product);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}
