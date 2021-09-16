package edu.eci.arsw.exams.moneylaunderingapi;


import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;
import edu.eci.arsw.exams.moneylaunderingapi.service.MoneyLaunderingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoneyLaunderingController
{   
    @Autowired
    MoneyLaunderingService moneyLaunderingService;

    @RequestMapping(method = RequestMethod.GET,  value = "/fraud-bank-accounts")
    public List<SuspectAccount> offendingAccounts() {
        return moneyLaunderingService.getSuspectAccounts();
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/fraud-bank-accounts/{accountId}")
    public SuspectAccount offendingAccount( @PathVariable String accountId) {
        return moneyLaunderingService.getAccountStatus(accountId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fraud-bank-accounts" )
    public void createAccount(@RequestBody SuspectAccount suspectAccount){
        moneyLaunderingService.createAccount(suspectAccount);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/fraud-bank-account/{accountId}" )
    public void updateAccountStatus(@RequestBody SuspectAccount suspectAccount, @PathVariable String accountId){
        SuspectAccount temporal = moneyLaunderingService.getAccountStatus(accountId);

        if(temporal != null){
            int localCount = temporal.getAmountOfSmallTransactions() + suspectAccount.getAmountOfSmallTransactions();
            suspectAccount.setAmountOfSmallTransactions(localCount);
            moneyLaunderingService.updateAccountStatus(suspectAccount);
        }else{
            suspectAccount.setAccountId(accountId);
            moneyLaunderingService.createAccount(suspectAccount);
        }

        
    }


    
}
