package ru.job4j.tracker.addrlist;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
   List<Address> collect(List<Profile> profiles) {
       List<Address> addressList = profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
       Comparator<Address> comparator = (o1, o2) -> {
           int res = 0;
           char[] leftArr = o1.getCity().toCharArray();
           char[] rightArr = o2.getCity().toCharArray();
           int index = leftArr.length > rightArr.length ? rightArr.length : leftArr.length;

           for (int i = 0; i < index; i++) {
               if (Character.compare(leftArr[i], rightArr[i]) == 0) {
                   continue;
               } else {
                   res = Character.compare(leftArr[i], rightArr[i]);
               }
           }
           if (res == 0) {
               if (Integer.compare(leftArr.length, rightArr.length) > 0) {
                   res = 1;
               }
               if (Integer.compare(leftArr.length, rightArr.length) < 0) {
                   res = -1;
               }
           }
           return res;
       };
       return addressList.stream().sorted(comparator).distinct().collect(Collectors.toList());
    }
}