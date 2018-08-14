class Solution{
  public void qsort(int[] arr){
    qsortHelper(arr, 0, arr.length-1);
  }
  public void qsortHelper(int[] arr,int begin,int end){
    if(end <= begin ){
      return;
    }
    int p = arr[end];
    int i = begin;
    int j = end;
    while(i<j){
      while(i<j&&arr[i]<=p) i++;
      arr[j] = arr[i];
      while(i<j&&arr[j]>=p) j--;
      arr[i] = arr[j];
    }
    arr[i] = p;
    qsortHelper(arr, begin, i-1);
    qsortHelper(arr, i+1,end);
  }
}

int[] arr = new int[]{1,5,3,2,0,2,2,2,2,4};
new Solution().qsort(arr);
System.out.println(Arrays.toString(arr));