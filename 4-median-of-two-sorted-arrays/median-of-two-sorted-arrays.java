class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] temp = new  int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
              temp[k++] = nums1[i++];
            }else{
                temp[k++] = nums2[j++];
            }
        }
        while(i < m){
            temp[k++] = nums1[i++];
        }
        while(j < n){
            temp[k++] = nums2[j++];
        }
        
        int mid = (m+n)/2;
        if((m+n) % 2 == 0){
            return (double)(temp[mid]+temp[mid-1])/2;
        }else{
            return (double)temp[mid];
        }
    }
}