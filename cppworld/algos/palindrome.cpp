//program to find whether given list of string forms a palindrome

#include"misc.h"
#include<list>
#include<string>

bool check_palin(list<string>& l);

int main_palin()
{
	string s,temp;
	list<string> l;
	s = "a";
	l.push_back(s);
	s = "bc";
	l.push_back(s);
	s = "ba";
	l.push_back(s);
	if (check_palin(l))
		cout << "\nthe given list of strings is a palindrome";
	for (list<string>::const_iterator it = l.begin(); it != l.end(); it++)
	{
		cout << *it << " ";
	}
	cout << endl;
	list<string>::const_iterator it = --(l.end());
	while (it != l.begin())
	{
		cout << *it << " ";
		it--;
	}
	cout << *it;
	return 0;
}

bool check_palin(list<string>& l)
{
	string s1, s2;
	list<string>::const_iterator begin = l.begin();
	list<string>::const_iterator rev = --(l.end());
	if (l.size() == 0)
	{
		return true;
	}
	s1 = *begin;
	s2 = *rev;
	string::const_iterator b = s1.begin();
	string::const_reverse_iterator e = s2.rbegin();
	do
	{
		if (b == s1.end())
		{
			s1 = *(++begin);
			b = s1.begin();
		}
		else if (e == s2.rend())
		{
			s2 = *(--rev);
			e = s2.rbegin();
		}
		if (*b != *e)
		{
			return false;
		}
		b++;
		e++;
	} while (begin != rev);
	return true;
}