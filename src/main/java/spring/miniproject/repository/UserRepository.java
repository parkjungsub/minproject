package spring.miniproject.repository;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import spring.miniproject.dto.RequsetDto;
import spring.miniproject.entity.User;

import java.util.Optional;

@Getter
@Setter
@Repository
public class UserRepository {

    private final EntityManager em;

    public UserRepository(EntityManager em){
        this.em = em;
    }


    public void save(User user) {
        em.persist(user);
    }

    public User findByName(String name){
        User user = em.find(User.class,name);
        return user;
    }

    public void delete(User user){
        em.remove(user);
    }

//    public List<User> findAll(){
//        return em.createQuery("select m from User m", User.class).getResultList();
//    }
}
