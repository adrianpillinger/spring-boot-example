package com.pillinger;


import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {
	
	@Autowired
	private TaskScheduler scheduler;
	
	private ScheduledFuture runningTask;

    @RequestMapping(value="/start", method = RequestMethod.POST)
    @ResponseBody
    String start(@RequestBody final ClientConfiguration configuration) {
		System.out.println(configuration);
		
		cancelExistingRunningTask();

		runningTask = scheduler.scheduleAtFixedRate(new Runnable() {
			public void run() {
				System.out.println("Sending message: ");
				System.out.println(configuration.getMessage());
				System.out.println();
			}
		}, configuration.getMessageInterval());

		return "Hello World!";
    }
    
    private void cancelExistingRunningTask() {
    	if (runningTask != null)
		{
    		runningTask.cancel(false);
		}
	}

	@RequestMapping(value="/stop", method = RequestMethod.POST)
    @ResponseBody
    void stop() {
		cancelExistingRunningTask();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
    
    @Bean
    public TaskScheduler scheduler() {
    	return new ThreadPoolTaskScheduler();
    }
}