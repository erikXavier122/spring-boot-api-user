package com.api.user.service.impl.v1;

import com.api.user.domain.model.v1.UserModel;
import com.api.user.domain.repository.v1.UserRepository;
import com.api.user.service.v1.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserModel> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<UserModel> findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }

    @Override
    public Optional<UserModel> findByCep(Integer cep) {
        return userRepository.findByCep(cep);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return userRepository.existsByCpf(cpf);
    }


    @Transactional
    @Override
    public Object save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @Override
    public String findByName2(String name) {
        String nameExist = userRepository.findByName2(name);
        if (nameExist == null){
            return "Não existe esse nome";
        }else {
            return nameExist;
        }
    }

    @Override
    public Optional<UserModel> findById(UUID id) {
        return userRepository.findById(id);
    }
}
