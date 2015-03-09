#include"misc.h"
class A
{
public:
	int x, y;
	/*A()
	{
		cout << "in junk ctor";
	} with default arguments its equivalent to dflt ctor*/
	A(int i = 0, int j = 3) :x(i), y(j) 
	{
		cout << "\nin ctor";
	}
};
int main_dfltctor()
{
	A a;
	cout << a.x << a.y;
	return 0;
}