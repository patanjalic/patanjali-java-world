#include"misc.h"

class aT
{
private:
	int a;
public:
	aT(int x)
	{
		a = x;
	}
	friend bool operator>(const aT& a, const aT& b)
	{
		if (a.a > b.a)
			return true;
		return false;
	}
	friend ostream& operator<< (ostream& a, const aT& x)
	{
		a << "\nthe value is " << x.a;
		return a;
	}
};

template <class T>
T max(T a, T b)
{
	return (a > b) ? a : b;
}

int main_templatetest()
{
	aT a(1), b(2);
	//cout << max(a,b);
	return 0;
}
