package com.regism;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AllTx {

    @JsonProperty("transactions")
    private List<Transactions> transactions;

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "AllTx{" +
                "transactions=" + transactions +
                '}';
    }
}
