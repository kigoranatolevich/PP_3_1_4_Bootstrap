package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String getProfile(Authentication authentication, Model model) {
        User user = userService.findUserByEmail(authentication.getName());
        StringBuilder stringBuilder = new StringBuilder();
        user.getRole().forEach(roles -> stringBuilder.append(roles.getAuthority()).append(" "));
        model.addAttribute("user", user);
        model.addAttribute("authorizedUser", String.format("%s with roles: %s", user.getEmail(), stringBuilder));
        return "user";
    }
}
