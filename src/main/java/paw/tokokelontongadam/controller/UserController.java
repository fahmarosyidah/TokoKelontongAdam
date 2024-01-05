/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paw.tokokelontongadam.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import paw.tokokelontongadam.entity.User;
import paw.tokokelontongadam.service.UserService;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/login")
    public String authUser(@ModelAttribute("user") User user, HttpServletRequest request) {
        User oauthUser = userService.user(user.getUsername(), user.getPassword());
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/transaksi";
        } else {
            // Menangani kesalahan otentikasi
            request.setAttribute("error", "Username atau password salah");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
        // Menangani logout
        request.getSession().invalidate();
        return "redirect:/login";
    }
    
    @GetMapping("/registrasi")
    public ModelAndView registrasi() {
        ModelAndView mav = new ModelAndView("registrasi");
        mav.addObject("user", new User());
        return mav;
    }
    
    @PostMapping("/registrasi")
    public String registerUser(@ModelAttribute("user") User user, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        // Lakukan validasi atau logika bisnis jika diperlukan
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("successMessage", "Registration successful! You can now log in.");
        return "redirect:/login";
    }
}
