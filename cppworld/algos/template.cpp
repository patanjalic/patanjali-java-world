//program to understand template and operator overlaoding
#include"misc.h"

class a
{
private:
	int data;
public:
	a();
	a(int);
	~a();
	a(const a&);
	a& operator=(const a&);
};

a::a()
:data(0)
{

}

a::a(int x)
:data(x)
{

}

a::~a()
{

}

a::a(const a& x)
{
	this->data = x.data;
}

a& a::operator=(const a& x)
{
	this->data = x.data;
	return *this;
}

template<typename T>
T max(T a, T b)
{
	return (a > b) ? a : b;
}

int main_template()
{
	a abc(10);
	a def(20);
	//a ghi = max(abc, def);
	//int x = max(10,20);
	//cout << "\nx is " << x;
	return 0;
}
