package com.restapi;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootH2RestApiApplicationTests {
	SpringbootH2RestApiApplication sha = new SpringbootH2RestApiApplication();

	@Test
	public void contextLoads() {
		assertThat(sha, instanceOf(SpringbootH2RestApiApplication.class));
	}

}
