#include"misc.h"
#include <vector> 
#include <iterator> 
#include <algorithm> 
#include <functional> 

//program to check transform of algorithm classes
struct base
{
	int val;
	base() : val(100) {}
	virtual int foo() { return val; }
};

struct derived : public base
{
	double val;
	derived() : val(200.2) {}
	virtual int foo() { 
		cout << "\nin derived foo";
		return val; }
};

int main_transform()
{
	std::vector<base*> vec(3);
	derived derived;
	std::fill(vec.begin(), vec.end(), &derived);
	std::transform(vec.begin(), vec.end(),
		std::ostream_iterator<int>(std::cout, "+"),
		std::mem_fun(&base::foo));
	return 0;
}
