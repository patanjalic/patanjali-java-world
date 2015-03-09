#include"misc.h"

int reverse(int num)
{
	int rev = 0;
	while (num != 0)
	{
		rev = rev*10 + num%10;
		num /= 10;
	}
	return rev;
}
bool isPalindrome(int num)
{
	int div = 1;
	int x = num;
	while (x >= 10)
	{
		div *= 10;
		x /= 10;
	}
	while (num != 0)
	{
		int l = num % 10;
		int r = num / div;
		if (l != r) return false;
		num /= 10;
		div /= 10;
		num = num - r*div;
		div /= 10;
	}
	return true;
}

int main_reverseint()
{
	int num = 1001;
	cout << "\nrevsere is " << reverse(num);
	cout << "\nis palindrome " << isPalindrome(num);
	return 0;
}