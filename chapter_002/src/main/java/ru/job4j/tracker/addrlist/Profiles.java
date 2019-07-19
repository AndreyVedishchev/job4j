package ru.job4j.tracker.addrlist;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
   List<Address> collect(List<Profile> profiles) {
       List<Address> addressList = profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
       Comparator<Address> comparator = Comparator.comparing(Address::getCity);
       return addressList.stream().sorted(comparator).distinct().collect(Collectors.toList());
   }
}