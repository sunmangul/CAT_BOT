package ddackcat;

import java.util.concurrent.TimeUnit;

import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;

public class PlayGround extends ReadFile{
	protected static void cka(DiscordApi api, String mes, MessageCreateEvent event, TextChannel send) {
		int shaki = (int) (Math.random() * 10);
			switch (shaki) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				event.getChannel().sendMessage("자 먼저 할게요! 참참참!");
				truecka(api, mes);
				break;
			default:
				long ckashaki;
				try {
					ckashaki = event.getChannel().sendMessage("자 먼저 할게요! 참참ㅊ..").get().getId();
					Thread.sleep(500);
				Message.edit(api, send.getId(), ckashaki, "[error : 알 수 없는 사용자에 의해 차단되었습니다.]");
				}catch(Exception e) {e.printStackTrace();}
				break;
			}
	} 

	private static void truecka(DiscordApi api, String mes) {
		api.addMessageCreateListener(event -> {
			String[] dir = {"왼쪽", "오른쪽"};
			int i = (int)(Math.random()*2);
			System.out.println(dir[i]);
			if(event.getMessage().getContent().startsWith("오른쪽")) {
				if("오른쪽".equals(dir[i])) {
					event.getChannel().sendMessage("참수당했습니다.");
				}
				else {
					event.getChannel().sendMessage("오 살아남았어.");
				}
			}
			else if(event.getMessage().getContent().startsWith("왼쪽")) {
				if("왼쪽".equals(dir[i])) {
					event.getChannel().sendMessage("참수당했습니다.");
				}
				else {
					event.getChannel().sendMessage("오 살아남았어.");
				}
			}
			return;
		}).removeAfter(8, TimeUnit.SECONDS);

		
	}
	protected static void rsp(String mes, MessageCreateEvent event) {
		String[] user = mes.split(" ");

		int com = (int) (Math.random() * 3);
		if (com == 0) {
			event.getChannel().sendMessage("나는... 가위!");
		} else if (com == 1) {
			event.getChannel().sendMessage("나는... 바위!");
		} else if (com == 2) {
			event.getChannel().sendMessage("나는... 보!");
		}
		int intUser = 0;
		String a = user[2];
		if (a.equals("가위"))
			intUser = 0;
		else if (a.equals("바위"))
			intUser = 1;
		else if (a.equals("보"))
			intUser = 2;
		else {
			event.getChannel().sendMessage("가위나 바위나 보만 내줘");
			return;
		}

		if (com == 0) {
			if (intUser == 0) {
				event.getChannel().sendMessage("비겼다ㅏㅇ");
			}
			if (intUser == 1) {
				event.getChannel().sendMessage("으어 졌어..");
			}
			if (intUser == 2) {
				event.getChannel().sendMessage("역시 고양이는 가위지ㅣㅇ");
			}
		}

		if (com == 1) {
			if (intUser == 0) {
				event.getChannel().sendMessage("남자는 주먹 아이가" + "(물론 단단이는 중성화 했습니다.)");
			}
			if (intUser == 1) {
				event.getChannel().sendMessage("비겼다ㅏㅇ");
			}
			if (intUser == 2) {
				event.getChannel().sendMessage("누가 보내래ㅐㅇ 나쁜 사람");
			}
		}

		if (com == 2) {
			if (intUser == 0) {
				event.getChannel().sendMessage("으어ㅓ어 졌다");
			}
			if (intUser == 1) {
				event.getChannel().sendMessage("ㅋ");
			}
			if (intUser == 2) {
				event.getChannel().sendMessage("누가 보 내래");
			}
		}

	}
}
