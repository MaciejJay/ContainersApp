//package com.containers.service;
//
//import com.containers.model.ContainerDamage;
//import com.containers.model.StatusEnum;
//import com.containers.repository.ContainerDamageRepository;
//import com.containers.service.ContainerDamageService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import javax.transaction.Transactional;
//import java.time.LocalDate;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
//public class ContainerDamageServiceTest {
//
//    @Autowired
//    private ContainerDamageService sut;
//    @Autowired
//    private ContainerDamageRepository repository;
//
//    @Test
//    @Transactional
//    public void shouldReturnAllDamage() {
//        //when
//        Set<ContainerDamage> actual = sut.findAllDamage();
//        //then
//        assertThat(actual.size()).isEqualTo(1);
//    }
//
//    @Test
//    @Transactional
//    public void shouldAddNewDamageToContainer() {
//        //given
//        ContainerDamage newDamage = new ContainerDamage
//                (LocalDate.now(), StatusEnum.CONTAINER_USABLE, "Dziura w podlodze",
//                        null, null, null, null);
//
//        //when
//        ContainerDamage addDamage = sut.addNewContainerDamage(newDamage);
//        //then
//        assertThat(addDamage.getId()).isEqualTo(2);
//        assertThat(repository.getOne(addDamage.getId())).isNotNull();
//    }
//
//    @Test
//    @Transactional
//    public void shouldUpdateContainerDamage() {
//        //given
//        ContainerDamage newDamage = new ContainerDamage
//                (LocalDate.now(), StatusEnum.CONTAINER_UNUSABLE, "Uszkodzony rygiel",
//                        null, null, null, null);
//        //when
//
//        ContainerDamage containerDamage = sut.updateContainerDamage(newDamage);
//        System.out.println(containerDamage.getId());
//
//        //then
//        assertThat(containerDamage.getId()).isEqualTo(3);
//        assertThat(repository.findById(3L)).hasValue(newDamage);
//    }
//}