import java.util.Arrays;

import com.mycat.eshop.intf.service.ProductServicePrx;

import io.mycat.ice.utils.ICEClientUtil;

public class TestProductService {

	public static void main(String[] args)
	{
		ProductServicePrx mysvcPrx = (ProductServicePrx) ICEClientUtil.getSerivcePrx(ProductServicePrx.class);
	        System.out.println(Arrays.toString(mysvcPrx.getProducts()));
	}
}
