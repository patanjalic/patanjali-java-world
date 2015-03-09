#include"misc.h"
//program to check delegate ctors concept, constructor can called from another ctro from same class

class base{
public:
	base()
	{
		cout << "\nbase class ctor";
	}
	base(int x){
		cout << "\nin int ctor";
	}
};

class der : public base {
private:
	int data;
public:
	der() : base(1)
	{
		//base();
		cout << "hello " << endl;
		der(20);
	}
	der(int x)
		:data(x)
	{
		cout << "\nderived class ctor";
	}
};

int main_dctors()
{
	der d;
	return 0;
}