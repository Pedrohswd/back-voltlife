package com.voltlife.backend.config;

import com.voltlife.backend.model.Device;
import com.voltlife.backend.model.House;
import com.voltlife.backend.model.User;
import com.voltlife.backend.model.dtos.UserDTO;
import com.voltlife.backend.model.enuns.Category;
import com.voltlife.backend.service.DeviceService;
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
    private DeviceService deviceService;


    @PostConstruct
    public void instanciaDB(){
        UserDTO user = new UserDTO();
        user.setEmail("test@gmail.com");
        user.setPassword("123456");
        user.setDate("test");
        user.setName("test");
        user.setRole("ADMIN");
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
        device.setVoltage(220);
        device.setMonthlyConsumption(70);
        device.setAnnualConsumption(840.00);
        deviceService.create(device,house.getId());
    }

}
