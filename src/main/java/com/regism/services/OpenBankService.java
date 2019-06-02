package com.regism.services;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.regism.AllTx;

@Service
public class OpenBankService {

    private static RestTemplate restTemplate = new RestTemplate();

    private String theUrl;

    {
        theUrl = "http://localhost:8888/greeting";
    }

    /**
     * @return list of transactions
     */
    public List list() {
        return Objects.requireNonNull(restTemplate.getForObject(theUrl, AllTx.class).getTransactions());
    }

}
