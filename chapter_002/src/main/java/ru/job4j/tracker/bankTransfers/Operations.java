package ru.job4j.tracker.bankTransfers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operations {

    /**
     * Хранит список пользователей и их счетов.
     */
    Map<User, List<Account>> userListMap = new HashMap<>();

    /**
     * добавление пользователя.
     * @param user
     */
    public void addUser(User user) {
        this.userListMap.putIfAbsent(user, user.getAccounts());
    }

    /**
     * удаление пользователя.
     * @param user
     */
    public void deleteUser(User user) {
        if (user != null) {
            this.userListMap.remove(user);
        }
    }

    /**
     * добавить счёт пользователю.
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
     * удалить один счёт пользователя.
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
     * получить список счетов для пользователя.
     * @param passport
     * @return
     */
    public List<Account> getUserAccounts (String passport) {
        List<Account> userAccounts = new ArrayList<>();
        for (Map.Entry<User, List<Account>> user : userListMap.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                userAccounts = user.getValue();
            }
        }
        return userAccounts;
    }

    /**
     * метод для перечисления денег с одного счёта на другой счёт:
     * если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
     * @param srcPassport - паспорт отправителя
     * @param srcRequisite - счет отправителя
     * @param destPassport - паспорт получателя
     * @param dstRequisite - счет получателя
     * @param amount - сумма перевода
     * @return
     */
    public boolean transferMoney (String srcPassport, String srcRequisite,
                                    String destPassport, String dstRequisite, double amount) {
        boolean res = false;
        int senIndex = 0;
        int destIndex = 0;
        double senderBalance = 0;
        double destUserBalance = 0;
        User sender = null;
        User destUser = null;

        for (Map.Entry<User, List<Account>> user : userListMap.entrySet()) {
            if (user.getKey().getPassport().equals(srcPassport)) {
                sender = user.getKey();
                for (Account account : sender.accounts) {
                    if (account.getRequisites().equals(srcRequisite)) {
                        senIndex = sender.accounts.indexOf(account);
                        senderBalance = account.getValue();
                    }
                }
            }

            if (user.getKey().getPassport().equals(destPassport)) {
                destUser = user.getKey();
                for (Account account : destUser.accounts) {
                    if (account.getRequisites().equals(dstRequisite)) {
                        destIndex = destUser.accounts.indexOf(account);
                        destUserBalance = account.getValue();
                    }
                }
            }
        }

        if (sender != null && destUser != null && senderBalance >= amount) {
            sender.getAccounts().get(senIndex).setValue(senderBalance - amount);
            destUser.getAccounts().get(destIndex).setValue(destUserBalance + amount);
            res = true;
        }

        return res;
    }
}
