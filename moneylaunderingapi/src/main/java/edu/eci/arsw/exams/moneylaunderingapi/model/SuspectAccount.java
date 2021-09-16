package edu.eci.arsw.exams.moneylaunderingapi.model;

public class SuspectAccount {
    private String accountId;
    private int amountOfSmallTransactions;

    public SuspectAccount() {
    }

    public SuspectAccount(String accountId, int amountOfSmallTransactions) {
        this.accountId = accountId;
        this.amountOfSmallTransactions = amountOfSmallTransactions;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getAmountOfSmallTransactions() {
        return this.amountOfSmallTransactions;
    }

    public void setAmountOfSmallTransactions(int amountOfSmallTransactions) {
        this.amountOfSmallTransactions = amountOfSmallTransactions;
    }


    @Override
    public String toString() {
        return "{" +
            " accountId='" + getAccountId() + "'" +
            ", amountOfSmallTransactions='" + getAmountOfSmallTransactions() + "'" +
            "}";
    }


}


