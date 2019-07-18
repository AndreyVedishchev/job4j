package ru.job4j.tracker.banktransfers;

public class Main {
    public static void main(String[] args) {
        Operations operations = new Operations();
        User vasya = new User("Vasya", "111");
        User sasha = new User("Sasha", "222");
        operations.addUser(vasya);
        operations.addUser(sasha);

        operations.addAccountToUser(vasya.getPassport(), new Account(3000, "7894561rsqw"));
        operations.addAccountToUser(sasha.getPassport(), new Account(4000, "67069096kj"));

        System.out.println(vasya.getAccounts().get(0).getValue());
        System.out.println(sasha.getAccounts().get(0).getValue());

        System.out.println(
                operations.transferMoney("111", "7894561rsqw",
                        "222", "67069096kj", 700)
                            );

        System.out.println(vasya.getAccounts().get(0).getValue());
        System.out.println(sasha.getAccounts().get(0).getValue());
    }
}
