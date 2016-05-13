package com.example.shaunmesias.assignment_6_2.factories.driver;

import com.example.shaunmesias.assignment_6_2.conf.util.DomainState;
import com.example.shaunmesias.assignment_6_2.domain.driver.DriverDetails;

/**
 * Created by Shaun Mesias on 2016/05/07.
 */
public class DriverDetailsFactory {
    public static DriverDetails getDetails(String owner, String carName, String carType)
    {
        return new DriverDetails.Builder()
                .state(DomainState.ACTIVE.name())
                .ownerName(owner)
                .carName(carName)
                .carType(carType)
                .status(DomainState.ACTIVE.name())
                .build();
    }
}
