/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nus.iss.phoenix.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectPresenterDelegateTest;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectProducerDelegateTest;
import sg.edu.nus.iss.phoenix.schedule.delegate.ReviewSelectScheduleDelegateTest;
import sg.edu.nus.iss.phoenix.schedule.service.ScheduleServiceTest;
import sg.edu.nus.iss.phoenix.user.delegate.UserDelegateTest;

/**
 *
 * @author linby
 */
@RunWith(Suite.class)
@SuiteClasses({ ReviewSelectPresenterDelegateTest.class, ReviewSelectProducerDelegateTest.class, ReviewSelectScheduleDelegateTest.class,
		ScheduleServiceTest.class, UserDelegateTest.class })
public class AllTests {

}
