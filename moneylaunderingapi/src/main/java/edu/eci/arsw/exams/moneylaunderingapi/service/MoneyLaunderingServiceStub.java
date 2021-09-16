package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MoneyLaunderingServiceStub implements MoneyLaunderingService {

    Map<String,SuspectAccount> accounts = new HashMap<String, SuspectAccount>();

    @Override
    public void updateAccountStatus(SuspectAccount suspectAccount) {
        accounts.put(suspectAccount.getAccountId(), suspectAccount);
    }

    @Override
    public SuspectAccount getAccountStatus(String accountId) {        
        return accounts.get(accountId);
    }

    @Override
    public List<SuspectAccount> getSuspectAccounts() {
        List<SuspectAccount> accountsList =  new ArrayList<SuspectAccount>();
        for(SuspectAccount suspectAccount : accounts.values()){
            accountsList.add(suspectAccount);
        }
        return accountsList;
    }

    @Override
    public void createAccount(SuspectAccount suspectAccount) {
        accounts.put(suspectAccount.getAccountId(), suspectAccount);
        
    }
}
