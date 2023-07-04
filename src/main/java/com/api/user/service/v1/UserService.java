package com.api.user.service.v1;

import com.api.user.domain.model.v1.UserModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<UserModel> findAll();

    Optional <UserModel> findById(UUID id);

    Optional<UserModel> findByName(String name);

    String findByName2(String name);

    Optional<UserModel> findByCpf(String cpf);

    Optional<UserModel> findByCep(Integer cep);

    boolean existsByCpf(String cpf);

    Object save(UserModel userModel);
}
