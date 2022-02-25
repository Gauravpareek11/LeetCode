class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a=version1.split("[.]");
        String[] b=version2.split("[.]");
        int i=0;
        int j=0;
        while(i<a.length && j<b.length){
            if(Integer.parseInt(a[i])>Integer.parseInt(b[i])) return 1;
            else if(Integer.parseInt(a[i])<Integer.parseInt(b[i])) return -1;
            i++;
            j++;
        }
        while(i<a.length){
            if(Integer.parseInt(a[i])!=0) return 1;
            i++;
        }
        while(j<b.length){
            if(Integer.parseInt(b[j])!=0) return -1;
            j++;
        }
        return 0;
    }
}