/*
 * weakPointerDemo.cpp
 *
 *  Created on: Mar 8, 2015
 *      Author: Admin
 */
#include <iostream>
#include <memory>

std::weak_ptr<int> gw;

void f()
{
    if (auto spt = gw.lock()) { // Has to be copied into a shared_ptr before usage
	std::cout << *spt << "\n";
    }
    else {
        std::cout << "gw is expired\n";
    }
}

int main_weak_ptr_demo()
{
    {
        auto sp = std::make_shared<int>(42);
        gw = sp;

        f();
    }

    f();
	return 0;
}
