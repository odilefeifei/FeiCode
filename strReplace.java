
public class strReplace {
	public static void main(String args[]){
		String bmldyj = "";
		String bmldyj_p = "<p>����̬�Ⱥã������������ɹ��Ȼ</p></p><p><br/>";
		System.out.println(bmldyj_p);
		bmldyj = bmldyj_p.replace("<p>", "").replace("</p>", "").replace("<br/>", "");
		System.out.println(bmldyj);
	}
}
