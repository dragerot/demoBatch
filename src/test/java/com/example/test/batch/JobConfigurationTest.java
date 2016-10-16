package com.example.test.batch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Import({ TestJobConfiguration.class })
public class JobConfigurationTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void contextLoads() {
		Assert.assertTrue(true);
	}


    @Test
    public void d() throws Exception{
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        StepExecution firstStepExecution = jobExecution.getStepExecutions().iterator().next();
    }
}
