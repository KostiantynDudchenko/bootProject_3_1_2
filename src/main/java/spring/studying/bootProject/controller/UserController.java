package spring.studying.bootProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.studying.bootProject.model.User;
import spring.studying.bootProject.service.UserService;


@Controller
public class UserController {
    private final UserService userService;

    protected UserController(UserService userService) {
        this.userService = userService;
    }

    // Вывод всех полбзователей
    @GetMapping("/users")
    public String getUser(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    // Создание нового юзера
    @GetMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/newUser")
    public String create(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    // Обновление юзера
    @GetMapping("/users/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/users/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user.getId(), user);
        return "redirect:/users";
    }

    // Удаление юзера
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
