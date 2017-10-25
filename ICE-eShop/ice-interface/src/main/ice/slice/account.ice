[["java:package:com.mycat.eshop"]]
module intf
{
module model
{
struct Account
{
		string name;
		string password;
				};
};
module service
{
interface AccountService{
model::Account login(string name,string password);
};
};

}