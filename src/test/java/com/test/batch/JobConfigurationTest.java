package com.test.batch;

import com.example.DemoBatchApplication;
import com.example.services.AvvikService;
import com.example.services.AvvikServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoBatchApplication.class})
@Import({ TestJobConfiguration.class })
public class JobConfigurationTest {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void contextLoads()throws Exception{
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());
	}

    @Test
    public void d() throws Exception{
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        StepExecution firstStepExecution = jobExecution.getStepExecutions().iterator().next();
    }



}
