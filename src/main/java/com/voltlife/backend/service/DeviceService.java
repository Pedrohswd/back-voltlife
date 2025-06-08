package com.voltlife.backend.service;

import com.voltlife.backend.model.Device;
import com.voltlife.backend.model.House;
import com.voltlife.backend.model.Report;
import com.voltlife.backend.repository.DeviceRepository;
import com.voltlife.backend.repository.HouseRepository;
import com.voltlife.backend.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private HouseRepository houseRepository;
    @Autowired
    private ReportRepository reportRepository;

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

    public List<Report> getReportsByHouseId(Long houseId) {
        // 1. Busca todos os devices da casa
        List<Device> devices = deviceRepository.findByHouseId(houseId);

        // 2. Extrai os códigos (que correspondem ao id_dsp)
        List<String> idDsps = devices.stream()
                .map(Device::getCode)
                .collect(Collectors.toList());

        // 3. Busca os relatórios com base nos id_dsp
        return reportRepository.findByIdDspIn(idDsps);
    }

    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }
}
