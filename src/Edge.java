public class Edge {
	private int u;
	private int v;
	public Edge(int u,int v) {
		this.u = u;
		this.v = v;
	}
	public void setU(int i) {
		u = i;
	}
	public void setV(int i) {
		v = i;
	}
	public int getU() {
		return u;
	}
	public int getV() {
		return v;
	}
} // Means an edge pointing from U to V
