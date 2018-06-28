package com.example.rngesus.controllers;

import com.example.rngesus.models.User;
import com.example.rngesus.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserDao userDao;

    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }

    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
    {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++)
        {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    @RequestMapping(value = "create")
    public String create(Model model) {

        model.addAttribute("title", "Join RNGesus");
        User user = new User();
        model.addAttribute("user", user);
        return "user/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute  @Valid User user, Errors errors, Model model, String verify) throws NoSuchAlgorithmException, InvalidKeySpecException {

        System.out.println("Create handler used");
        List<User> sameName = userDao.findByUsername(user.getUsername());

        if(!errors.hasErrors() && user.getPassword().equals(verify) && sameName.isEmpty()) {
            System.out.println("No errrors");
            int iterations = 1000;
            char[] chars = user.getPassword().toCharArray();
            byte[] salt = getSalt();

            PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = skf.generateSecret(spec).getEncoded();

            user.setPassword(iterations + ":" + toHex(salt) + ":" + toHex(hash));
            System.out.println("User username: " + user.getUsername());
            System.out.println("User password: " + user.getPassword());

            userDao.save(user);

            return "user/index";
        } else {
            System.out.println("Errors detected");
            model.addAttribute("title", "Join RNGesus");
            model.addAttribute("user", user);
            if(!user.getPassword().equals(verify)) {
                System.out.println("Passwords don't match");
                model.addAttribute("verify", "Passwords didn't match");
            }
            if(!user.getPassword().equals(verify)) {
                System.out.println("Username is taken");
                model.addAttribute("message", "Username is taken, please select another one");
            }

            return "user/create";
        }
    }

    @RequestMapping(value = "login")
    public String loginForm(Model model) {
        model.addAttribute("title", "Login");
        model.addAttribute(new User());
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLogin(Model model, @ModelAttribute User user, HttpServletResponse response) throws NoSuchAlgorithmException, InvalidKeySpecException {

        System.out.println("Login handler used");

        List<User> u = userDao.findByEmail(user.getEmail());
        User loggedIn = u.get(0);
        System.out.println("User found: " + loggedIn.getUsername());
        String[] parts = loggedIn.getPassword().split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(user.getPassword().toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++)
        {
            diff |= hash[i] ^ testHash[i];
        }
        if (diff == 0) {
            Cookie c = new Cookie("user", user.getUsername());
            c.setPath("/");
            response.addCookie(c);
            return "redirect:/user/index";
        } else {
            model.addAttribute("message", "Invalid Password");
            model.addAttribute("title", "Login");
            return "user/login";
        }
    }

    @RequestMapping(value = "logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie c : cookies) {
                c.setMaxAge(0);
                c.setPath("/");
                response.addCookie(c);
            }
        }
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String viewAccount(Model model, @PathVariable int userId) {

        User user = userDao.findById(userId).orElse(null);
        model.addAttribute("user", user);

        return "user/account";
    }

}
