package ru.kata.spring.boot_security.demo;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class TestClass {
    private final User user;
    private final UserServiceImpl userService;
    private final RoleRepository roleRepository;

    public TestClass(User user, UserServiceImpl userService, RoleRepository roleRepository) {
        this.user = user;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void init() {
        user.setFirstName("123");
        user.setLastName("123");
        user.setAge(20);
        user.setEmail("123@gmail.com");
        user.setPassword("123");
        Set<Role> roleList = Set.of(new Role("ADMIN"), new Role("USER"));
        roleRepository.saveAll(roleList);
        user.setRole(roleList);
        userService.save(user);
    }
}
