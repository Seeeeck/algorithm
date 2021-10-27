package m09.d27;


public class BitArr {
    private final int INT_BIT_SIZE = 32;
    private final int size;
    private final int[] bitArr;

    public BitArr(int size) {
        this.size = size;
        bitArr = new int[(int) Math.ceil(size*1.0/INT_BIT_SIZE)];
    }

    public int get(int index){
        checkIndex(index);
        int numIndex = index / INT_BIT_SIZE;
        int bitIndex = index % INT_BIT_SIZE;
        return (bitArr[numIndex] >> bitIndex) & 1;
    }

    public void set(int index,int val){
        checkIndex(index);
        checkVal(val);
        int numIndex = index / INT_BIT_SIZE;
        int bitIndex = index % INT_BIT_SIZE;
        bitArr[numIndex] = bitArr[numIndex] | (1 << bitIndex);
    }

    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    private void checkVal(int val){
        if (val != 0 && val != 1){
            throw new RuntimeException();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i : bitArr) {
            String binaryString = Integer.toBinaryString(i);
            for (int j = binaryString.length() - 1; j >= 0; j--) {
                sb.append(binaryString.charAt(j));
            }
            char[] buf = new char[INT_BIT_SIZE-binaryString.length()];
            for(int j = INT_BIT_SIZE-binaryString.length() - 1; j >= 0; --j) {
                buf[j] = '0';
            }
            sb.append(buf);
        }
        return sb.substring(0,size);
    }

    private String repeat(char ch, int repeat) {
        if (repeat <= 0) {
            return "";
        } else {
            char[] buf = new char[repeat];
            for(int i = repeat - 1; i >= 0; --i) {
                buf[i] = ch;
            }
            return new String(buf);
        }
    }

    public static void main(String[] args) {
        BitArr arr = new BitArr(19);
        System.out.println(arr);
        arr.set(3,1);
        arr.set(2,1);
        System.out.println(arr);
        System.out.println(arr.get(2));
        arr.set(0,1);
        System.out.println(arr);
    }
}
