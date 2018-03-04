import java.util.*;
import java.io.*;
import course.*;

public class Planner {
	
	static Scanner in;
	static PrintWriter out;
	
	static Course[] cList;
	static int cn;

	
	public static Course getCourse(String dept,int num, String alpha) {
		for (int i=0; i<cn; i++) {
			if (cList[i].getDept().equals(dept) && cList[i].getNum() == num && cList[i].getAlpha().equals(alpha)) return cList[i];
		}
		return null;
	}
	
	public static void initialization() throws Exception {
		Scanner coursein = new Scanner(new File("db/courseList.txt"));
		cList = new Course[1000];
		cn = 0;
		while (coursein.hasNext()) {
			cList[cn] = new Course(coursein.next(),coursein.nextInt());
			String alpha = coursein.next(); if (!alpha.equals("#")) cList[cn].setAlpha(alpha);
			coursein.nextLine();
			cList[cn].setDesc(coursein.nextLine());
			int reqn = coursein.nextInt();
			for (int i=0; i<reqn; i++) {
				String dept = coursein.next();
				int num = coursein.nextInt();
				String alp = coursein.next(); if (alp.equals("#")) alp = "";
				cList[cn].addPrereq(new CourseSimp(dept,num,alp));
			}
			cn++;
			coursein.nextLine();
		}
		coursein.close();
	}
	
	public static void display(CourseSimp[][] p) throws Exception {
		PrintWriter out = new PrintWriter(new FileWriter("PlanResult.txt"));
		
		int ses = 1; int crs = 0;
		for (int i=0; i<p.length; i++) {
			crs = 0;
			
			for (int j=0; j<p[0].length; j++) {
				if (p[i][j] != null) {
					crs++;
					Course temp = getCourse(p[i][j].getDept(),p[i][j].getNum(),p[i][j].getAlpha());
					out.println();
					out.printf("Course Name:%s %d%s\n", temp.getDept(),temp.getNum(),temp.getAlpha());
					out.printf("Description: \n", temp.getDesc());
					out.printf("Prerequisites:\n");
					CourseSimp[] t = temp.getAllPrereq();
					for (int k=0; k<temp.getNumPrereq(); k++) out.printf("%s %d%s\n", t[k].getDept(),t[k].getNum(),t[k].getAlpha());
					if (crs % 3 == 0) {
						ses++;
						out.println(); out.println(); out.println("Session "+ses+":");
					}
				}
			}
			if (crs % 3 !=0) { ses++; out.println("Session "+ses+":");}
		}
		out.close();
	}
	
	public static void work() throws Exception {
		Course[] clisttemp = new Course[cn];
		for (int i=0; i<cn; i++) clisttemp[i]=cList[i];
		CourseSimp[][] result = AOV.Topo_Sort(clisttemp);
		display(result);
	}
	
	public static void main(String[] args) throws Exception{
		initialization();
		work();
		return;
	}

}
