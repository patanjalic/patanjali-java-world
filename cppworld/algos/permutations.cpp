//program to find all the permutations of a string
#include<string>
#include"misc.h"
void permutations(string pre,string str)
{
	int n = str.length();
	string temp;
	if (n == 0)
	{
		cout << pre << endl;
	}
	else
	{
		for (int i = 0; i < n; i++)
		{
			temp = str.at(i) + pre;
			permutations(temp, str.substr(0, i) + str.substr(i + 1, n));
		}
	}
}

int main_permu()
{
	string str = "abc";
	permutations("",str);
	return 0;
}