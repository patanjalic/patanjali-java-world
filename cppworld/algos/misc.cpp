#include"misc.h"

//program to test diamond case of multiple inheritance

class a
{
private:
	int data;
public:
	void display();
};

class b: public a
{
private:
	int data;
public:
	void display();
};

class c: private a
{
private:
	int data;
public:
	void display();
};

class d : public b, public c
{
private:
	int data;
public:
	void display1();
};

void a::display()
{
	cout << "\nadata is " << this->data;
}

void b::display()
{
	cout << "\nbdata is " << this->data;
}

void c::display()
{
	cout << "\ncdata is " << this->data;
}

void d::display1()
{
	cout << "\nddata is " << this->data;
}

int main_diamond()
{
	a a;
	b b;
	c c;
	d d;
	cout << "\nsize of a is " << sizeof(a) << "\nsize of b is " << sizeof(b) << "\nsize of c is " << sizeof(c);
	cout << "\nsize of d is " << sizeof(d) << endl;
	return true;
}
//code to check how members are initialized in two different types of call
int main_contr()
{
	class a
	{
		int aaa;
	public:
		a()
		{

		}
		int geta()
		{
			return aaa;
		}
	};
	a* A = new a;
	a* B = new a();
	cout << "A is " << A->geta() << " B is " << B->geta();
	int* x = new int;
	int* y = new int();
	cout << "\nx is " << x << " y is " << y;
	return 0;
}
int main_atoi()
{
	char str[] = "             1234         ";
	int x;
	//sscanf_s(str,"%d",&x);
	//cout << "x is " << x;
	return 0;
}
//maked a111 to get evaluated during compile time
//constexpr int a111[] = { 1, 2, 3, 4, 5 };
//int b1[a111[2]];

/* function overloading cannot be determined based on return type alone */
//int a111()
//{
//	return 1;
//}
//
//char a111(int x)
//{
//	return 'a';
//}
//
//int main()
//{
//	int a = (int)A();
//	return 0;
//}
int main()
{
	//main_diamond();
	//main_quicksort();
	//main_hashmap();
	//main_template();
	//main_smartptr();
	//main_linkedlist();
	//main_nbn();
	//main_permu();
	//main_inter();
	//main_bst();
	//main_dtor();
	//main_palin();
	//main_strspaces();
	//main_logic();
	//main_vdtor();
	//main_weakptr();
	//main_4greatest();
	//main_ambi(0,NULL);
	//main_template();
	//main_transform();
	//main_maperase();
	//main_dctors();
	//main_constcast();
	//main_contr();
	//main_atoi();
	//main_staticbinding();
	//main_dfltctor();
	//main_reverseint();
	//main_infixtopostfix();
	//main_privateInheritance();
	//main_find_most_occuring_char();
	//main_number_words();
	//main_access_private();
	//main_iterator_demo();
	//main_weak_ptr_demo();
	main_stl_ctor();
	//cin.ignore();
	cin.get();
	return 0;
}
