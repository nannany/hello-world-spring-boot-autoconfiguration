package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.test.context.runner.WebApplicationContextRunner;

import com.example.demo.config.HelloWorldAutoConfiguration;
import com.example.demo.controller.HelloWorldController;

import static org.assertj.core.api.Assertions.assertThat;

class AutoConfigurationTest {

	@Test
	void autoConfigurationTest() {
		new WebApplicationContextRunner()
				.withUserConfiguration(HelloWorldAutoConfiguration.class).run((context) -> {
			assertThat(context).hasSingleBean(HelloWorldController.class);
			assertThat(context).getBean("helloWorldController").isSameAs(context.getBean(HelloWorldController.class));
		});

		new ApplicationContextRunner()
				.withUserConfiguration(HelloWorldAutoConfiguration.class).run((context) ->
				assertThat(context).doesNotHaveBean(HelloWorldController.class)
		);
	}

}
