#include <iostream>
#include <string.h>
#include <vector>
using namespace std;
class Sorts {

  public:
      int * selectionSort(int *, int);
      int * insertionSort(int *, int);
      int * bubbleSort(int *,int);
      int * mergeHelp(int *, int);
      int * quickHelp(int *, int);
      int * quickSort(int *, int, int, int);
      int partition (int*,int,int);
      vector<int> mergeSort(vector<int>);
      vector<int> merge(vector<int>,vector<int>);
};

int * Sorts::quickHelp (int * unsorted, int length)
{
  int * sorted = new int [length];
  memcpy(sorted, unsorted, sizeof(&unsorted)*(length/2));
  cout << "Quick\n";
  sorted = quickSort(sorted, length, 0, length-1);
  return sorted;
}

int * Sorts::quickSort(int * unsorted, int length, int lo, int hi)
{
  int p;
  if(lo < hi) {
    p = partition(unsorted, lo, hi);
    quickSort(unsorted, length, lo, p);
    quickSort(unsorted, length, p+1, hi);
  }
  return unsorted;
}

int Sorts::partition(int * arr, int lo, int hi)
{
   int begin = lo;
   int pivot = arr[lo];
   while(lo < hi)
   {
       if(arr[lo] < pivot )
       {
               lo = lo + 1;
       }
       else if(arr[hi] > pivot || arr[lo] == arr[hi])
       {
               hi=hi-1;
       }
       //if p1 is greater than pivot and p2 is less than pivot, the next conditional is necessarily true.
       else if(arr[lo] > arr[hi])
       {
               int temp = arr[lo];
               arr[lo] = arr[hi];
               arr[hi] = temp;
               //this swaps p1 and p2 so that the first two conditionals are necessarily true.
       }
   }
   if(pivot != arr[lo])
   {
           //moves the pivot inbetween all the numbers lower than it and higher than it
           int temp = arr[begin];
           arr[begin] = arr[hi - 1];
           arr[hi - 1] = temp;
   }
   return lo;
}

int * Sorts::selectionSort(int * unsorted, int length)
{
  int * sorted = new int [length];
  memcpy(sorted, unsorted, sizeof(&unsorted)*(length/2));
  cout << "Select\n";
  int comps = 0;
  int swap = 0;
  int t;
  for( int i = 0; i < length; i = i + 1) {
    for( int j = i+1; j < length; j = j + 1) {
      comps = comps + 1;
      if(sorted[i] > sorted[j]) {
        t = sorted[j];
        sorted[j] = sorted[i];
        sorted[i] = t;
        swap = swap + 1;
      }
    }
  }
  cout << "steps: " << comps << " swaps: " << swap <<  "\n";
  return sorted;
}

int * Sorts::insertionSort(int * unsorted, int length)
{
  int * sorted = new int [length];
  memcpy(sorted, unsorted, sizeof(&unsorted)*(length/2));
  cout << "Insert\n";
  int comps = 0;
  int swap = 0;
  int t;
  for( int i = 0; i < length; i = i + 1) {
    for(int j = i; j > -1; j = j - 1) {
      comps = comps + 1;
      if(sorted[j] < sorted[j-1]) {
        t = sorted[j];
        sorted[j] = sorted[j-1];
        sorted[j-1] = t;
        swap = swap + 1;
      }
    }
  }
  cout << "steps: " << comps << " swaps: " << swap <<  "\n";
  return sorted;
}

int * Sorts::bubbleSort(int * unsorted, int length)
{
  int * sorted = new int [length];
  memcpy(sorted, unsorted, sizeof(&unsorted)*(length/2));
  cout << "Bubble\n";
  int comps = 0;
  int swap = 0;
  int t;
  bool didswap = 1;
  while(didswap) {
    didswap = 0;
    for(int i = 0; i < length-1; i = i+1) {
      comps = comps + 1;
      if (sorted[i] > sorted[i+1]) {
        t = sorted[i+1];
        sorted[i+1] = sorted[i];
        sorted[i] = t;
        swap = swap + 1;
        didswap = 1;
      }
    }
  }
  cout << "steps: " << comps << " swaps: " << swap <<  "\n";
  return sorted;
}

int* Sorts::mergeHelp(int* unsorted, int length)
{
  vector<int> unsortedv;
  for( int i = 0; i < length; i = i+1) {
    unsortedv.push_back(unsorted[i]);
  }
  cout << "Merge\n";
  vector<int> sorted = mergeSort(unsortedv);
  int * sarr = new int[length];
  for(int i = 0; i < sorted.size(); i = i +1) {
    sarr[i] = sorted[i];
  }
  return sarr;
}

vector<int> Sorts::mergeSort(vector<int> arr)
{
  if(arr.size() == 1) { return arr; }
  else
  {
    vector<int>::const_iterator first = arr.begin();
    vector<int>::const_iterator mid = arr.begin() + arr.size()/2;
    vector<int>::const_iterator end = arr.end();
    vector<int> L(first,mid);
    vector<int> R(mid,end);
    L = mergeSort(L);
    R = mergeSort(R);
    vector<int> merged = merge(L,R);
    return merged;
  }
}

vector<int> Sorts::merge(vector<int> L, vector<int> R) {
  int lp = 0;
  int rp = 0;
  vector<int> merged;
  while( lp < L.size() || rp < R.size()) {
    if(rp == R.size()) {
      merged.push_back(L[lp]);
      lp = lp +1;
    }
    else if(lp == L.size()) {
      merged.push_back(R[rp]);
      rp = rp +1;
    }
    else if(L[lp] > R[rp]) {
      merged.push_back(R[rp]);
      rp = rp +1;
    }
    else {
      merged.push_back(L[lp]);
      lp = lp +1;
    }
  }
  return merged;
}
