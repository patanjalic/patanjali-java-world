#include"misc.h"
#include <iterator>
#include <map>

typedef std::map<int, int>::iterator m_t;

int main_maperase()
{
	std::map<int, int> m;

	m[1] = 1; m[2] = 2; m[3] = 3; m[4] = 4;
	m[5] = 5; m[6] = 6; m[7] = 7; m[8] = 8; m[9] = 9;
	m[10] = 10; m[11] = 11;

	//m_t it = m.begin();
	//for (auto it = m.begin(); it != m.end(); ++it) m.erase(it++);

	//it = m.begin();
//	for (auto it=m.begin(); it != m.end(); ++it) {
//		std::cout << it->first << " , " << it->second << std::endl;
//	}
	return 0;
}
