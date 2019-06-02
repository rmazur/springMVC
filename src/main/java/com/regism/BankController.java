package com.regism;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.regism.services.OpenBankService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@EnableWebMvc
@RestController
public class BankController {

    private static final Logger log = LoggerFactory.getLogger(BankController.class);

    private final OpenBankService openBankService;

    public BankController(OpenBankService openBankService) {
        this.openBankService = openBankService;
    }

    @GetMapping("/transactions")
    @Secured("ADMIN")
    public List getAllTransactions() {
        return openBankService.list();
    }

    /*@GetMapping("/transactions/{transactionType}")
    public List<Transactions> getTrType(@PathVariable("transactionType") String transactionType) {
        List<Transactions> transactionsListType = new ArrayList<Transactions>();
        List<Transactions> transactionsList = restManager.getExtRest();
        for (Transactions transactions : transactionsList){
            if (transactions.getTransactionType() != null && transactions.getTransactionType().equals(transactionType)){
                transactionsListType.add(transactions);
            }
        }
        return transactionsListType;
    }

    @GetMapping("/transactions/totalamount/{transactionType}")
    public String getTATrType(@PathVariable("transactionType") String transactionType) {
        float TotalAmount = 0;
        List<Transactions> transactionsList = restManager.getExtRest();
        for (Transactions transactions : transactionsList){
            if (transactions.getTransactionType() != null && transactions.getTransactionType().equals(transactionType)){
                TotalAmount = TotalAmount + transactions.getTransactionAmount();
            }
        }
        return "TotalAmount for " + transactionType + " transaction type is: " + TotalAmount;
    }*/

}