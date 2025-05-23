package com.voltlife.backend.service;

import com.voltlife.backend.model.House;
import com.voltlife.backend.model.HouseUser;
import com.voltlife.backend.model.User;
import com.voltlife.backend.model.dtos.HouseDTO;
import com.voltlife.backend.model.dtos.HouseUserDTO;
import com.voltlife.backend.model.enuns.HouseRole;
import com.voltlife.backend.repository.HouseRepository;
import com.voltlife.backend.repository.HouseUserRepository;
import com.voltlife.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        houseUserRepository.findByUserIdAndHouseId(user.getId(), houseId).ifPresent(hu -> {
            throw new RuntimeException("Usuário já está vinculado a essa casa");
        });

        HouseUser houseUser = new HouseUser();
        houseUser.setHouse(house);
        houseUser.setUser(user);
        houseUser.setRole(HouseRole.CONVIDADO);

        return houseUserRepository.save(houseUser);
    }

    public void removeGuestToHouse(Long houseId, String email) {
        House house = houseRepository.findById(houseId)
                .orElseThrow(() -> new RuntimeException("Casa não encontrada"));

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        houseUserRepository.findByUserIdAndHouseId(user.getId(), houseId)
                .ifPresentOrElse(hu -> houseUserRepository.delete(hu), () -> {
                    throw new RuntimeException("Usuário não é vinculado a essa casa");
                });

    }

    public List<HouseDTO> getHousesByUser(Long userId) {
        List<House> houses = houseRepository.findByUserId(userId);

        return houses.stream().map(h -> {
            List<HouseUserDTO> users = h.getUsers().stream().map(hu -> {
                User u = hu.getUser();
                return new HouseUserDTO(hu.getId(), hu.getUser().getEmail(), hu.getRole().toString());
            }).collect(Collectors.toList());

            return new HouseDTO(
                    h.getId(), h.getName(), h.getCep(), h.getStreet(), h.getNumber(),
                    h.getDistrict(), h.getCity(), h.getState(), h.getCountry(), users
            );
        }).collect(Collectors.toList());
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
            house.setCep(updated.getCep());
            house.setCity(updated.getCity());
            house.setCountry(updated.getCountry());
            house.setDistrict(updated.getDistrict());
            house.setNumber(updated.getNumber());
            house.setState(updated.getState());
            house.setStreet(updated.getStreet());

            return houseRepository.save(house);
        }).orElseThrow(() -> new RuntimeException("Casa não encontrada"));
    }
}
