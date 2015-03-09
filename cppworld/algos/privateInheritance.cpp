#include<iostream>
#include"misc.h"
class base123{
public:
	virtual void fun()
	{
		cout << "in base";
	}
};
class derived123: private base123{ 
public:
	derived123()
	{

	}
	void fun(){
		cout << "in derived";
	}
};

int main_privateInheritance()
{
	derived123* d = new derived123();
	//base123* d1 = new derived123();
	//error because base class ctor is not available
	//d1->fun();
	return 0;
}