/*
 * accessPrivate.cpp
 *
 *  Created on: Mar 7, 2015
 *      Author: Admin
 */
//access private member of an object without being friend
#include<iostream>
using namespace std;
class Base {
	int i;
	char j;
    public:
    Base(int one,char two):i(one),j(two)    {}
};

int main_access_private()
{
   Base *b=new Base(10000,'a');
   void *v=(void*)b;
   int m=*(int*)v;
   cout<<"private member i="<<m<<endl;
   return 0;
}



