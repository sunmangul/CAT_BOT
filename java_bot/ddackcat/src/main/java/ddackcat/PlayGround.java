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
				event.getChannel().sendMessage("�� ���� �ҰԿ�! ������!");
				truecka(api, mes);
				break;
			default:
				long ckashaki;
				try {
					ckashaki = event.getChannel().sendMessage("�� ���� �ҰԿ�! ������..").get().getId();
					Thread.sleep(500);
				Message.edit(api, send.getId(), ckashaki, "[error : �� �� ���� ����ڿ� ���� ���ܵǾ����ϴ�.]");
				}catch(Exception e) {e.printStackTrace();}
				break;
			}
	} 

	private static void truecka(DiscordApi api, String mes) {
		api.addMessageCreateListener(event -> {
			String[] dir = {"����", "������"};
			int i = (int)(Math.random()*2);
			System.out.println(dir[i]);
			if(event.getMessage().getContent().startsWith("������")) {
				if("������".equals(dir[i])) {
					event.getChannel().sendMessage("�������߽��ϴ�.");
				}
				else {
					event.getChannel().sendMessage("�� ��Ƴ��Ҿ�.");
				}
			}
			else if(event.getMessage().getContent().startsWith("����")) {
				if("����".equals(dir[i])) {
					event.getChannel().sendMessage("�������߽��ϴ�.");
				}
				else {
					event.getChannel().sendMessage("�� ��Ƴ��Ҿ�.");
				}
			}
			return;
		}).removeAfter(8, TimeUnit.SECONDS);

		
	}
	protected static void rsp(String mes, MessageCreateEvent event) {
		String[] user = mes.split(" ");

		int com = (int) (Math.random() * 3);
		if (com == 0) {
			event.getChannel().sendMessage("����... ����!");
		} else if (com == 1) {
			event.getChannel().sendMessage("����... ����!");
		} else if (com == 2) {
			event.getChannel().sendMessage("����... ��!");
		}
		int intUser = 0;
		String a = user[2];
		if (a.equals("����"))
			intUser = 0;
		else if (a.equals("����"))
			intUser = 1;
		else if (a.equals("��"))
			intUser = 2;
		else {
			event.getChannel().sendMessage("������ ������ ���� ����");
			return;
		}

		if (com == 0) {
			if (intUser == 0) {
				event.getChannel().sendMessage("���٤���");
			}
			if (intUser == 1) {
				event.getChannel().sendMessage("���� ����..");
			}
			if (intUser == 2) {
				event.getChannel().sendMessage("���� ����̴� �������Ӥ�");
			}
		}

		if (com == 1) {
			if (intUser == 0) {
				event.getChannel().sendMessage("���ڴ� �ָ� ���̰�" + "(���� �ܴ��̴� �߼�ȭ �߽��ϴ�.)");
			}
			if (intUser == 1) {
				event.getChannel().sendMessage("���٤���");
			}
			if (intUser == 2) {
				event.getChannel().sendMessage("���� ���������� ���� ���");
			}
		}

		if (com == 2) {
			if (intUser == 0) {
				event.getChannel().sendMessage("����þ� ����");
			}
			if (intUser == 1) {
				event.getChannel().sendMessage("��");
			}
			if (intUser == 2) {
				event.getChannel().sendMessage("���� �� ����");
			}
		}

	}
}
