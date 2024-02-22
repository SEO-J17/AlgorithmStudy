#include <iostream>

using namespace std;

int main(){
	int n,k;
	cin>>n>>k;
	int arr [n];
	int cnt=0;
	
	for(int i=0; i<n; i++){
		cin>>arr[i];
	}
	
	for(int j=n-1; j >= 0; j--){
		if(arr[j] <= k){
			while(arr[j] <= k){
				k=k-arr[j];
				cnt++;
				if(k == 0)
					break;
			}
		}else
			continue;
	}
	
	cout<<cnt;
	


	return 0;
}