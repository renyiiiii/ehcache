package encache;


import dao.StuBean;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EncacheTest {
	private CacheManager manager;
	private Cache cache;
	public EncacheTest(){
		  manager = CacheManager.create();
		  cache = manager.getCache("testcache");
	}
	
	@SuppressWarnings("deprecation")
	public StuBean findbyid(int id){
		if(cache.get(id)!=null){
			return (StuBean) cache.get(id).getValue();
		}
		return null;
	}
	
	public void saveStu(StuBean stu){
		Element e=new Element(stu.getId(), stu);
		cache.put(e);
	}
	
	
	
	

}
