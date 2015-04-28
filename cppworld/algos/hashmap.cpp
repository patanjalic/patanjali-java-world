#include <unordered_map>
#include "misc.h"
int main_hashmap()
{
	unordered_map<int, int> hashtable;
	int test[] = { 7, -13, 1, 3, 10, 5, 2, 4,1,10,1,10 };
	int n = sizeof(test) / sizeof(int);
	for (short i = 0; i < n; i++)
	{
		hashtable.emplace(test[i],i);
	}

	//printf("%s",(char*)(hashtable["www.element14.com"]);
	//cout << "ip address: " << hashtable["www.element14.com"] << endl;
	for (auto itr = hashtable.begin(); itr != hashtable.end(); itr++)
	{
		cout << (*itr).first << endl;
	}
	return 0;
}
