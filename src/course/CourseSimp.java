package course;

public class CourseSimp {
		private String Dept;
		private int num;
		private String alpha;
		public CourseSimp (String d, int i, String a) {
			Dept = d;
			num = i;
			alpha = a;
		}
		public String getDept() {
			return Dept;
		}
		public int getNum() {
			return num;
		}
		public String getAlpha() {
			return alpha;
		}
		public boolean checkSame(CourseSimp a) {
			if (Dept.equals(a.getDept()) && num == a.getNum() && alpha.equals(a.getAlpha())) return true;
			return false;
		}
}
