package nl.roymprog.cardsscore.repositories;

import nl.roymprog.cardsscore.models.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDAO extends PagingAndSortingRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String username);
}
