package com.voltlife.backend.config;

import com.voltlife.backend.model.Device;
import com.voltlife.backend.model.House;
import com.voltlife.backend.model.User;
import com.voltlife.backend.model.dtos.UserDTO;
import com.voltlife.backend.model.enuns.Category;
import com.voltlife.backend.repository.DeviceRepository;
import com.voltlife.backend.service.HouseService;
import com.voltlife.backend.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TestConfig {
    @Autowired
    private UserService userService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private DeviceRepository deviceRepository;


    @PostConstruct
    public void instanciaDB(){
        UserDTO user = new UserDTO();
        user.setEmail("test@gmail.com");
        user.setPassword("123456");
        user.setDate("test");
        user.setName("test");
        user.setRole("USER");
        userService.save(user);

        user.setEmail("test2@gmail.com");
        user.setPassword("123456");
        user.setDate("test");
        user.setName("test");
        user.setRole("USER");
        User user2 = new User();
        user2 = userService.save(user);

        House house = new House();
        house.setName("Casa familia");
        house.setPostalCode("75460000");
        house.setDistrict("São José");
        house.setStreet("Avenida Timbiras");
        house.setCity("Nerópolis");
        house.setState("Goiás");
        house.setCountry("Brasil");
        house.setNumber("SN");
        houseService.createHouse(house,user2.getId());

        Device device = new Device();
        device.setName("Chuveiro");
        device.setCategory(Category.ELETRODOMESTICO);
        device.setMark("philco");
        device.setModel("22de");
        device.setCode("CHUVEIRO");
        device.setHouse(house);
        device.setVoltage(220);
        device.setMonthlyConsumption(70);
        device.setAnnualConsumption(840.00);
        deviceRepository.save(device);

        Device device2 = new Device();
        device2.setName("Ar Condicionado");
        device2.setCategory(Category.CLIMATIZACAO_CONFORTO);
        device2.setMark("elgin");
        device2.setModel("22123");
        device2.setCode("ARCONDICIONADO");
        device2.setHouse(house);
        device2.setVoltage(220);
        device2.setMonthlyConsumption(5);
        device2.setAnnualConsumption(120.00);
        deviceRepository.save(device2);
    }

}
