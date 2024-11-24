package com.kshrd.coffeeshop.controller;

import com.kshrd.coffeeshop.entity.Booked;
import com.kshrd.coffeeshop.repository.BookedRepository;
import com.kshrd.coffeeshop.service.MyTelegramBot;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequiredArgsConstructor
public class MyController {

    private final BookedRepository bookedRepository;
    private final MyTelegramBot myTelegramBot;

    @GetMapping({"/", "/home/page"})
    public String home(Model model) {
        Booked booked = new Booked(
                0L,
                "",
                "",
                "",
                LocalDate.now(),
                LocalTime.now(),
                0L
        );
        model.addAttribute("booked", booked);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/service")
    public String service() {
        return "service";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/reservation")
    public String reservation(Model model) {
        Booked booked = new Booked(
                0L,
                "",
                "",
                "",
                LocalDate.now(),
                LocalTime.now(),
                0L
        );
        model.addAttribute("booked", booked);
        return "reservation";
    }

    @GetMapping("/testimonial")
    public String testimonial() {
        return "testimonial";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/success")
    public String success(@ModelAttribute Booked booked) {
        // Save the booked object to the repository
        bookedRepository.save(booked);

        // Format the booked object for Telegram message
        String formattedMessage = String.format(
                """
                        👤 name: %s
                        📞 phone number: %s
                        📧 email: %s
                        📅 date: %s
                        ⏰ time: %s
                        🆔 personId: %d
                        🔢 booking ID: %d""",
                booked.getName(),
                booked.getPhoneNumber(),
                booked.getEmail(),
                booked.getDate(),
                booked.getTime(),
                booked.getPersonId(),
                booked.getId()
        );

        // Send the formatted message to Telegram
        myTelegramBot.sendMessage(formattedMessage);

        // Return the success page
        return "success";
    }


}
