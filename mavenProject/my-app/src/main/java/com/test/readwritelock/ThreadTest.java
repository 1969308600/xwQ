package com.test.readwritelock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.scheduling.config.Task;

  class ThreadTest2  extends Thread  {
	ReadWriteLocktest e = new ReadWriteLocktest();
	testEntity ent = null;
	int index =0;
	int v=0;
	syc syc;
	testEntity te;
	Map<Integer , testEntity> map = new ConcurrentHashMap<Integer , testEntity>();
	public  ThreadTest2( int index,int v,testEntity e) {
		
		ent=e;
		this.index=index;
		this.v=v;
		this.te=e;
		synchronized(e) {
			map.put(index, e);
		}
		
	}
	public ThreadTest2( syc e) {
		this.syc=e;
	}
	public void run( ) {
		//ent = map.get(index); 
		//System.out.println(index+"  "+ent.add);
		//synchronized(ent) {//同步保护
		ent.init(v);
		ent.add();
			System.out.println("线程"+index+"   entity:"+ent.add);
	 
			
	 	// }
	}
	public synchronized Map<Integer , testEntity> deepcopy(Integer i,testEntity e){
		
		return null;
	}
 
 
}
class TestCallAble2 implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		//Thread.sleep(5000);
		int tt=0;
//		for(int i=0;i<100000000;i++) {
//			Integer temp = new Integer(i);
//			tt =temp.intValue();
//		} 
		tt++;
	 
		 
		return "123"+tt;
	}
}
class TestCallAble implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		//Thread.sleep(5000);
		int tt=0;
//		for(int i=0;i<100000000;i++) {
//			Integer temp = new Integer(i);
//			tt =temp.intValue();
//		} 
		tt++;
		ExecutorService sd  = Executors.newSingleThreadExecutor();
		
		 Future<String> test1=	sd.submit(new TestCallAble2());
		 Future<String> test2=	sd.submit(new TestCallAble2());
		
		// System.out.println(test1.get()+"    "+test2.get());
		sd.shutdown();
		
		//System.out.println(tt);
		return "测试数据";
	}
}
/**
 * 顺序死锁
 * @author worker
 *
 */
class shunXuLock implements Runnable{
	public Object left = new Object();
	public Object right = new Object();
	
	public void leftM() {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		 try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
				System.out.println(left);
		  
	}
	public void leftR() {
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		 try {
			lock.lockInterruptibly();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
				System.out.println(right);
			 
		 
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		leftR();
		leftM();
		 
		
	}
	
	
}
class testadd implements Runnable{
	public  int value;
	public  int getvalue() {
		System.out.println("synchronized2");
		synchronized(this) {
			System.out.println("synchronized");
		}
		
		return value++;
	}
	@Override
	public  void run() {
		System.out.println(getvalue());
		
	}
}

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		testadd t= new testadd();
//		 for(int i=0;i<10;i++) {
//			 new Thread(t).start();
//		 }
		
		//ThreadPoolExecutor expool = new ThreadPoolExecutor(100, 200, 10, TimeUnit.MICROSECONDS,  new LinkedBlockingQueue());
		                                                                   
//	 
//			testEntity temp = new testEntity();
//			ThreadTest t = new ThreadTest(1,2,temp);   
//			ThreadTest t2 = new ThreadTest(2, 4,temp);
//			ThreadTest t3 = new ThreadTest(3, 6,temp);
			 
//			t3.start();
//			t2.start();
//			t.start();
			
			ExecutorService ex = Executors.newFixedThreadPool(100);
 			 
//			ExecutorService sd  = Executors.newSingleThreadExecutor();
//			
//			 for(int i=0;i<10000;i++) {
//				 Future<String> test1=	sd.submit(new TestCallAble2());
//				 System.out.println(test1.get());
//			}
//	 
//sd.shutdown();
// 			ex.execute(t);
//			ex.execute(t2);
//			ex.execute(t3);
			//Future<String> ss = ex.submit(new TestCallAble());// 对于单个任务很适合，如果任务很多，需要循环  ExecutorCompletionService
			//String callback = ss.get();
			
