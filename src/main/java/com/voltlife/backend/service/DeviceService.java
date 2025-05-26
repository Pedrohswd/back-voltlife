package com.voltlife.backend.service;

import com.voltlife.backend.model.Device;
import com.voltlife.backend.model.House;
import com.voltlife.backend.repository.DeviceRepository;
import com.voltlife.backend.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final HouseRepository houseRepository;

    public DeviceService(DeviceRepository deviceRepository, HouseRepository houseRepository) {
        this.deviceRepository = deviceRepository;
        this.houseRepository = houseRepository;
    }

    public Device create(Device device, Long houseId) {
        House house = houseRepository.findById(houseId)
                .orElseThrow(() -> new RuntimeException("Casa não encontrada"));

        device.setHouse(house);
        Device saved = deviceRepository.save(device);

        String generatedCode = (device.getName() + "-" + saved.getId()).toUpperCase().replaceAll("\\s+", "-");
        saved.setCode(generatedCode);

        return deviceRepository.save(saved);
    }

    public List<Device> getDevicesByHouse(Long houseId) {
        return deviceRepository.findByHouseId(houseId);
    }

    public Optional<Device> getById(Long id) {
        return deviceRepository.findById(id);
    }

    public Device update(Long id, Device updated) {
        return deviceRepository.findById(id).map(device -> {
            device.setName(updated.getName());
            device.setMark(updated.getMark());
            device.setModel(updated.getModel());
            device.setVoltage(updated.getVoltage());
            device.setMonthlyConsumption(updated.getMonthlyConsumption());
            device.setAnnualConsumption(updated.getAnnualConsumption());
            device.setCategory(updated.getCategory());
            return deviceRepository.save(device);
        }).orElseThrow(() -> new RuntimeException("Dispositivo não encontrado"));
    }

    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }
}
