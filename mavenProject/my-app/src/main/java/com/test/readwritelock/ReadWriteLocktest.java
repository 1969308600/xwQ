package com.test.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/***
 * 读写锁    这个和同步锁不差不多  ，主要场景用于缓存的读写保护
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
