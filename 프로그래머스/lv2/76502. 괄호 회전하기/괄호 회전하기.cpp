#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    vector<char> v;
    string str1, str2, temp;
    if (s.length() % 2 != 0) return 0;
    for (int i = 0; i < s.length(); i++) {
        bool flag = true;
        temp.clear();
        
        v.clear();
        str1.assign(s, 0, i);
        str2.assign(s, i, s.length() - i);
        temp.append(str2, 0, str2.length());
        temp.append(str1, 0, str1.length());
        if (temp.at(0) == ')' || temp.at(0) == ']' || temp.at(0) == '}') {
            continue;
        }
        if (temp.at(temp.length() - 1) == '(' || temp.at(temp.length() - 1) == '[' ||
            temp.at(temp.length() - 1) == '{') {
            continue;
        }
        if (flag) {
            for (int j = 0; j < temp.length(); j++) {
                if (temp.at(j) == '(' || temp.at(j) == '[' ||
                    temp.at(j) == '{') {
                    v.push_back(temp.at(j));
                } else {
                    if (temp.at(j) == ')') {
                        if (v.back() != '(') {
                            flag = false;
                            break;
                        }
                        v.pop_back();
                    } else if (temp.at(j) == ']') {
                        if (v.back() != '[') {
                            flag = false;
                            break;
                        }
                        v.pop_back();
                    } else if (temp.at(j) == '}') {
                        if (v.back() != '{') {
                            flag = false;
                            break;
                        }
                        v.pop_back();
                    }
                }
            }
        }
        if (flag && v.size() == 0) answer++;
    }
    return answer;
}