#include"misc.h"
template<typename T>
class smart_pointer{
	T* pointer;
	std::size_t *refs;

	void clear(){
		if (!--*refs){
			delete pointer;
			delete refs;
		}
	}

public:
	smart_pointer(T* p = NULL)
		: pointer(p), refs(new std::size_t(1))
	{}
	smart_pointer(const smart_pointer<T>& other)
		: pointer(other.pointer), refs(other.refs)
	{
		++*refs;
	}
	~smart_pointer(){
		clear();
	}

	smart_pointer<T>& operator=(const smart_pointer<T>& other){
		if (this != &other){
			clear();

			pointer = other.pointer;
			refs = other.refs;
			++*refs;
		}
		return *this;
	}

	smart_pointer<T>& operator=(T* p){
		if (pointer != p){
			pointer = p;
			*refs = 1;
		}
		return *this;
	}

	T& operator*(){
		return *pointer;
	}

	const T& operator*() const{
		return *pointer;
	}

	T* operator->(){
		return pointer;
	}

	const T* operator->() const{
		return pointer;
	}

	std::size_t getCounts(){
		return *refs;
	}
};

struct foo{
	int a;
};

template<typename pointer_t>
class bar{
	pointer_t f_;

public:
	bar(foo *f)
		:f_(f)
	{}

	void set(int a){
		f_->a = a;
	}
};

int main_smartptr()
{
	foo *f = new foo;

	typedef smart_pointer<foo> ptr_t;
	//    typedef boost::shared_ptr<foo> ptr_t;
	//    typedef foo* ptr_t;

	bar<ptr_t> b(f);
	for (unsigned int i = 0; i<300000000; ++i)
		b.set(i);

	//    delete f;
	return 0;
}