import course.*;

public class AOV {
	// Activity On Vertex Network - Topological Sorting
	
	public static CourseSimp[][] Topo_Sort(Course[] a) throws Exception {
		CourseSimp[] c = new CourseSimp[a.length];
		for (int i=0; i<a.length; i++) {
			c[i] = new CourseSimp(a[i].getDept(),a[i].getNum(),a[i].getAlpha());
		}
		
		Edge[] e = new Edge[100000]; int en = 0;
		int[] ind = new int[c.length+1]; // How many vertices pointing
		int[] otd = new int[c.length+1];
		for (int i=0; i<c.length; i++) { ind[i] = 0; otd[i] = 0; }
		for (int i=0; i<10000; i++) {e[i] = new Edge(-1,-1);}
		for (int i=0; i<c.length; i++) {
			CourseSimp[] d = a[i].getAllPrereq();
			int dn = a[i].getNumPrereq();
			for (int j=0; j<dn; j++) {
				int pos = -1;
				for (int k=0; k<a.length; k++) if (a[k].checkSame(d[j])) pos = k;
				if (pos != -1) {
					e[en].u = pos;
					e[en].v = i;
					en++;
					ind[i]++;
					otd[pos]++;
				} else {
					throw new Exception("Course Data Error: Prereq course not found");
				}
			}
		}
		
//		for (int i=0; i<10; i++) System.out.println(e[i].u+" "+e[i].v);
		
		
		boolean f; 
		int rnd=-1;
		int tmpen = en;
		int[][] outlist = new int[1000][1000]; //The final order
		do {
			rnd++;
			f = false;
			for (int i=0; i<1000; i++) outlist[rnd][i] = -1;
			int j = 0;
			for (int i=0; i<c.length; i++) 
				if (ind[i] == 0) {
					outlist[rnd][j++] = i;
					f = true;
			}
			
			for (int i=0; i<j; i++) {
				for (int k=0; k<en; k++) {
					if (outlist[rnd][i] == e[k].u) {
						ind[e[k].v]--;
						e[k].u = -1; e[k].v = -1;
						tmpen--;
					}
				}
			}
			
		} while (f && tmpen>0);
		
		if (tmpen == 0) {
			CourseSimp[][] ans = new CourseSimp[1000][1000];
			for (int i=0; i<rnd; i++) {
				int j=0;
				int[] temp = new int[1000];
				while (outlist[i][j] != -1) {
					temp[j] = outlist[i][j];
					j++;
				}
				for (int m=0; i<j-1; m++)
					for (int n=i+1;n<j;n++) {
						if (otd[temp[m]]<otd[temp[n]]) {
							int t = temp[m];
							temp[m] = temp[n];
							temp[n] = t;
						}
				}
				for (int k=0;k<j;k++) ans[i][k] = c[temp[k]];
			}
			return ans;
		} else {
			throw new Exception("Topo_Sort Error: Possible Circle Exists");
		}
	}
}
