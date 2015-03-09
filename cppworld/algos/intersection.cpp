//program to find intersection of two arrays

#include<vector>
#include"misc.h"


void intersection(const vector<int>& v1, const vector<int>& v2, vector<int>& v3)
{
	vector<int>::const_iterator iter1 = v1.begin();
	vector<int>::const_iterator iter2 = v2.begin();
	v3.clear();

	while (iter1 != v1.end() && iter2 != v2.end())
	{
		if (*iter1 == *iter2)
		{
			v3.push_back(*iter1);
			iter1++;
			iter2++;
		}
		else if (*iter1 < *iter2)
			iter1++;
		else
			iter2++;
	}
}
int main_inter()
{
	vector<int> v1;
	vector<int> v2;
	vector<int> inter;

	for (short i = 0; i < 4;i++)
	v1.push_back(i);
	v2.push_back(3);
	v2.push_back(8);
	v2.push_back(10);
	v2.push_back(17);

	intersection(v1,v2,inter);
	for (vector<int>::const_iterator iter = inter.begin(); iter != inter.end(); iter++)
		cout << *iter << " ";
	return 0;
}