public class Space3DDistance {

    public double distance(int[] p1, int[] p2) { int dx = p1[0] - p2[0], dy = p1[1] - p2[1], dz = p1[2] - p2[2];
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    };
}
