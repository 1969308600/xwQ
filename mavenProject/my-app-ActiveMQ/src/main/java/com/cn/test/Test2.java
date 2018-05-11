package com.cn.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Test2 {
	 public static void main(final String[] args) throws Exception {
		 
		 
		    final ConnectionFactory connFactory = new ActiveMQConnectionFactory();
		 
		    final Connection conn = connFactory.createConnection();
		    
		    conn.start();
		 
		    final Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		 
		    final Destination dest = sess.createQueue("SampleQueue");
		 
		    final MessageConsumer prod = sess.createConsumer  (dest);
		    
		    TextMessage msg = (TextMessage) prod.receive();
		     
		    System.out.println(msg.getText());
		    
		    conn.close();
		  }
}
