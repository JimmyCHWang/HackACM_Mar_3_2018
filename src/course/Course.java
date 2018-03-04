package course;

public class Course {
	private String D; // Department
	private int num; // Course #
	private String alphabet; // The alphabet after the course #
	private String des; // Description
	private CourseSimp[] pre; // Prerequisites
	private int pren; // Number of Prerequisites
//	private boolean[] seasons; // In what season(s) does this course provided
	public Course (String dept, int numb, String alphabet, String desc, CourseSimp[] prer, int prern, boolean fal, boolean win, boolean spr) {
		D = dept;
		num = numb;
		this.alphabet = alphabet;
		des = desc; 
		pre = prer;
		pren = prern;
//		seasons = new boolean[3]; seasons[0]=fal; seasons[1]=win; seasons[2]=spr;
	}
	public Course (String dept, int numb, String alphabet, String desc, CourseSimp[] prer, int prern) {
		D = dept;
		num = numb;
		this.alphabet = alphabet;
		des = desc; 
		pre = prer;
		pren = prern;
//		seasons = new boolean[3]; for (int i=0;i<3;i++) seasons[i]=true;
	}
	public Course (String dept, int numb, String alphabet, String desc) {
		D = dept;
		num = numb;
		this.alphabet = alphabet;
		des = desc; 
		pre = new CourseSimp[10];
		pren = 0;
//		seasons = new boolean[3]; for (int i=0;i<3;i++) seasons[i]=true;
	}
	public Course (String dept, int numb, String alphabet) {
		D = dept;
		num = numb;
		this.alphabet = alphabet;
		des = "NULL";
		pre = new CourseSimp[10];
		pren = 0;
//		seasons = new boolean[3]; for (int i=0;i<3;i++) seasons[i]=true;
	}
	public Course (String dept, int numb) {
		D = dept;
		num = numb;
		this.alphabet = "";
		des = "NULL";
		pre = new CourseSimp[10];
		pren = 0;
//		seasons = new boolean[3]; for (int i=0;i<3;i++) seasons[i]=true;
	}
	public void clear() {
		D = "";
		num = 0;
		des = "";
		pre = new CourseSimp[10];
		pren = 0;
//		seasons = new boolean[3]; for (int i=0;i<3;i++) seasons[i]=true;
	}
	public String getDept() {
		return D;
	}
	public String getDesc() {
		return des;
	}
	public int getNum() {
		return num;
	}
	public String getAlpha() {
		return alphabet;
	}
	public void setAlpha(String alpha) {
		alphabet = alpha;
	}
	public void setDesc(String desc) {
		des = desc;
	}
	public void addPrereq(CourseSimp c) {
		pre[pren++] = c;
	}
	public CourseSimp[] getAllPrereq() {
		return pre;
	}
	public int getNumPrereq() {
		return pren;
	}
/*	
    public boolean checkseasons(int n) {
		return seasons[n];
	}

	public void updateseasons(int qua, boolean value) {
		seasons[qua] = value;
	}
	public void updateseasons(boolean fal, boolean win, boolean spr) {
		seasons[0] = fal;
		seasons[1] = win;
		seasons[2] = spr;
	}
*/	
	public boolean checkSame(CourseSimp a) {
		if (D.equals(a.getDept()) && num == a.getNum() && alphabet.equals(a.getAlpha())) return true;
		return false;
	}
}
