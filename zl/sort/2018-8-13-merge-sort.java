class Solution{
  public void msort(int[] arr){
    msortHelper(arr, 0, arr.length-1);
  }
  public void msortHelper(int[] arr,int begin,int end){

    if(end <= begin){
      return;
    }

    int i = (begin + end) /2;
    msortHelper(arr, begin, i);
    msortHelper(arr, i+1,end);
    int[] temp = new int[end - begin +1];
    for(int j =0,m=begin,n = i+1 ;j< end -begin +1;j++){
      if(m<=i&&n<=end)
      temp[j] = arr[m]<arr[n]?arr[m++]:arr[n++];
      else if(m>i)
        temp[j] = arr[n++];
      else 
        temp[j] = arr[m++];
    }
    for(int j =0 ;j<temp.length;j++){
      arr[j+begin] = temp[j];
    }
  }

}

int[] arr = new int[]{1,5,3,2,0,2,2,2,2,4};
new Solution().msort(arr);
System.out.println(Arrays.toString(arr));