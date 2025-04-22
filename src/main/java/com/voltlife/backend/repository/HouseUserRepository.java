package com.voltlife.backend.repository;

import com.voltlife.backend.model.HouseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HouseUserRepository extends JpaRepository<HouseUser, Long> {

    // Buscar vínculo por usuário e casa
    Optional<HouseUser> findByUserIdAndHouseId(Long userId, Long houseId);

    // Buscar todos os vínculos de um usuário
    List<HouseUser> findByUserId(Long userId);

    // Buscar todos os usuários vinculados a uma casa
    List<HouseUser> findByHouseId(Long houseId);
}
