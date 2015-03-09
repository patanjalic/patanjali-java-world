// const_cast
//writing to constant data segment cause access violation
#include <iostream>
using namespace std;

void print(char * str)
{
	*str = 'X';
	cout << str << '\n';
}

int main_constcast() {
	const char * c = "sample text";
	print(const_cast<char *> (c));
	return 0;
}