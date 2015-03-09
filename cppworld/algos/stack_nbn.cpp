/*Replace element of an Array with nearest bigger number at right side of the Array in O(n)
For example if the input Array is
7, 5, 6, 3, 4, 1, 2, 9, 11
output array should be
9, 6, 9, 4, 9, 2, 9, 11, 11 
*/
#include"misc.h"
#include<stack>

int main_nbn()
{
	int arr1[9] = { 7, 5, 6, 3, 4, 1, 2, 9, 11 };
	int arr2[9];
	unsigned int size = sizeof(arr1) / sizeof(int);
	stack<int> s;
	for (short i = 0; i < 9; i++)
	{
		s.push(arr1[i]);
	}
	for (short i = size - 1; i >= 0; i--)
	{
		while (!s.empty() && arr1[i] >= s.top())
			s.pop();
		if (s.empty())
		{
			arr2[i] = arr1[i];
		}
		else
		{
			arr2[i] = s.top();
		}
		s.push(arr1[i]);
	}
	for (short i = 0; i < size; i++)
	{
		cout << arr2[i] << " ";
	}
	return 0;
}