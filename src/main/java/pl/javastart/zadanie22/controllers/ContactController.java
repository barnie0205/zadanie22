package pl.javastart.zadanie22.controllers;

import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.zadanie22.service.EmailService;

@Controller
public class ContactController {
    private final EmailService emailService;

    public ContactController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @PostMapping("/send-message")
    public String sendEmail(@RequestParam String name,
                            @RequestParam String clientEmail,
                            @RequestParam String message,
                            Model model) {
        try {
            // Wysyłanie emaila do właściciela strony
            String adminEmail = "jakismailtestowy@onet.pl";
            emailService.sendEmail(adminEmail, adminEmail, "Kontakt - " + name, message, clientEmail);

            // Wysyłanie potwierdzenia do nadawcy
            emailService.sendEmail(clientEmail, adminEmail,"Potwierdzenie wysłania wiadomości",
                    "Dziękujemy za kontakt. Odpowiemy na Twoje zapytanie wkrótce.", null);

            return "success";
        } catch (MessagingException e) {
            model.addAttribute("error",
                    "Błąd podczas wysyłania wiadomości. Spróbuj ponownie.");
            return "contact";
        }
    }
}