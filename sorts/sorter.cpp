#include<stdlib.h>
#include <array>
#include <iostream>
#include "sorts.h"
using namespace std;

class Sorter {
		int listlength;
		int nummax;
		int* unsorted;
	public:
		void init_list (int,int);
		void print_list(int*);
		int * getList();
		bool sortTest(int*, int);
};

int * Sorter::getList()
{
	return unsorted;
}

void Sorter::print_list(int * l)
{
	int t;
	for(int a = 0; a < listlength; a = a + 1) {
		cout << l[a] << " ";
	}
	cout << "\n";
	t = sortTest(l,listlength);
	if(t) { cout << "Sort test succeded\n\n"; }
	else { cout << "sort test failed\n\n"; }
}

void Sorter::init_list(int llength, int nummax) {
	listlength = llength;
	int * l = new int [listlength];
	for(int i = 0; i < listlength; i=i+1) {
		l[i] = (rand() % nummax + 1);
	}
	unsorted = l;
}

bool Sorter::sortTest(int* theo_sort, int length) {
	for( int i = 0; i < length-1; i = i+1) {
		if (theo_sort[i] > theo_sort[i+1]) {
			return 0;
		}
	}
	return 1;
}

int main()
{
	int * sorted;
	int ll,rn;
	Sorter s;
	Sorts st;
	printf("size of list: ");
	scanf("%d",&ll);
	printf("range of random nums: ");
	scanf("%d",&rn);

	s.init_list(ll,rn);
	cout << "Initial list: \n";
	s.print_list(s.getList());

	sorted = st.selectionSort(s.getList(), ll);
	s.print_list(sorted);

	sorted = st.insertionSort(s.getList(), ll);
	s.print_list(sorted);

	sorted = st.bubbleSort(s.getList(), ll);
	s.print_list(sorted);

	sorted = st.mergeHelp(s.getList(), ll);
	s.print_list(sorted);

	sorted = st.quickHelp(s.getList(), ll);
	s.print_list(sorted);

	free(sorted);
	return 0;
}
