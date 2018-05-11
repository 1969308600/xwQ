/*package org.activiti.test;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class MyUnitTest {
	
	@Rule
	public  ActivitiRule activitiRule = new ActivitiRule();
	
	@Test
	@Deployment(resources = {"/myProcess.bpmn20.xml"})
	public void test() {
		ProcessInstance processInstance = activitiRule.getRuntimeService().startProcessInstanceByKey("myProcess");
		assertNotNull(processInstance);
		
		Task task = activitiRule.getTaskService().createTaskQuery().singleResult();
		assertEquals("Activiti is awesome!", task.getName());
	}
	
	
	public static void main(String[] args) {
 
	    
		RepositoryService s = test2().getRepositoryService();
		RuntimeService rs = test2().getRuntimeService();
		
//		s.createDeployment()
////	    .name("expense-process.bar")
//	    .addClasspathResource("myProcess.bpmn20.xml")
// 	    .addClasspathResource("myProcess.png")
//	    .deploy();
//		
		 String procId = rs.startProcessInstanceByKey("process").getId();
		 
		 TaskService taskService = processEngine.getTaskService();
		    List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();
		    for (Task task : tasks) {
		      System.out.println("Following task is available for accountancy group: " + task.getName());

		      // claim it
		      taskService.claim(task.getId(), "kermit");
		    }

		    // Verify Fozzie can now retrieve the task
		    tasks = taskService.createTaskQuery().taskAssignee("kermit").list();
		    for (Task task : tasks) {
		      System.out.println("Task for fozzie: " + task.getName());

		      // Complete the task
		      taskService.complete(task.getId());
		    }

		    System.out.println("Number of tasks for fozzie: "
		            + taskService.createTaskQuery().taskAssignee("fozzie").count());

		    // Retrieve and claim the second task
		    tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		    for (Task task : tasks) {
		      System.out.println("Following task is available for accountancy group: " + task.getName());
		      taskService.claim(task.getId(), "kermit");
		    }

		    // Completing the second task ends the process
		    for (Task task : tasks) {
		      taskService.complete(task.getId());
		    }

		    // verify that the process is actually finished
		    HistoryService historyService = processEngine.getHistoryService();
		    HistoricProcessInstance historicProcessInstance =
		      historyService.createHistoricProcessInstanceQuery().processInstanceId(procId).singleResult();
		    System.out.println("Process instance end time: " + historicProcessInstance.getEndTime());
	  
	}
	
	static ProcessEngine processEngine;
	public static ProcessEngine test2() {
		if(processEngine==null) {
			processEngine = ProcessEngines.getDefaultProcessEngine();
		}
		return processEngine;
	}

}
*/