			//
			ExecutorCompletionService<String> exc = new ExecutorCompletionService<>(ex);
			List<FutureTask> task = new ArrayList<FutureTask>(); 
			for(int i=0;i<100;i++) {//假设每个线程所花时间都是十几秒这样子的  而且不知道有多少这种任务
				exc.submit(new TestCallAble());
				
//				FutureTask<String> tsk = new FutureTask<String>(new TestCallAble());
//				task.add(tsk);
				
				System.out.println("任务"+i);
			}
			Map<String,Object> map = new HashMap<String,Object>();
			for(int i=0;i<100;i++) {//依次从队列中拿到完成的任务返回值
				Future<String> ss= exc.take();
				ss.cancel(true);
				//System.out.println(ss.get());
				map.put("key"+i, ss.get());
			} 
			
			ex.shutdown();//结束接收任务
			while(true) {
				if(ex.isTerminated()) {
					System.out.println("一百个任务完成！");
					System.out.println("数据合流"+map.size());
					System.out.println("数据合流5"+map.get("key5"));
					System.out.println("数据合流55"+map.get("key55"));
					System.out.println("数据合流95"+map.get("key95"));
					break;
					
				}
				 Thread.sleep(50);
			}
			
		//	Timer timer = new Timer();
		//	timer.schedule(new timertaskTest(), 1000,2000);
//			System.out.println("end");
		
	}
}
class testEntity{
	 volatile int add = 0;
	public synchronized void init(int a) {
			 add=a;
	}
	public  Integer add() {
		add++;
		return add;
	}

}
class timertaskTest extends TimerTask{
	
	int count;
	@Override
	public void run() {
		
		System.out.println("执行"+count++);
	}
	
}



//@SafeThread
//class testEntity{
//	AtomicInteger value= new AtomicInteger(1);//使用原子变量和加同步没多大区别
//	//int value;//对于可变状态变量来说这个线程是不安全的
//	public  int getnextVal() {//同步只保证了执行同步的情况（最恶劣的情况如都输出0 0 0），线程依次进入同步块，不保证除了同步块的其他代码线程安全
//		synchronized(this) {
//		//	System.out.println("1");
//		//	System.out.println(2);
//		}
//		return value.incrementAndGet()  ;
//	}
//}
//@NotSafeThread
//class testEntity{
//	int value;
//	public int getnextVal() {
//		return value++;
//	}
//}
class  syc{
	int i;
	public  syc(int i) {
		this.i=i;
	}
	public  void test(int i) {
		System.out.println(i);
	}
}
/**
 * 读写锁
 */
//class testEntity{
//	ReadWriteLocktest e = new ReadWriteLocktest();
//	public Integer add = 0;
//	Integer v = 0;
////	public void addV(int t) {
////		this.v=t;
////	}
//	public  testEntity(int v) {
//		this.add =v;
//		this.v=v;
//	}
//	public  int add(Integer k ) {
//		e.writeLock().lock();
//		try {
//			synchronized(v) {
//				this.add =add+v;
//			}
//		}finally {
//			e.writeLock().unlock();
//		}
//		
//		return this.add;
//	}
// 
//}
/***
 * threadlocal
 */
//class testEntity{
//	ReadWriteLocktest e = new ReadWriteLocktest();
//	ThreadLocal<Integer> add =new ThreadLocal<Integer>() ;
//	int a = 0;
//	public testEntity(int a) {
//		
//		this.a=a;
//	}
//	public Integer add(Integer v) {
//	//	e.writeLock().lock();
//		try {
//			if(this.add.get()==null) {
//				this.add.set(new Integer(this.a));
//			}
//			this.add.set(v+this.add.get());;
//		}finally {
//			//e.writeLock().unlock();
//		}
//		
//		return this.add.get();
//	}
// 
//}

