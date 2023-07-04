package com.api.user.controler.v1;


import com.api.user.Dto.v1.UserDto;
import com.api.user.domain.model.v1.UserModel;
import com.api.user.service.v1.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/user/v1")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<UserModel>> getAllUserModel(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id" ) UUID id){
        Optional<UserModel> userModelOptional= userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<Object> getByName(@PathVariable(value = "name") String name){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByName(name));
    }

    @GetMapping("/getByCpf/{cpf}")
    public ResponseEntity<Object> getByCpf(@PathVariable(value = "cpf")String cpf){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByCpf(cpf));
    }

    @GetMapping("/getByCep/{cep}")
    public ResponseEntity<Object> getByCep(@PathVariable(value = "cep")Integer cep){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByCep(cep));
    }

    @GetMapping("/getByname2/{name}")
    public ResponseEntity<String> getByName2(@PathVariable(value = "name")String name){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByName2(name));
    }

    @PostMapping("/save")
    public ResponseEntity<Object>saveRepository(@RequestBody @Valid UserDto userDto) {
        if (userService.existsByCpf(userDto.getCpf())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CONFLICT: Cpf is already in use!");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto,userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
     }

}

