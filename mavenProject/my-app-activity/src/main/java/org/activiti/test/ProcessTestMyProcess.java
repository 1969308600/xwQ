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
//		//����
//		repositoryService.createDeployment().addClasspathResource("org/activiti/test/myProcess.bpmn20.xml").deploy();
//		
//		Map<String, Object> variables = new HashMap<String, Object>();
//		variables.put("userid", "Kermit");
//		variables.put("userid2","xwq"); 
// 
//		RuntimeService runtimeService = processEngine.getRuntimeService();
//		//�_ʼһ������      variables��Q  #{userid}��#{userid2}  �������̷ŵ�������
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process", variables);
//		
//		
//		// processEngineȫ��׃����    ����Ѱl��  �͌�  �l�Ѻ��_ʼ���̴��aעጵ�����Ӱ�
		TaskService ts = processEngine.getTaskService();
		Task task = ts.createTaskQuery().singleResult();
//		
//		//�O�ý�����
//		task.setAssignee("xwq");
//		
//		//��ɮ�ǰ����   �����c������һ�� ���� userid ������Kermit
//		ts.complete(task.getId());
		
		HistoryService  hs = processEngine.getHistoryService();
		
		
		//List<HistoricVariableInstance> hList = hs.createHistoricVariableInstanceQuery().list();  // �������µ����̱��������������
		 List<HistoricActivityInstance> hList =  hs.createHistoricActivityInstanceQuery().processInstanceId(task.getProcessInstanceId()).list();
	       
		//List<HistoricActivityInstance> hList = hs.createHistoricActivityInstanceQuery().list();// ����һ���(�����ϵĽڵ�)��ִ����Ϣ ��
		
		
		// 2. ��ȡ�����̶���
        // ProcessDefinitionEntity pd = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(task.getProcessDefinitionId());
	    BpmnModel bpmnModel = repositoryService.getBpmnModel(task.getProcessDefinitionId());
	       
        List<String> lStrings = new ArrayList<>();
        hList.forEach((k)->{ 
        	lStrings.add(k.getActivityId());
        });
		processEngine.getProcessEngineConfiguration().getProcessDiagramGenerator().generateDiagram(bpmnModel, "png", lStrings);
		
	}
	 
}