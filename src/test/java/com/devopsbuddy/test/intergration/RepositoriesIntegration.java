package com.devopsbuddy.test.intergration;

import com.devopsbuddy.DevopsbuddyApplication;
import com.devopsbuddy.backend.persistence.domain.backend.Plan;
import com.devopsbuddy.backend.persistence.domain.backend.Role;
import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.backend.persistence.domain.backend.UserRole;
import com.devopsbuddy.backend.persistence.repositories.PlanRepository;
import com.devopsbuddy.backend.persistence.repositories.RoleRepository;
import com.devopsbuddy.backend.persistence.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jonathan on 11/3/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DevopsbuddyApplication.class)
public class RepositoriesIntegration {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    public static final int BASIC_PLAN_ID = 1;
    public static final int BASIC_ROLE_ID = 1;

    @Before
    public void init() {
        Assert.assertNotNull(planRepository);
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(userRepository);
    }

    @Test
    public void createNewUser() throws Exception {
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);

        User basicUser = createBasicUser();
        basicUser.setPlan(basicPlan);

        Role basicRole = createRole();
        Set<UserRole> userRoles = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setUser(basicUser);
        userRole.setRole(basicRole);
        userRoles.add(userRole);

        basicUser.getUserRoles().addAll(userRoles);

        for (UserRole ur : userRoles) {
            roleRepository.save(ur.getRole());
        }

        basicUser = userRepository.save(basicUser);
        User newUser = userRepository.findOne(basicUser.getId());
        Assert.assertNotNull(newUser);
        Assert.assertTrue(newUser.getId() != 0);
        Assert.assertNotNull(newUser.getPlan());
        Assert.assertNotNull(newUser.getPlan().getId());
        Set<UserRole> newUserRoles = newUser.getUserRoles();
        for (UserRole ur : newUserRoles) {
            Assert.assertNotNull(ur.getRole());
            Assert.assertNotNull(ur.getRole().getId());
        }
    }

    @Test
    public void testCreateNewPlan() throws Exception {
        Plan basicPlan = createBasicPlan();
        planRepository.save(basicPlan);
        Plan retievePlan = planRepository.findOne(BASIC_PLAN_ID);
        Assert.assertNotNull(retievePlan);
    }

    private Plan createBasicPlan() {
        Plan plan = new Plan();
        plan.setId(BASIC_PLAN_ID);
        plan.setName("Basic");
        return plan;
    }

    private Role createRole() {
        Role role = new Role();
        role.setId(BASIC_ROLE_ID);
        role.setName("ROLE_USER");
        return role;
    }

    private User createBasicUser() {

        User user = new User();
        user.setUsername("basicUser");
        user.setPassword("secret");
        user.setEmail("bu@example.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("2015432233");
        user.setCountry("GA");
        user.setEnabled(true);
        user.setDescription("A basic user");
        user.setProfileImageUrl("https://blobs.images.com/basicuser");

        return user;
    }
}
