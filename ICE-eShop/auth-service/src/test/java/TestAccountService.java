import com.mycat.eshop.intf.service.AccountServicePrx;

import io.mycat.ice.utils.ICEClientUtil;

public class TestAccountService {

	public static void main(String[] args)
	{
		AccountServicePrx mysvcPrx = (AccountServicePrx) ICEClientUtil.getSerivcePrx(AccountServicePrx.class);
	        System.out.println(mysvcPrx.login("guest", "111111"));
	}
}
