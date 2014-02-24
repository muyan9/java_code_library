package zcy.service.memcache;

import java.util.ArrayList;
import java.util.Random;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class MemcacheTest {
	protected static MemCachedClient mcc = new MemCachedClient();

	static {
		String[] servers = { "127.0.0.1:11211","127.0.0.1:11212" };

		Integer[] weights = { 3 };

		// ����һ��ʵ������SockIOPool
		SockIOPool pool = SockIOPool.getInstance();

		// set the servers and the weights
		// ����Memcached Server
		pool.setServers(servers);
		pool.setWeights(weights);

		// set some basic pool settings
		// 5 initial, 5 min, and 250 max conns
		// and set the max idle time for a conn
		// to 6 hours
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		pool.setMaxIdle(1000 * 60 * 60 * 6);

		// set the sleep for the main thread
		// it will wake up every x seconds and
		// maintain the pool size
		pool.setMaintSleep(30);

		// Tcp�Ĺ�������ڷ���һ����֮ǰ�����ػ�����ȴ�Զ������
		// ����һ�η��͵İ���ȷ����Ϣ��������������Ϳ��Թر��׽��ֵĻ��棬
		// ���������׼�����˾ͷ���
		pool.setNagle(false);
		// ���ӽ�����Գ�ʱ�Ŀ���
		pool.setSocketTO(3000);
		// ���ӽ���ʱ�Գ�ʱ�Ŀ���
		pool.setSocketConnectTO(0);

		// initialize the connection pool
		// ��ʼ��һЩֵ����MemcachedServer�ν�������
		pool.initialize();

		// lets set some compression on for the client
		// compress anything larger than 64k
		mcc.setCompressEnable(true);
		mcc.setCompressThreshold(64 * 1024);
	}

	public static void bulidCache() {
		// set(key,value,Date) ,Date��һ������ʱ�䣬��������������ʱ����Ч�Ļ������ﴫ�ݵ�new Date(long
		// date) �в���date����Ҫ�Ǹ����ڻ����1000��ֵ��
		// ��Ϊjava client��ʵ��Դ����������ʵ�ֵ� expiry.getTime() / 1000 ��Ҳ����˵�����
		// С��1000��ֵ������1000�Ժ���0������������
		ArrayList<Integer> al = new ArrayList<Integer>();
		Integer itemp;
		Random random = new Random();
		for(int i=0;i<30000;i++)
		{
			itemp = random.nextInt();
			al.add(itemp);
		}
		
		mcc.set("test", al);
		// ʮ������

	}

	public static void output() {
		// ��cache��ȡֵ
		ArrayList<Integer> value = (ArrayList<Integer>)mcc.get("test");
		if(value!=null)
			System.out.println(value.size());
//		for (Integer str : value) {
//			System.out.println(str);
//		}
	}

	public static void main(String[] args) {
		bulidCache();
		long t = System.currentTimeMillis();
		output();
		System.out.println(System.currentTimeMillis()-t);
	}

}