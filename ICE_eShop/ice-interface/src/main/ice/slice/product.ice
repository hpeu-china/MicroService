[["java:package:com.mycat.eshop"]]
module intf
{
module model
{
struct Product
{
    int id;
    string name;
    long price;
    string desc;
};
sequence<Product> ProductList;
};


module service
{
interface ProductService{
model::ProductList  getProducts();
model::Product getProductById(int id);
};
};

}