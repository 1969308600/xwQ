package com.mycompany.app;

//import org.ehcache.Cache;
//import org.ehcache.CacheManager;
//import org.ehcache.config.builders.CacheConfigurationBuilder;
//import org.ehcache.config.builders.CacheManagerBuilder;
//import org.ehcache.config.builders.ResourcePoolsBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 
    	//����뻺��ĳ��javabean����ȷ�����������õĶ���implents Serializable�����ĳ������
    	//����Ҫ��cache������ȷ�ļ���transient�ؼ��֡�����Ļ���Ehcacheÿ�ζ�ͨ�����ò��ҵķ�ʽ����ȥ��������ʵ�����ݵ�����
    	//��������ʧ�ܣ����ܿ϶��Ȳ����滹Ҫ�
//    	CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder() 
//    		    .withCache("preConfigured",
//    		        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10))) 
//    		    .build();
//    	cacheManager.init();
//    	
//    	Cache<Long, String> preConfigured =
//    		    cacheManager.getCache("preConfigured", Long.class, String.class); 
//
//		Cache<Long, String> myCache = cacheManager.createCache("myCache", 
//		    CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class, ResourcePoolsBuilder.heap(10)));
//
//		myCache.put(1L, "da one!"); 
//		 
//		String value = myCache.get(1L); 
//		String valu2e = myCache.get(2L); 
//		//cacheManager.removeCache("preConfigured");  
//		cacheManager.close(); 
//    	 System.exit(0);
    	
    	 
    	 
    	 
    	 
//    	 LocalPersistenceService persistenceService = new DefaultLocalPersistenceService(new DefaultPersistenceConfiguration(new File(getStoragePath(), "myUserData"))); 
//
//    	 PersistentUserManagedCache<Long, String> cache = UserManagedCacheBuilder.newUserManagedCacheBuilder(Long.class, String.class)
//    	     .with(new UserManagedPersistenceContext<Long, String>("cache-name", persistenceService)) 
//    	     .withResourcePools(ResourcePoolsBuilder.newResourcePoolsBuilder()
//    	         .heap(10L, EntryUnit.ENTRIES)
//    	         .disk(10L, MemoryUnit.MB, true)) 
//    	     .build(true);
//
//    	 // Work with the cache
//    	 cache.put(42L, "The Answer!");
//    	 assertThat(cache.get(42L), is("The Answer!"));
//
//    	 cache.close(); 
//    	 cache.destroy(); 
//
//    	 persistenceService.stop(); 
        System.out.println( "Hello World!" );
    }
}
