#include"misc.h"
#include<string>
#include<cstring>

//program to find continuous 4 digit number from the give numer
int FindGreatest(int num);
void findgreat(char*, int);

int main_4greatest()
{
	int number = 129923983;
	cout << FindGreatest(number) << endl;
	char str[] = "129923983";
	findgreat(str, 4);
	return 0;
}

int FindGreatest(int num)
{
	int max = -1;
	while (num > 1000)
	{
		long rem = num % 10000;
		if (rem > max) max = rem;
		num /= 10;
	}
	return max;
}

void findgreat(char* str, int k)
{
	short len = strlen(str);
	char buf[5] = { 0, };
	char* begin = str;
	char* end = str + len - 4;
	char* index = NULL;
	char max = *begin;
	index = begin;
	begin++;
	while (begin != end)
	{
		if (*begin < max)
		{
			begin++;
		}
		else if (*begin == max)
		{
			if (strncmp(begin, index, k) > 0)
			{
				max = *begin;
				index = begin;
				begin++;
			}
			else
				begin++;
		}
		else
		{
			max = *begin;
			index = begin;
			begin++;
		}
	}
	for (short i = 0; i < 4; i++)
		cout << index[i] << " ";
}
