package com.burak.commentapp.controller;

import com.burak.commentapp.dto.request.UserCreateRequestDto;
import com.burak.commentapp.dto.response.UserCreateResponseDto;
import com.burak.commentapp.dto.response.UserFindAllResponseDto;
import com.burak.commentapp.repository.entity.User;
import com.burak.commentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import static com.burak.commentapp.contant.EndPoint.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/save")
    public ResponseEntity<User> save(String name , String surName, String email,String telephone,String password){
        User user=userService.save(User.builder().name(name).surName(surName).
                telephone(telephone).email(email).password(password).build());
        return ResponseEntity.ok(user);

    }

    @GetMapping("/saveWithRequestDto")
    public ResponseEntity<UserCreateResponseDto> save(UserCreateRequestDto dto){
        return ResponseEntity.ok(userService.saveWithRequestDto(dto));
    }

    @GetMapping("findalldto")
    public ResponseEntity<List<UserFindAllResponseDto>> findAllDto(){

        return ResponseEntity.ok(userService.findAllResponseDto());
    }

    @GetMapping("/savedto")
    public ResponseEntity<UserCreateResponseDto> saveDto(String name , String surName, String email,String telephone,String password){
        UserCreateResponseDto user=userService.saveDto(User.builder().name(name).surName(surName).
                telephone(telephone).email(email).password(password).build());


        return ResponseEntity.ok(user);

    }

    @GetMapping("/savedto2")
    public ResponseEntity<UserCreateResponseDto> saveDto2(String name , String surName, String email,String telephone,String password){
        UserCreateResponseDto user=userService.saveDto2(User.builder().name(name).surName(surName).
                telephone(telephone).email(email).password(password).build());


        return ResponseEntity.ok(user);

    }

    @GetMapping ("/findAll")
    public ResponseEntity<List<User>> findAll(){

        return ResponseEntity.ok(userService.findAll()) ;
    }

    @GetMapping("/orderbyname")
    public ResponseEntity<List<User>> findAllUserByOrderByName(){

        return  ResponseEntity.ok( userService.findAllUserByOrderByName());
    }

    @GetMapping("/containsname")
    public ResponseEntity<Optional<List<User>>> containsName(String value){
        return  ResponseEntity.ok(userService.containsName(value));
    }

    @GetMapping("/containsemail")
    public ResponseEntity<Optional<List<User>>> containsEmail(String value){
        return  ResponseEntity.ok(userService.containsEmaiil(value));
    }

    @GetMapping("/endwithemail")
    public ResponseEntity<Optional<List<User>>> endwithEmail(String value){
        return  ResponseEntity.ok(userService.endWithEmaiil(value));
    }


    @GetMapping("/login")
    public ResponseEntity<Optional<User>> login(String email,String password){
        return  ResponseEntity.ok(userService.login(email,password));
    }

    @GetMapping("/loginnativequery")
    public ResponseEntity<Optional<User>> loginNativeQuery(String email,String password){
        return  ResponseEntity.ok(userService.loginNativeQuery(email,password));
    }

    @GetMapping("/controlpasswordlength")
    public ResponseEntity< Optional<List<User>>> controlPasswordlength(int value){

        return ResponseEntity.ok(userService.controlPasswordLength(value));
    }
    @GetMapping("/controlpasswordlength2")
    public ResponseEntity< Optional<List<User>>> controlPasswordlength2(int value){

        return ResponseEntity.ok(userService.controlPasswordlength2(value));
    }


    @GetMapping("/addfav")
    public ResponseEntity<Optional<User>> addFav(Long userId,Long productId){

        return ResponseEntity.ok( userService.addFav(userId,productId));
    }

}
