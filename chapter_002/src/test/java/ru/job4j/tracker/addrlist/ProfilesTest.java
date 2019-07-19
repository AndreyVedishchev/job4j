package ru.job4j.tracker.addrlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void getAddressList() {
        Profiles pr = new Profiles();
        List<Profile> profiles = new ArrayList<>(
                Arrays.asList(
                        new Profile(new Address("City1", "Street1", 1, 1)),
                        new Profile(new Address("City1", "Street1", 1, 1)),
                        new Profile(new Address("City2", "Street2", 2, 2)),
                        new Profile(new Address("City3", "Street3", 3, 3))
                )
        );
        List<Address> addressListRes = pr.collect(profiles);
        List<Address> addressList = new ArrayList<>(
                Arrays.asList(
                        new Address("City1", "Street1", 1, 1),
                        new Address("City2", "Street2", 2, 2),
                        new Address("City3", "Street3", 3, 3)
                )
        );
        assertThat(addressListRes.toString(), is(addressList.toString()));
    }
}
