/*
============================================================================
Author         : James Chen
Email          : a.james.chen@gmail.com
Description    : Move the spaces to the starting of the string in single iteration
Created Date   : 15-06-2013
Last Modified  :
============================================================================
*/

#include <iostream>
#include <iomanip>

using namespace std;

void PrintString(char *str)
{
	while (*str != '\0'){
		cout << setw(3) << *str++;
	}

	cout << endl;
}

inline void SwapChar(char& a, char& b)
{
	char t = a;
	a = b;
	b = t;
}

void MoveSpaceToStart(char* str)
{
	if (str == NULL) return;

	char *p(str);
	int index(-1);
	char t;

	while (p[0] != '\0'){
		if (p[0] == ' ' || p[0] == '\t'){
			SwapChar(p[0], str[++index]);
		}

		p++;
	}
}

int main_strspaces()
{
	char testCases[][20] = {
		"Hello world",
		"  Hello    ",
		"      Hello",
		"A B\tC D E  ",
		""
	};

	for (int i = 0; i < 20; ++i){
		cout << setw(3) << left << i;
	}
	cout << endl;

	for (int i = 0; i < sizeof(testCases) / sizeof(testCases[0]); ++i){
		cout << "Before processing" << endl;
		PrintString(testCases[i]);

		MoveSpaceToStart(testCases[i]);

		cout << "After processing" << endl;
		PrintString(testCases[i]);
		cout << "--------------------" << endl;
	}
	return 0;
}