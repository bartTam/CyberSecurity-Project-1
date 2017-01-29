package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Account;
import sec.project.repository.AccountRepository;


@Controller
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    
    
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String viewAccount(Authentication authentication, Model model){
        Account account = accountRepository.findByUsername(authentication.getName());
        model.addAttribute("account", account);
        model.addAttribute("user", account.getUsername());
        model.addAttribute("isAdmin", account.isAdmin() ? "Admin" : "User");
        return "account";
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public String searchForAccount(@RequestParam String user, Authentication authentication, Model model){
        Account account = accountRepository.findByUsername(authentication.getName());
        model.addAttribute("account", account);
        model.addAttribute("user", account.getUsername());
        model.addAttribute("isAdmin", account.isAdmin() ? "Admin" : "User");
        model.addAttribute("searching", true);
        Account foundAccount = accountRepository.findByUsername(user);
        model.addAttribute("searchUser", user);
        model.addAttribute("foundUser", foundAccount!=null ? " found" : " not found");
        
        return "account";
    }
}
