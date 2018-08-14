package com.onlineclasses.demo.service;

import java.io.IOException;

import com.onlineclasses.demo.dao.ProductRepository;
import com.onlineclasses.demo.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
/**
 * Created by jt on 7/3/17.
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {


    private final ProductRepository productRepository;

    public ImageServiceImpl( ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(Long id, MultipartFile file) {

        try {
            Product product = productRepository.findById(id).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            product.setImage(byteObjects);

            productRepository.save(product);
        } catch (IOException e) {
            //todo handle better
                e.printStackTrace();
        }
    }
}
