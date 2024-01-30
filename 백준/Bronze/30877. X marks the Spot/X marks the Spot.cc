#include <iostream>
#include <string>
using namespace std;

char change(char c)
{
	if ('a' <= c && c <= 'z') return c - 'a' + 'A';
	return c;
}

int main(void)
{
	ios_base::sync_with_stdio(false); cin.tie(NULL);
	string s, s2;
	int T, i, len;

	cin >> T;
	while (T--)
	{
		cin >> s >> s2;
		int len = s.length();
		for (i = 0; i < len; i++)
		{
			if (s[i] == 'x' || s[i] == 'X')
			{
				cout << change(s2[i]);
				break;
			}
		}
	}
}