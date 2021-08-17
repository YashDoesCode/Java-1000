
public class UTF8ValidationBit {

    public boolean validUtf8(int[] data) { int bytes = 0;
        for (int d : data) { if (bytes == 0) { if ((d >> 5) == 0b110) bytes = 1;
                else if ((d >> 4) == 0b1110) bytes = 2;
                else if ((d >> 3) == 0b11110) bytes = 3;
                else if ((d >> 7) != 0) return false;
            } else { if ((d >> 6) != 0b10) return false;
                bytes--;
            } } return bytes == 0;
    };
}
