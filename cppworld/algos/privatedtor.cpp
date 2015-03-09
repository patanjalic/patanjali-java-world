#include"misc.h"
class aa
{
public:
	aa()
	{

	}
	friend void del(aa* obj)
	{
		delete obj;
	}
private:
	~aa(){ cout << "in dtor";  }
};

int main_dtor() {
	// your code goes here
	aa *a = new aa();
	//delete a;
	del(a);
	return 0;
}