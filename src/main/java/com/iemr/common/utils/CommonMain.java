package com.iemr.common.utils;

import java.util.concurrent.Executor;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

import com.iemr.common.utils.config.ConfigProperties;
import com.iemr.common.utils.km.KMService;
import com.iemr.common.utils.km.openkm.OpenKMServiceImpl;
import com.iemr.common.utils.redis.RedisStorage;

@EnableAutoConfiguration
@EnableAsync
public class CommonMain
{
	@Bean
	public ConfigProperties configProperties()
	{
		return new ConfigProperties();
	}

	// @Bean
	// public SessionObject sessionObject()
	// {
	// return new SessionObject();
	// }

	// @Beanss
	// public RedisConnection redisConnection()
	// {
	// return new RedisConnection();
	// }

	// @Configuration
	// @EnableRedisHttpSession
	// public class Config {

	// @Bean
	// public LettuceConnectionFactory connectionFactory()
	// {
	// return new LettuceConnectionFactory();
	// }
	// }

	@Bean
	public RedisHttpSessionConfiguration redisSession()
	{
		return new RedisHttpSessionConfiguration();
	}

	@Bean
	public KMService getOpenKMService()
	{
		KMService kmService = new OpenKMServiceImpl();
		return kmService;
	}

	@Bean
	public RedisStorage redisStorage()
	{
		return new RedisStorage();
	}

	@Bean
	public Executor asyncExecutor()
	{
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("IEMRLookup-");
		executor.initialize();
		return executor;
	}
	// public static void main(String[] args) {
	// SpringApplication.run(CommonMain.class, args);
	// }
}
