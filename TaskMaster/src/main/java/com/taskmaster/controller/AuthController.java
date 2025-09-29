package com.taskmaster.controller;
// ... imports
import com.taskmaster.dto.UserDto;
import com.taskmaster.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final UserService userService;
    public AuthController(UserService s) { this.userService = s; }
    @GetMapping("/") public String home() { return "redirect:/todos"; }
    @GetMapping("/login") public String login() { return "login"; }
    @GetMapping("/register") public String showRegistrationForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }
    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("userDto") UserDto userDto) {
        if (userService.findByUsername(userDto.getUsername()).isPresent()) return "redirect:/register?error&message=Username exists.";
        try {
            userService.saveUser(userDto);
        } catch (IllegalArgumentException e) {
            return "redirect:/register?error&message=" + e.getMessage();
        }
        return "redirect:/login?success";
    }
}