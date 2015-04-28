#include"misc.h"
#include<unordered_map>

void find_most_occuring_char(string s){
	string::const_iterator it = s.begin();
	unordered_map<char, long> m;
	unsigned max = 0;
	char ch = 0;
	for (; it != s.end(); it++){
		if (m.find(*it) != m.end()){
			m.at(*it) = m.at(*it) + 1;
			if (m.at(*it) > max){
				max = m.at(*it);
				ch = *it;
			}
		}
		m.emplace(*it, 1);
	}
	for (auto& x : m)
		cout << x.first << "  " << x.second;
	//cout << max << "  " << ch;
}
int main_find_most_occuring_char(){
	find_most_occuring_char("aaassdfsdhhh");
	return 0;
}
