class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        int sign = 1;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sign = -1;
        }
        
        long up = Math.abs(numerator);
        long down = Math.abs(denominator);

        if (up == 0) {
            return sign > 0 ? Integer.toString(Integer.MAX_VALUE) : Integer.toString(Integer.MIN_VALUE);
        }

        StringBuffer sb = new StringBuffer();
        if (sign < 0) {
            sb.append('-');
        }

        sb.append(up / down);
        up = up % down;
        if (up == 0) {
            return sb.toString();
        }

        sb.append('.');
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        int index = sb.length();
        while (up > 0) {
            if (map.containsKey(up)) {
                int offset = map.get(up).longValue();
                sb.insert(map.get(up).intValue(), '(');
                sb.append(')');
                return sb.toString();
            }

            map.put(up, index++);
            up = up * 10;
            sb.append(up / down);
            up = up % down;
        }

        return sb.toString();
    }
}