package com.voltlife.backend.service;

import com.voltlife.backend.model.House;
import com.voltlife.backend.model.HouseUser;
import com.voltlife.backend.model.User;
import com.voltlife.backend.model.enuns.HouseRole;
import com.voltlife.backend.repository.HouseRepository;
import com.voltlife.backend.repository.HouseUserRepository;
import com.voltlife.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    private final HouseRepository houseRepository;
    private final UserRepository userRepository;
    private final HouseUserRepository houseUserRepository;

    public HouseService(HouseRepository houseRepository, UserRepository userRepository, HouseUserRepository houseUserRepository) {
        this.houseRepository = houseRepository;
        this.userRepository = userRepository;
        this.houseUserRepository = houseUserRepository;
    }

    public House createHouse(House house, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        House savedHouse = houseRepository.save(house);

        HouseUser association = new HouseUser();
        association.setHouse(savedHouse);
        association.setUser(user);
        association.setRole(HouseRole.PROPRIETARIO);

        houseUserRepository.save(association);

        return savedHouse;
    }

    public HouseUser addGuestToHouse(Long houseId, String email) {
        House house = houseRepository.findById(houseId)
                .orElseThrow(() -> new RuntimeException("Casa não encontrada"));

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Verifica se já existe vínculo
        houseUserRepository.findByUserIdAndHouseId(user.getId(), houseId).ifPresent(hu -> {
            throw new RuntimeException("Usuário já está vinculado a essa casa");
        });

        HouseUser houseUser = new HouseUser();
        houseUser.setHouse(house);
        houseUser.setUser(user);
        houseUser.setRole(HouseRole.CONVIDADO);

        return houseUserRepository.save(houseUser);
    }

    public List<House> getHousesByUser(Long userId) {
        return houseRepository.findByUserId(userId);
    }

    public Optional<House> getById(Long id) {
        return houseRepository.findById(id);
    }

    public void deleteHouse(Long id) {
        houseRepository.deleteById(id);
    }

    public House updateHouse(Long id, House updated) {
        return houseRepository.findById(id).map(house -> {
            house.setNome(updated.getName());
            house.setAddress(updated.getAddress());
            return houseRepository.save(house);
        }).orElseThrow(() -> new RuntimeException("Casa não encontrada"));
    }
}
