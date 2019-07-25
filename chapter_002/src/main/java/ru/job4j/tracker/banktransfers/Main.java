package ru.job4j.tracker.banktransfers;

public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        User vasya = new User("Vasya", "111");
        User sasha = new User("Sasha", "222");
        User ttt = new User("oijoi", "888");
        operations.addUser(vasya);
        operations.addUser(sasha);
        operations.addUser(ttt);

        Account a1 = new Account(3000, "7894561rsqw");
        Account a2 = new Account(5000, "kkj9894");
        Account a3 = new Account(4000, "67069096kj");

        operations.addAccountToUser(vasya.getPassport(), a1);
        operations.addAccountToUser(vasya.getPassport(), a2);
        operations.addAccountToUser(sasha.getPassport(), a3);

        System.out.println(operations.getUserAccounts("111").get(0).getValue());
        System.out.println(operations.getUserAccounts("222").get(0).getValue());

        System.out.println(
                operations.transferMoney("111", "7894561rsqw",
                        "222", "67069096kj", 700)
                            );

        System.out.println(operations.getUserAccounts("111").get(0).getValue());
        System.out.println(operations.getUserAccounts("222").get(0).getValue());
    }
}
