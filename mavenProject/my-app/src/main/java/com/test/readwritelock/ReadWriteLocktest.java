package com.test.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/***
 * ��д��    �����ͬ���������  ����Ҫ�������ڻ���Ķ�д����
 * @author worker
 *
 */
public class ReadWriteLocktest implements ReadWriteLock {
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();  
	private final Lock r = rwl.readLock();
   private final Lock w = rwl.writeLock();
	@Override
	public Lock readLock() {
		return r;
	}

	@Override
	public Lock writeLock() {
		return w;
	}
	

}
