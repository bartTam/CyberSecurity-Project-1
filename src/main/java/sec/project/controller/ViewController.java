package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Account;
import sec.project.domain.Post;
import sec.project.domain.Thread;
import sec.project.repository.AccountRepository;


@Controller
public class ViewController {

    @Autowired
    private AccountRepository accountRepository;
    
    
    private Thread postThread = new Thread("First Thread");

    
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Authentication authentication, Model model){
        model.addAttribute("user", accountRepository.findByUsername(authentication.getName()).getUsername());
        model.addAttribute("title", postThread.getTitle());
        model.addAttribute("posts", postThread.getPosts());
        return "view";
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public String postMessage(@RequestParam String message, Authentication authentication){
        Account account = accountRepository.findByUsername(authentication.getName());
        postThread.post(new Post(account.getUsername(), message));
        account.setPostNumber(account.getPostNumber() + 1);
        accountRepository.save(account);
        return "redirect:/view";
    }
}
