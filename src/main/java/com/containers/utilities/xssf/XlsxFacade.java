package com.containers.utilities.xssf;

import com.containers.service.ContainerDamageService;
import com.containers.service.ContainerService;
import com.containers.service.ShipownerService;
import com.containers.service.UserService;
import lombok.SneakyThrows;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class XlsxFacade {

    private ContainerService containerService;
    private ContainerDamageService damageService;
    private UserService userService;
    private ShipownerService shipownerService;

    public XlsxFacade(ContainerService containerService, ContainerDamageService damageService, UserService userService, ShipownerService shipownerService) {
        this.containerService = containerService;
        this.damageService = damageService;
        this.userService = userService;
        this.shipownerService = shipownerService;
    }

    public String getShipownerPrefix(Long id) {
        return shipownerService.getShipownerById(id).getPrefix();
    }

    public String getContainerSerialNo(String noContainer) {
        return containerService.findContainerById(noContainer).getNoContainer();
    }

    @SneakyThrows
    public byte[] getLogo(String fileName) {
        InputStream is = new FileInputStream("src/main/resources/logo/" + fileName + ".jpeg");
        byte[] bytes = IOUtils.toByteArray(is);
        is.close();
        return bytes;
    }
}
