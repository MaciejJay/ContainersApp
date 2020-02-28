package com.containers.utilities.xssf;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class XlsxHelper {

    // przesyłanie loga
    public byte[] getLogo(String fileName) {
        byte[] bytes = new byte[0];
        try (InputStream is = new FileInputStream("src/main/resources/logo/" + fileName + ".jpeg");) {
            bytes = IOUtils.toByteArray(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            //todo :: exceptions
        }
        return bytes;
    }
}
