/*package org.activiti.designer.test;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.ActivitiRule;
 

public class ProcessTestMyProcess {


	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	@Test
	public void startProcess() throws Exception {
		 
		RepositoryService repositoryService = processEngine.getRepositoryService();
		//发布
		repositoryService.createDeployment().addClasspathResource("./src/main/resuorces/myProcess.bpmn20.xml").deploy();
		
		
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("userid", "Kermit");
		variables.put("userid2","xwq"); 
 
		RuntimeService runtimeService = processEngine.getRuntimeService();
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process", variables);
		 
		
//		RuntimeService runtimeService = activitiRule.getRuntimeService();
//		 
//		Map<String, Object> variableMap = new HashMap<String, Object>();
//		variableMap.put("userid", "Activiti");
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process", variableMap);
//		assertNotNull(processInstance.getId());
//		System.out.println("id " + processInstance.getId() + " "
//			+ processInstance.getProcessDefinitionId());
//		
//		
//		TaskService taskService = processEngine.getTaskService();
//		
//		
//		List<Task> rtasks = taskService.createTaskQuery().taskCandidateUser("kermit").list();
//		 
//		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();
//	    for (Task task : tasks) {
//	      System.out.println("Following task is available for accountancy group: " + task.getName());
//
//	      // claim it
//	      taskService.claim(task.getId(), "fozzie");
//	    }
//
//	    // Verify Fozzie can now retrieve the task
//	    tasks = taskService.createTaskQuery().taskAssignee("fozzie").list();
//	    for (Task task : tasks) {
//	      System.out.println("Task for fozzie: " + task.getName());
//
//	      // Complete the task
//	      taskService.complete(task.getId());
//	    }

	}
	 @Test
	 @Deployment(resources="resources/MyProcess.bpmn")
	 public void testXmltoBpmn() throws XMLStreamException{
		 RepositoryService repositoryService = activitiRule.getRepositoryService();
	     ProcessDefinition processDefinition =repositoryService.createProcessDefinitionQuery().processDefinitionKey("vacationRequest").singleResult();
	     //获取流程资源的名称
	     String sourceName = processDefinition.getResourceName();
	     //获取流程资源
	     InputStream inputStream = repositoryService.getResourceAsStream(processDefinition.getId(),sourceName);
	     //创建转换对象
	     BpmnXMLConverter converter = new BpmnXMLConverter();
	     //读取xml文件
	     XMLInputFactory factory = XMLInputFactory.newInstance();
	     XMLStreamReader reader = factory.createXMLStreamReader(inputStream);
	     //将xml文件转换成BpmnModel
	     BpmnModel bpmnModel = converter.convertToBpmnModel((XMLStreamReader) reader);
	     //验证bpmnModel是否为空
	     assertNotNull(bpmnModel);
	     org.activiti.bpmn.model.Process process = bpmnModel.getMainProcess();
	     //验证转换的流程id
	     assertEquals("leave",process.getId());                  
	 }
}*/