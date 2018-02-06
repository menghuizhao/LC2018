class Solution {
    public String addBinary(String a, String b) {
        int ia = a.length() - 1;
        int ib = b.length() - 1;
        int degree = 0;
        String ret = "";
        while (ia >= 0 || ib >= 0 || degree > 0) {
            int na = ia >= 0 ? a.charAt(ia) - '0' : 0;
            int nb = ib >= 0 ? b.charAt(ib) - '0' : 0;
            ret = (na + nb + degree) % 2 + ret;
            degree = (na + nb + degree) / 2;
            ia--;
            ib--;
        }
        
        return ret;
    }
}