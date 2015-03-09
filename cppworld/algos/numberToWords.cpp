/*
 * numberToWords.cpp
 *
 *  Created on: Mar 7, 2015
 *      Author: Admin
 */
#include"misc.h"

void print_words(int,int,int);
void print_digit(int);

int main_number_words()
{
	int num = 96021;
	print_words(num,0,0);
	cout<<"junk";
	return 0;
}

void print_words(int num, int x, int y)
{
	if(num > 0)
		print_words(num/10, num%10, y+1);
	print_digit(x);
	switch(y){
	case 2:
		cout<<"ten";
		break;
	case 3:
		cout<<"hundred";
		break;
	case 4:
		cout<<"thousand ";
		break;
	case 5:
		cout<<"Ten Thousand";
		break;
	case 6:
		cout<<"Lakh ";
		break;
	}
}

void print_digit(int x)
{
	switch(x){
		case 1:
			cout<<"one ";
			break;
		case 2:
			cout<<"two ";
			break;
		case 3:
			cout<<"three ";
			break;
		case 4:
			cout<<"four ";
			break;
		case 5:
			cout<<"five ";
			break;
		case 6:
			cout<<"six ";
			break;
		case 7:
			cout<<"seven ";
			break;
		case 8:
			cout<<"eight ";
			break;
		case 9:
			cout<<"nine ";
			break;
		}
}
