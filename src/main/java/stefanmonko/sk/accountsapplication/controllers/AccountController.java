package stefanmonko.sk.accountsapplication.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import stefanmonko.sk.accountsapplication.FeatureProperties;
import stefanmonko.sk.accountsapplication.domain.Account;
import stefanmonko.sk.accountsapplication.domain.AccountService;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    private FeatureProperties featureFlags;

    @RequestMapping("/accounts/{id}")
    public Account findById(@PathVariable Long id){
        if (featureFlags.getDatastream()){
            return accountService.findById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Feature not activated");
        }
    }




    @RequestMapping("/accounts")
    public Collection<Account> findAll(){

        if (featureFlags.getDatastream()){
            return accountService.findAll();
        } else {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Feature not activated");
        }
 
    }

}
