
public class strReplace {
	public static void main(String args[]){
		String bmldyj = "";
		String bmldyj_p = "<p>工作态度好，积极工作，成果斐然</p></p><p><br/>";
		System.out.println(bmldyj_p);
		bmldyj = bmldyj_p.replace("<p>", "").replace("</p>", "").replace("<br/>", "");
		System.out.println(bmldyj);
	}
}
