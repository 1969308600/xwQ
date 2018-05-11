package com.cn.test;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
 
import org.apache.activemq.ActiveMQConnectionFactory;
 
public   class Test {
 
  public static void main(final String[] args) throws Exception {
      ConnectionFactory connFactory = new ActiveMQConnectionFactory();
       
      Connection conn = connFactory.createConnection();
      
      conn.start();
 
      Session sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
 
      Destination dest = sess.createQueue("SampleQueue");
 
      MessageProducer prod = sess.createProducer(dest);
    
  
 
      Message msg = sess.createTextMessage("Simples Assim");
 
      prod.send(msg );
     
      conn.close();
  }
 
}
