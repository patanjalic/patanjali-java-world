#include"misc.h"

class a1
{
public:
	~a1()
	{
		cout << "\nin base class dtor";
	}
};
class b :public a1
{
public:
	~b()
	{
		cout << "\nin derived class dtor";
	}
};
int main_vdtor()
{
	b b1;
	return 0;
}