public class VoxelGrid3D {

    private final boolean[][][] voxels;

    public VoxelGrid3D(int dim) {
        this.voxels = new boolean[dim][dim][dim];
    }

    public void setVoxel(int x, int y, int z, boolean active) {
        voxels[x][y][z] = active;
    }

    public int countActiveVoxels() {
        int count = 0;
        for (int i = 0; i < voxels.length; i++) {
            for (int j = 0; j < voxels[0].length; j++) {
                for (int k = 0; k < voxels[0][0].length; k++) {
                    if (voxels[i][j][k]) count++;
                }
            }
        }
        return count;
    }
}
