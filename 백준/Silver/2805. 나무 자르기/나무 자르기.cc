#include <bits/stdc++.h>
#define ll long long
#define ull unsigned long long
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	ll n, m;
	cin >> n >> m;
	ll* arr = new ll[n];
	for (int i = 0; i < n; i++)
		cin >> arr[i];

	ll sum = 0ll;
	ll upper= (ll)1e10, low = 0ll;
	ll mid;
	while (1)
	{
		mid = (upper + low) / 2;
		sum = 0ll;
		for (int i = 0; i < n; i++)
			if(arr[i]-mid >0)
				sum += arr[i] - mid;
		if (upper - low <= 1)
			break;
		if (sum > m)
			low = mid;
		else if (sum == m)
			break;
		else
			upper = mid;
	}

	cout << mid;

	return 0;
}