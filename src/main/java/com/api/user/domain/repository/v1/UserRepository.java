package com.api.user.domain.repository.v1;

import com.api.user.domain.model.v1.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    @Query(value="SELECT * FROM user WHERE name = ?1", nativeQuery = true)
    Optional<UserModel> findByName(String name);

    @Query(value="SELECT * FROM user WHERE cpf = ?1", nativeQuery = true)
    Optional<UserModel> findByCpf(String cpf);

    @Query(value="SELECT * FROM user WHERE cep = ?1", nativeQuery = true)
    Optional<UserModel> findByCep(Integer cep);

    boolean existsByCpf(String cpf);

    @Query(value="SELECT name FROM user WHERE name = ?1", nativeQuery = true)
    String findByName2(String name);
}
