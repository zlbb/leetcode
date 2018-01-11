//https://leetcode.com/problems/3sum/description/
var arrSort = function(arr){
    arr.sort(function(a,b){
        if(a>b) return 1;
        else if(a<b) return -1;
        return 0;
    })
    return arr;
}
function threeSum(nums){
    var arr2 = arrSort(nums);
    // let arr2 = Array.from(new Set(arr1))
    var length = arr2.length;
    let res = [];
    for(let index = 0; index<length; index++){
        let sum = 0 - arr2[index];
        let element = arr2[index];
        let i = index + 1, j = arr2.length - 1;
        while(i<j){
            if(arr2[i] + arr2[j] == sum){
                res.push([element, arr2[i],arr2[j]]);
                while( i<j & arr2[i] == arr2[i+1]) i++;
                while( i<j & arr2[j] == arr2[j+1]) j--;
                i++;
                j--;
            }
            while(arr2[i] + arr2[j] < sum) i++;
            while(arr2[i] + arr2[j] > sum) j--;
        }
        while(index<length & arr2[index]==arr2[index+1]) index++;
    }
    return res;
}
console.log(threeSum([-1, 0,3,-7,-2,0,1,-1,-1,2]))