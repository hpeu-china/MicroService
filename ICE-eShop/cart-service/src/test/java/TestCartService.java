import java.util.Arrays;

import com.mycat.eshop.intf.model.CartRecord;
import com.mycat.eshop.intf.service.CartServicePrx;

import io.mycat.ice.utils.ICEClientUtil;

public class TestCartService {

	public static void main(String[] args)
	{
		CartServicePrx mysvcPrx = (CartServicePrx) ICEClientUtil.getSerivcePrx(CartServicePrx.class);
		CartRecord rec=new CartRecord();
		String user="guest";
		rec.productPrice=10000;
		rec.productId=1;
		rec.username=user;
		mysvcPrx.addProductToCart(rec);
	        System.out.println(Arrays.toString(mysvcPrx.getProductsByUsername(user)));
	}
}
