package spring.miniproject.service;

import jakarta.transaction.Transactional;
import spring.miniproject.dto.RequsetDto;
import spring.miniproject.entity.User;
import spring.miniproject.repository.UserRepository;

import java.util.Optional;

@org.springframework.stereotype.Service
@Transactional
public class Service {
    UserRepository userRepository;

    public Service(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public RequsetDto join(RequsetDto requsetDto) {
        userRepository.save(new User(requsetDto.getName(), requsetDto.getPassword()));
        return requsetDto;
    }

    public RequsetDto verification(RequsetDto requsetDto){
           if(userRepository.findByName(requsetDto.getName()) != null){ //검증
               // todo :JWT를 생성하고 쿠키에 담기
        }
        return requsetDto;
    }
    public void delete(RequsetDto requsetDto){
        User user = userRepository.findByName(requsetDto.getName());
        userRepository.delete(user);
    }

}