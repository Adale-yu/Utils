package test.string;

public class TestStringFormat {

	public static void main(String[] args) {
//		numberFormat();
		
		String content = "在多名番队成员的共同努力下，成功通关番队副本第%d章——%s，你作为挑战者之一做出了重要的贡献，获得了以下奖励：";
		String scontent = String.format(content, 1,"大胖子");
		System.out.println(scontent);
	}
	
	public static void numberFormat() {
		String str = ".4";
		
		Integer num = Integer.parseInt(str);
		System.out.println(num);
	}
}
