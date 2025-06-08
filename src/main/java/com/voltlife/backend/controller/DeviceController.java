package com.voltlife.backend.controller;

import com.voltlife.backend.model.Device;
import com.voltlife.backend.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @PostMapping
    public ResponseEntity<Device> create(@RequestBody Device device,
                                         @RequestParam Long houseId) {
        Device created = deviceService.create(device, houseId);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/house/{houseId}")
    public ResponseEntity<List<Device>> getByHouse(@PathVariable Long houseId) {
        return ResponseEntity.ok(deviceService.getDevicesByHouse(houseId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getById(@PathVariable Long id) {
        return deviceService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> update(@PathVariable Long id,
                                         @RequestBody Device device) {
        return ResponseEntity.ok(deviceService.update(id, device));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deviceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
