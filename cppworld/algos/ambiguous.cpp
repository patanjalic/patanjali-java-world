#include"misc.h"

class ex
{
	int i;
public:
	ex(int ii = 0) :i(ii){}
	~ex(){ cout << "dest" << endl; }
	void show(int a)
	{
		cout << "show fun called" << endl;
		a = 10;
		i = 0;
	}
};

int main_ambi(int argc, char *argv[])
{
	ex *ob = NULL;
	ob->show(10);
	return 0;
}
