package ru.job4j.tracker.banktransfers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operations {

    /**
     * map of users and accaunts
     */
    Map<User, List<Account>> userListMap = new HashMap<>();

    /**
     * create user
     * @param user
     */
    public void addUser(User user) {
        this.userListMap.putIfAbsent(user, user.getAccounts());
    }

    /**
     * remove user
     * @param user
     */
    public void deleteUser(User user) {
        if (user != null) {
            this.userListMap.remove(user);
        }
    }

    /**
     * create account for user
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> user : userListMap.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                user.getValue().add(account);
            }
        }
    }

    /**
     * remove one account for user
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (Map.Entry<User, List<Account>> user : userListMap.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                user.getValue().remove(account);
            }
        }
    }

    /**
     * get list of user accounts
     * @param passport
     * @return
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> userAccounts = new ArrayList<>();
        for (Map.Entry<User, List<Account>> user : userListMap.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                userAccounts = user.getValue();
            }
        }
        return userAccounts;
    }

    /**
     * method for transferring money from one account to another account:
     * if the account is not found or there is not enough money to the account srcAccount
     * (from which it is transferred) should return false.
     * @param srcPassport - passport sender
     * @param srcRequisite - account sender
     * @param destPassport - passport destUser
     * @param dstRequisite - account destUser
     * @param amount - amount payment
     * @return
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                    String destPassport, String dstRequisite, double amount) {

        boolean res = false;
        double senderBalance;
        double destUserBalance;
        Account sender = searchAccount(srcPassport, srcRequisite);
        Account destAc = searchAccount(destPassport, dstRequisite);

        if (sender != null && destAc != null
                && sender.getValue() >= amount) {
            senderBalance = sender.getValue();
            destUserBalance = destAc.getValue();
            sender.setValue(senderBalance - amount);
            destAc.setValue(destUserBalance + amount);
            res = true;
        }
        return res;
    }

    /**
     * search account with passport and value
     * @param passport - passport
     * @param requisite - value
     * @return - account
     */
    private Account searchAccount(String passport, String requisite) {
        Account ac = null;
        for (Map.Entry<User, List<Account>> userMap : userListMap.entrySet()) {
            if (userMap.getKey().getPassport().equals(passport)) {
                for (Account account : userMap.getValue()) {
                    if (account.getRequisites().equals(requisite)) {
                        ac = account;
                    }
                }
            }
        }
        return ac;
    }
}
