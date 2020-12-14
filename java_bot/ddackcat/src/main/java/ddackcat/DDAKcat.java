package ddackcat;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;
import java.time.Instant;

public class DDAKcat extends PlayGround {
	public static <channel> void main(String[] args) {
		//String token = "Nzg0MzcxMzk2OTk3Njc3MDc2.X8oUyQ.oMlUhXI6ZxPswRW2vP9DxYfJL1M";
		String token = "NzcyNzIyMDU0OTE4NDM4OTMy.X5-zfg.hiN6ITsglkkQXOWZ8lpCXVZsbAg";
		DiscordApi api = new DiscordApiBuilder().addServerBecomesAvailableListener(event -> {    
			System.out.println("Loaded " + event.getServer().getName());			//디스코드의 api를 끌어쓰기 위해 객체를 생성하고
		}).setToken(token).setWaitForServersOnStartup(false).login().join();		//리스너를 생성한다. 그리고 토큰을 지정해주고 로그인 후 채널에 들어온다.
		System.out.println("start! " + api.createBotInvite());

		api.addMessageCreateListener(event -> {
			Message message = event.getMessage();				//사용자가 입력을 받기 위한 메세지 변수
			TextChannel send = event.getChannel();				//딱딱이가 입력을 하기 위한 텍스트 채널 변수

			EmbedBuilder embed1 = new EmbedBuilder();			//임베드 생성을 위한 임베드 빌더
			String mes = message.getContent();					//입력받은 메세지를 간단하게 나타냄
			String userName = event.getMessageAuthor().getName(); //입력한 사용자 혹은 입력(언급)당한 사용자를 받아옴

			if (message.getAuthor().isBotUser()) {
				return;		//디스코드 정책상 다른 채팅봇의 입력을 받을 수 없게함
			}
			if (mes.startsWith("딱딱아 ")) {
				if (mes.contains("안녕")) {
					send.sendMessage("안녕 ㅇㅅㅇ!");
				} else if (mes.contains("굴러")) {
					send.sendMessage("데구르르 콰당탕탕탕!");
				}else if (mes.contains("배워")) {
					learn(mes, event);
				}

				else if (mes.contains("잊어")) {
					remember(mes, event);
				}

				else if (mes.contains("리스트")) {
					Color c = new Color(142, 161, 191);

					embed1.setColor(c);
					embed1.setTitle("내가 지금까지 배운 단어 리스트!").addField("단어:", liiist(mes, event), false)
							.setTimestamp(Instant.now());

					send.sendMessage(embed1);
				}

				else if (mes.contains("뭐할까") || mes.contains("뭐하지")) {
					work(mes, event);
				} else if (mes.contains("뭐해")) {
					work(mes, event);
				}

				else if (mes.contains("주인") || mes.contains("승냥이") || mes.contains("만든 사람")) {
					send.sendMessage("여기요!\n<@!668072089302990908>");
				}

				else if (mes.contains("뱉어")) {
					send.sendMessage(
							"여깄어\nhttps://discord.com/api/oauth2/authorize?client_id=772722054918438932&permissions=8&scope=bot");
				}

				else if (mes.contains("가위바위보")) {
					rsp(mes, event);
				}

				else if (mes.contains("참참참")) {
					cka(api, mes, event, send);
				}

				else if (mes.contains("놀아줘")) {
					Color c = new Color(142, 161, 191);
					embed1.setColor(c);
					embed1.setTitle("놀이마당").setThumbnail("https://i.imgur.com/y3CstGC.jpg").addField("가위바위보:",
							"손가락은 없지만 발가락을 이용하여 최선을 다해 가위바위보를 해드립니다\n." + "딱딱아 가위바위보 (가위, 바위, 보) 형식으로 적어주세요.", false)
							.addField("참참참", "참참참 놀이를 할 수 있습니다.\n" + "(참을 잘 못 외치면 \"그\"가 나타날 수 있으니 조심...!)", false)
							.setTimestamp(Instant.now());

					send.sendMessage(embed1);
				}
				else if (mes.contains("자기소개")) {
					Color c = new Color(142, 161, 191);
					embed1.setColor(c);
					embed1.setTitle("이름:").setDescription("딱딱이").setThumbnail("https://i.imgur.com/dc8yxFD.jpg")
							.addField("나이:", "한살", false).addField("생일:", "2020년 11월 10일", false)
							.setTimestamp(Instant.now());

					send.sendMessage(embed1);
				}
				else if (mes.contains("도움말") || mes.contains("명령어") || mes.contains("도와줘")) {
					Color c = new Color(142, 161, 191);
					embed1.setColor(c);
					embed1.setTitle("기본적인 명령어[1/2]").addField("자기소개 :", "딱딱이의 기본 정보를 알려줍니다.")
							.addField("굴러 : ", "GSM봇이라면 기초적으로 가지는 자질 구르기 입니다" + "\n딱딱이가 굴러드립니다.")
							.addField("배워:", "딱딱아 배워 (단어):(내용) 형식으로 쓰며," + "\n딱딱이에게 원하는 말을 가르칠 수 있습니다.")
							.addField("잊어:", "가르쳐 놓고 책임없는 당신을 위한 기능!" + "\n딱딱이에게 가르친 단어를 잊게할 수 있습니다.")
							.addField("리스트 :", "지금까지 배운 단어를 보여줍니다.").addField("뭐하지, 뭐할까 :", "오늘 뭐할지 정해줍니다.")
							.addField("뭐해 :", "딱딱이의 현재 상태를 알려줍니다.").addField("놀아줘 :", "딱딱이가 어떻게 놀아줄 수 있는지 알려줍니다.")
							.addField("주인 or 주인이름 :", "개발자를 호출합니다.");
					send.sendMessage(embed1);
				} else if (mes.contains("프사")) {
					String replaced;
					Color c = new Color(142, 161, 191);
					embed1.setColor(c);
					try {
						replaced = mes.replace("딱딱아 프사", "");
						embed1.setImage(api.getUserById(replaced.replaceAll("\\W", "")).get().getAvatar());
						embed1.setFooter(userName, message.getAuthor().getAvatar());
						embed1.setTimestamp(Instant.now());
					} catch (Exception e) {
						e.printStackTrace();
					}
					send.sendMessage(embed1);
				} else {
					comment(mes, event);
				}
			}
		});
	}
}
