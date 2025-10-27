class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length , ans = 0;
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = countOnes(bank[i]);
        }
        int i = 0 , j = 0;
        while(i < n && arr[i] == 0)
        {
            i++;
        }
        j = i + 1;
        while(j < n)
        {
            while(j < n && arr[j] == 0)
            {
                j++;
            }
            if(i < n && j < n)
            {
                ans += arr[i] * arr[j];
                i = j;
                j++;
            }
        }
        return ans;
    }

    public int countOnes(String s)
    {
        int c = 0;
        for(char ch : s.toCharArray())
        {
            if(ch == '1')
            {
                c++;
            }
        }
        return c;
    }
}