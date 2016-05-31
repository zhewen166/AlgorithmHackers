import java.util.Arrays;

public class MaxPointInline {
	Point points[] = {new Point(1, 1),new Point(1, 1),new Point(1, 1),new Point(2, 2)};
//			new Point(1, 2),new Point(0, 3),new Point(-1, 4)};
	class Point{
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}

	/**
	 * @param points
	 * @return
	 * @author xpxstar@gmail.com
	 * @2015��12��9��
	 * Given n points on a 2D plane, 
	 * find the maximum number of points that lie on the same straight line.
	 * ������ά��n���㣬�ж�����ж��ٸ�����ͬһ��ֱ����
	 */
	public int maxPoints(Point[] points){
		/*˼·���������е�
		 * ����ĳ�㣬����������õ��б�ʣ���ͬ����ͬһֱ�ߣ��ҵ���ͬ�����ġ�
		 */
		if(points.length<3){
			return points.length;
		}
		Float ratio[] = new Float[points.length];
		int maxNum = 1;
		for (int i = 0 ;i < points.length; i++) {
			int equal = 0;
			for (int j = 0; j < points.length;j++) {
				if ((points[i].x ==  points[j].x) &&(points[i].y ==  points[j].y)) {
					equal++;
				}
				ratio[j] = getRatio(points[i], points[j]);
			}
			int tmpNum = getDuplicate(ratio,equal);
			maxNum = tmpNum>maxNum?tmpNum:maxNum;
		}
		return maxNum;
	}
	private Float getRatio(Point p1,Point p2){
		if(p2.x==p1.x) return Float.NaN;
		return ((float) (p2.y-p1.y)/(float)(p2.x-p1.x));
	}
	private int getDuplicate(Float ratio[],int equal){
		int tmpnum = 0;
		Arrays.sort(ratio);
		for (int i = 0 ;i<ratio.length-1; i++) {
			int j = i+1;
			while (j<ratio.length && ratio[i].equals(ratio[j])) {
				j++;
			}
			if (ratio[i].isNaN()) {
				j-=equal;
			}
			tmpnum = tmpnum>(j-i)?tmpnum:j-i;
		}
		return tmpnum+equal;
	}
	public static void main(String[] args) {
		MaxPointInline  mp = new MaxPointInline();
//		System.out.println(mp.lengthOfLongestSubstring(mp.ss));
		
		System.out.println(mp.maxPoints(mp.points));
	}
}
