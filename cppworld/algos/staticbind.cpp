//program to check static bind in case of polymorphism
#include"misc.h"
class A
{
	int n;
public:
	virtual void Fun1(int no = 10)
	{
		n = no;
		cout << "A::Fun1" << n;
	}
};

class B: public A
{
	int m;
public:
	virtual void Fun1(int no = 20)
	{
		m = no;
		cout << "B::Fun1()" << m;
	}
};


int main_staticbinding()
{
	B b;
	A &a = b;
	a.Fun1();
	return 0;
}