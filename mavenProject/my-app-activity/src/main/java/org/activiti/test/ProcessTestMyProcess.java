package org.activiti.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricDetail;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.image.ProcessDiagramGenerator;
import org.junit.Rule;
import org.junit.Test;

public class ProcessTestMyProcess {


	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();

	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	@Test 
	public void startProcess() throws Exception {
		 
		 
		RepositoryService repositoryService = processEngine.getRepositoryService();
//		//发布
//		repositoryService.createDeployment().addClasspathResource("org/activiti/test/myProcess.bpmn20.xml").deploy();
//		
//		Map<String, Object> variables = new HashMap<String, Object>();
//		variables.put("userid", "Kermit");
//		variables.put("userid2","xwq"); 
// 
//		RuntimeService runtimeService = processEngine.getRuntimeService();
//		//開始一個流程      variables替換  #{userid}和#{userid2}  將次流程放到數據庫
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process", variables);
//		
//		
//		// processEngine全局變量，    如果已發佈  就將  發佈和開始流程代碼注釋掉，不影響
		TaskService ts = processEngine.getTaskService();
		Task task = ts.createTaskQuery().singleResult();
//		
//		//設置接收人
//		task.setAssignee("xwq");
//		
//		//完成當前實列   ，節點跳到下一個 ，幾 userid 對應的Kermit
//		ts.complete(task.getId());
		
		HistoryService  hs = processEngine.getHistoryService();
		
		
		//List<HistoricVariableInstance> hList = hs.createHistoricVariableInstanceQuery().list();  // 包含最新的流程变量或任务变量。
		 List<HistoricActivityInstance> hList =  hs.createHistoricActivityInstanceQuery().processInstanceId(task.getProcessInstanceId()).list();
	       
		//List<HistoricActivityInstance> hList = hs.createHistoricActivityInstanceQuery().list();// 包含一个活动(流程上的节点)的执行信息 。
		
		
		// 2. 获取到流程定义
        // ProcessDefinitionEntity pd = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(task.getProcessDefinitionId());
	    BpmnModel bpmnModel = repositoryService.getBpmnModel(task.getProcessDefinitionId());
	       
        List<String> lStrings = new ArrayList<>();
        hList.forEach((k)->{ 
        	lStrings.add(k.getActivityId());
        });
		processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().generateDiagram(bpmnModel, "png", lStrings);
		
	}
	 
}