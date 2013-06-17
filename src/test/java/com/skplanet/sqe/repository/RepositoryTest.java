package com.skplanet.sqe.repository;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.skplanet.sqe.domain.Category;
import com.skplanet.sqe.domain.Product;
import com.skplanet.sqe.domain.Role;
import com.skplanet.sqe.domain.User;

//@ActiveProfiles("svc")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/context-datajpa.xml")
public class RepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	TransactionRepository transactionRepository;

	Logger logger = LoggerFactory.getLogger(RepositoryTest.class);

	@Before
	public void setup() {
		productRepository.deleteAll();
		userRepository.deleteAll();

		List<User> initialUsers = Arrays.asList(new User("woos41", "우병훈", "woo00", Role.Admin, "byunghun.woo@sk.com"),
				new User("daclouds", "석종일", "da00", Role.Seller, "daclouds@sk.com"), new User("dandycop", "백승훈",
						"dandy00", Role.Buyer, "seunghoon.baek@sk.com"));

		userRepository.save(initialUsers);

		Product product = new Product("daclouds", Category.Electronics, "macbook pro", new BigDecimal(1700000));
		productRepository.save(product);

	}

	@Test
	public void testRepository() {

		User user = new User("woos41", "우병훈", "woo00", Role.Admin, "byunghun.woo@sk.com");

		User foundUser = userRepository.findOne("woos41");

		// Then
		assertThat(foundUser, notNullValue());
		assertThat(foundUser.getEmail(), is(user.getEmail()));
		assertThat(foundUser.getRole(), is(user.getRole()));
		assertThat(foundUser.getRole(), is(Role.Admin));

		List<Product> foundProducts = productRepository.findAll();
		assertThat(foundProducts.size(), greaterThanOrEqualTo(1));
	}
}
