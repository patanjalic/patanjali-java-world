#include"misc.h"

int main_quicksort()
{
	int test[] = { 7, -13, 1, 3, 10, 5, 2, 4 };
	int N = sizeof(test) / sizeof(int);

	cout << "Size of test array :" << N << endl;

	cout << "Before sorting : " << endl;
	print(test, N);

	quickSort(test, 0, N - 1);

	cout << endl << endl << "After sorting : " << endl;
	print(test, N);

	return 0;
}

/**
* Quicksort.
* @param a - The array to be sorted.
* @param first - The start of the sequence to be sorted.
* @param last - The end of the sequence to be sorted.
*/
void quickSort(int a[], int first, int last)
{
	int pivotElement;

	if (first < last)
	{
		pivotElement = pivot(a, first, last);
		quickSort(a, first, pivotElement - 1);
		quickSort(a, pivotElement + 1, last);
	}
}

/**
* Find and return the index of pivot element.
* @param a - The array.
* @param first - The start of the sequence.
* @param last - The end of the sequence.
* @return - the pivot element
*/
int pivot(int a[], int first, int last)
{
	int  p = first;
	int pivotElement = a[first];

	for (int i = first + 1; i <= last; i++)
	{
		/* If you want to sort the list in the other order, change "<=" to ">" */
		if (a[i] < pivotElement)
		{
			p++;
			swap(a[i], a[p]);
		}
	}

	swap(a[p], a[first]);

	return p;
}


/**
* Swap the parameters.
* @param a - The first parameter.
* @param b - The second parameter.
*/
void swap(int& a, int& b)
{
	int temp = a;
	a = b;
	b = temp;
}

/**
* Swap the parameters without a temp variable.
* Warning! Prone to overflow/underflow.
* @param a - The first parameter.
* @param b - The second parameter.
*/
void swapNoTemp(int& a, int& b)
{
	a -= b;
	b += a;// b gets the original value of a
	a = (b - a);// a gets the original value of b
}

/**
* Print an array.
* @param a - The array.
* @param N - The size of the array.
*/
void print(int a[], const int& N)
{
	for (int i = 0; i < N; i++)
		cout << "array[" << i << "] = " << a[i];
}
