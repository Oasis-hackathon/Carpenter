package org.carpenter.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarpenterRepository extends JpaRepository<Carpenter, Long> {
    Optional<Carpenter> findByEmail(String email);
    void deleteByEmail(String email);
}
