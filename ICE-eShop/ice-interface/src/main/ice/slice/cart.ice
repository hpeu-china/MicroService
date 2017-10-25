[["java:package:com.mycat.eshop"]]
module intf
{
module model
{
struct CartRecord
{
    int productId;
    string productName;
    string username;
    long time;
    int count;
    long productPrice;
};

sequence<CartRecord> CartRecordList;
};


module service
{
interface CartService{
model::CartRecordList  getProductsByUsername(string username);
void  addProductToCart(model::CartRecord cartRecord) ;
};
};

}