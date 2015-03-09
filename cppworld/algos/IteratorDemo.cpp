/*
 * IteratorDemo.cpp
 *
 *  Created on: Mar 7, 2015
 *      Author: Admin
 */
#include"misc.h"
#include<vector>
int main_iterator_demo()
{
	vector<int> v;
	v.push_back(0);
	v.push_back(1);
	v.push_back(2);
	v.push_back(3);
	v.push_back(4);
	vector<int>::iterator it;
	for(it = v.begin(); it != v.end(); it++)
		cout<<" "<<*it;
	it = v.begin();
	//it++;
	//it++;
	v.pop_back();
	v.pop_back();
	vector<int>::reverse_iterator rit;
	rit = v.rend();
	rit--;
	it = v.end();
	cout<<"\n"<<*it;
	return 0;
}



