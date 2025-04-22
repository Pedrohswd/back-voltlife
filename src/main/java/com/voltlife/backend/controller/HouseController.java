package com.voltlife.backend.controller;

import com.voltlife.backend.model.House;
import com.voltlife.backend.model.HouseUser;
import com.voltlife.backend.service.HouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping
    public ResponseEntity<House> create(@RequestBody House house, @RequestParam Long userId) {
        House created = houseService.createHouse(house, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<House>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(houseService.getHousesByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<House> getById(@PathVariable Long id) {
        return houseService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<House> update(@PathVariable Long id, @RequestBody House house) {
        return ResponseEntity.ok(houseService.updateHouse(id, house));
    }

    @PostMapping("/{houseId}/add-guest")
    public ResponseEntity<HouseUser> addGuest(@PathVariable Long houseId,
                                              @RequestParam String email) {
        HouseUser houseUser = houseService.addGuestToHouse(houseId, email);
        return ResponseEntity.ok(houseUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        houseService.deleteHouse(id);
        return ResponseEntity.noContent().build();
    }
}

